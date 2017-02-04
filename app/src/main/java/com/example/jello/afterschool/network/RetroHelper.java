package com.example.jello.afterschool.network;

import android.content.Context;
import android.util.Log;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.model.AfterSchoolResponse;
import com.example.jello.afterschool.model.Children;
import com.example.jello.afterschool.adapters.HomeAdapter;
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

    private RetroHelper() {
    }

    public static String getUrl(Context context, String path) {
        return context.getString(R.string.base_url) + path;
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
                            // passed in interface to get response
    public static void makeChildrenNetworkCall(Retrofit retrofit, final RetrofitChildrenListener listener) { // cant call until it retrieves something
        APIService service = retrofit.create(APIService.class); // pass in callback

        Call<AfterSchoolResponse> call = service.getResponse();
        call.enqueue(new Callback<AfterSchoolResponse>() {

            @Override
            public void onResponse(Call<AfterSchoolResponse> call, Response<AfterSchoolResponse> response) {
                childrenList = response.body().getChildren(); // assign first then pass
                listener.setChildrenList(childrenList);
                Log.d("children", "onResponse: " + childrenList.size());
            }

            @Override
            public void onFailure(Call<AfterSchoolResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public interface RetrofitChildrenListener{
        void setChildrenList(List<Children> childrenList); // pass in
    }

}
