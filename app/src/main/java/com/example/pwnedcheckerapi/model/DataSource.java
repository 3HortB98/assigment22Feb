package com.example.pwnedcheckerapi.model;


import com.example.pwnedcheckerapi.DomainRepo;

import java.util.List;
import java.util.Observer;

public interface DataSource {
            void getDomainData(String Domain);
            void setObserver(Observer observer);


    }

