package com.example.pwnedcheckerapi.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pwnedcheckerapi.Constants;
import com.example.pwnedcheckerapi.DomainAdapter;
import com.example.pwnedcheckerapi.DomainRepo;
import com.example.pwnedcheckerapi.PwnedService;
import com.example.pwnedcheckerapi.R;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etInput;
    Button btnSearch;
    DomainAdapter domainAdapter = new DomainAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput = findViewById(R.id.etDomain);
        btnSearch = findViewById(R.id.btnSearch);

        RecyclerView recyclerView = findViewById(R.id.rvData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration divider = new DividerItemDecoration(this,linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(divider);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(domainAdapter);
        btnSearch.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSearch:
                handleSearchClick();
                break;

        }
    }

    public void handleSearchClick(){
        String etDomain = etInput.getText().toString();

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

        pwnedService.getDomain(etDomain).enqueue(new Callback<List<DomainRepo>>() {
            @Override
            public void onResponse(Call<List<DomainRepo>> call, Response<List<DomainRepo>> response) {
                if(response.isSuccessful()){
                    domainAdapter.setData(response.body());
                }else{
                    Toast.makeText(MainActivity.this,"No results found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<DomainRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Network failure", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
