package com.example.jello.afterschool.network;

import android.util.Log;

import com.example.jello.afterschool.model.AfterSchoolResponse;
import com.example.jello.afterschool.model.Children;
import com.example.jello.afterschool.presenter.HomeAdapter;
import com.example.jello.afterschool.view.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroHelper {

    public static final String BASE_URL = "http://jsjrobotics.nyc/";

    private static Retrofit instance;
    private static HomeAdapter homeAdapter;
    private static List<Children> childrenList = new ArrayList<>();
    private static AfterSchoolResponse response = new AfterSchoolResponse();
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

    public static List<Children> getFullResponse(Retrofit retrofit) {
        APIService service = retrofit.create(APIService.class);

        Call<AfterSchoolResponse> call = service.getResponse();
        call.enqueue(new Callback<AfterSchoolResponse>() {

            @Override
            public void onResponse(Call<AfterSchoolResponse> call, Response<AfterSchoolResponse> response) {

                childrenList = response.body().getChildren();
                Log.d("children", "onResponse: " + childrenList.size());

            }

            @Override
            public void onFailure(Call<AfterSchoolResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return childrenList;
    }
}