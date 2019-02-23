package com.example.pwnedcheckerapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.pwnedcheckerapi.Constants.BASE_URL;
import static com.example.pwnedcheckerapi.Constants.ENDPOINT;

public interface PwnedService {
    @GET(ENDPOINT)
    Call<List<DomainRepo>> getDomain(@Query("domain")String domain);
}
