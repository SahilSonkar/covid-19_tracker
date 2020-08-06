package com.example.covid19.Stats;


import retrofit2.Call;
import retrofit2.http.GET;

public interface Post {

    String BASE_URL="https://api.covid19india.org/";
    @GET("data.json")
    Call<preData> getpreData();
}
