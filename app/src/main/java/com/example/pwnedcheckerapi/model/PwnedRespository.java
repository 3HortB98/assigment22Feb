package com.example.pwnedcheckerapi.model;

import java.util.Observable;
import java.util.Observer;

public class PwnedRespository extends Observable implements Observer,DataSource {
    private final DataSource remoteDataSource;
    private  final DataSource localDataSource;

    public  PwnedRespository(DataSource remoteDataSource, DataSource localDataSource){
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }
    @Override
    public void getDomainData(String Domain) {
        remoteDataSource.setObserver(this);
        remoteDataSource.getDomainData(Domain);
    }

    @Override
    public void setObserver(Observer observer) {
        addObserver(observer);
    }

    @Override
    public void update(Observable o, Object result) {
        setChanged();
        notifyObservers(result);
    }
}
