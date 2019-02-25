package com.example.pwnedcheckerapi.model;

import android.widget.Toast;

import com.example.pwnedcheckerapi.Constants;
import com.example.pwnedcheckerapi.DomainRepo;
import com.example.pwnedcheckerapi.PwnedService;
import com.example.pwnedcheckerapi.home.MainActivity;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource implements DataSource {
    private DataObserver listener;
    public RemoteDataSource(DataObserver listener){
        this.listener = listener;
    }

    @Override
    public void getDomainData(String Domain) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = retrofitBuilder.build();

        PwnedService pwnedService = retrofit.create(PwnedService.class);

        pwnedService.getDomain(Domain).enqueue(new Callback<List<DomainRepo>>() {
            @Override
            public void onResponse(Call<List<DomainRepo>> call, Response<List<DomainRepo>> response) {

                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<DomainRepo>> call, Throwable t) {
                listener.onFailure("Network failure");
            }
        });
    }
}
