package com.example.pwnedcheckerapi.home;

import com.example.pwnedcheckerapi.DomainRepo;

import java.util.List;

public interface HomeContract {
    interface View{
        void showData(List<DomainRepo> result);
        void showError(String error);
        void showProgress();
        void hideProgress();
    }

    interface Presenter{
        void getDomainPass(String domain);
    }

}
