package com.example.pwnedcheckerapi.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.pwnedcheckerapi.DomainRepo;
import com.example.pwnedcheckerapi.model.DataSource;
import com.example.pwnedcheckerapi.model.LocalDataSource;
import com.example.pwnedcheckerapi.model.PwnedRespository;
import com.example.pwnedcheckerapi.model.RemoteDataSource;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class HomeViewModel implements Observer {
   final DataSource pwnedRespository;

   private final MutableLiveData<List<DomainRepo>> domainLiveData = new MutableLiveData<>();
   public  HomeViewModel(){
       pwnedRespository = new PwnedRespository(new RemoteDataSource(), new LocalDataSource());
   }
   public LiveData<List<DomainRepo>> getDomainLiveData(){
       return domainLiveData;
   }

   public void getDomain(String value){
       pwnedRespository.setObserver(this);
       pwnedRespository.getDomainData(value);

   }
    @Override
    public void update(Observable o, Object result) {
        List<DomainRepo> domains = (List<DomainRepo>) result;
        domainLiveData.setValue(domains);
    }
}
