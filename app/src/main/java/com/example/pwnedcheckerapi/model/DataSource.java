package com.example.pwnedcheckerapi.model;


import com.example.pwnedcheckerapi.DomainRepo;

import java.util.List;

public interface DataSource {



            void getDomainData(String Domain);


        interface DataObserver{
            void onSuccess(List<DomainRepo> result);
            void onFailure(String error);
        }
    }

