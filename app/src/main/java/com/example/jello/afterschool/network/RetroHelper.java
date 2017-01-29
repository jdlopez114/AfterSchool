package com.example.jello.afterschool.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroHelper {

    public static final String BASE_URL = "http://jsjrobotics.nyc/";

    private static Retrofit instance;
//    List<Parent> parentList = new ArrayList<>();
//    List<Teacher> teacherList = new ArrayList<>();

    public RetroHelper() {
    }

    public static Retrofit getInstance() {

        if (instance == null) {
            instance = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
