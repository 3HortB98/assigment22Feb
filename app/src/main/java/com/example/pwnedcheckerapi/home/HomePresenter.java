package com.example.pwnedcheckerapi.home;

import com.example.pwnedcheckerapi.DomainRepo;
import com.example.pwnedcheckerapi.model.DataSource;
import com.example.pwnedcheckerapi.home.HomeContract.View;
import com.example.pwnedcheckerapi.model.RemoteDataSource;

import java.util.List;

public class HomePresenter implements HomeContract.Presenter, DataSource.DataObserver {
    private  View view;
    public HomePresenter(View view){
        this.view = view;
    }
    @Override
    public void getDomainPass(String domain) {
        DataSource dataSource =  new RemoteDataSource(this);
        if (domain.isEmpty()){
            view.showError("domain cannot be empty");
        }
        dataSource.getDomainData(domain);
    }

    @Override
    public void onSuccess(List<DomainRepo> result) {
        view.showData(result);
    }

    @Override
    public void onFailure(String error) {
        view.showError(error);
    }
}
