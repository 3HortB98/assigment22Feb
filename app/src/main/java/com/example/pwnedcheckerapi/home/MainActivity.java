package com.example.pwnedcheckerapi.home;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pwnedcheckerapi.DomainRepo;
import com.example.pwnedcheckerapi.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
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

        final HomeViewModel homeViewModel = new HomeViewModel();
        homeViewModel.getDomainLiveData().observe(this, new Observer<List<DomainRepo>>() {
            @Override
            public void onChanged(@Nullable List<DomainRepo> domainRepos) {
                domainAdapter.setData(domainRepos);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeViewModel.getDomain(etInput.getText().toString());
            }
        });

    }
}
