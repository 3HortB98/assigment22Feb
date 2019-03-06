package com.example.pwnedcheckerapi.model;

import android.widget.Toast;

import com.example.pwnedcheckerapi.Constants;
import com.example.pwnedcheckerapi.DomainRepo;
import com.example.pwnedcheckerapi.PwnedService;
import com.example.pwnedcheckerapi.home.MainActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource extends Observable implements DataSource {

    private final PwnedService pwnedService;
    public RemoteDataSource(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = retrofitBuilder.build();

        pwnedService = retrofit.create(PwnedService.class);

    }

    @Override
    public void getDomainData(String Domain) {
        final List<DomainRepo> domains = new ArrayList<>();
        pwnedService.getDomain(Domain).enqueue(new Callback<List<DomainRepo>>() {
            @Override
            public void onResponse(Call<List<DomainRepo>> call, Response<List<DomainRepo>> response) {
                if(response.isSuccessful() && response.body()!= null){
                    domains.clear();
                    domains.addAll(response.body());
                    setChanged();
                    notifyObservers(domains);

                }
            }

            @Override
            public void onFailure(Call<List<DomainRepo>> call, Throwable t) {
                t.fillInStackTrace();
            }
        });
    }

    @Override
    public void setObserver(Observer observer) {
        addObserver(observer);
    }
}
