package com.example.myapp.activities;

import com.example.myapp.activities.models.Compra;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    String API_BASE_URL = "http://192.168.1.245:9094";

    @GET("/compras")
    Call<List<Compra>>getCompras();




    @GET("/compras/{1}")
    Call<Compra>showCompra(@Path("id")Integer id);


}