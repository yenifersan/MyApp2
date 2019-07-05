package com.example.myapp.activities;

import com.example.myapp.activities.models.Compra;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    String API_BASE_URL = "http://192.168.1.245:9093";

    @GET("api/compras/")
    Call<List<Compra>>getCompras();

    @GET("api/compra/{1}")
    Call<Compra>showCompra(@Path("id")Integer id);

}
















