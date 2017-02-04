package com.example.jello.afterschool.network;

import android.content.Context;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.model.AfterSchoolResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("/cgi-bin/afterschool_parent_homepage.pl/") // end point is after the first slash
    Call<AfterSchoolResponse> getResponse();

    public static String getUrl(Context context, String path) {
        return context.getString(R.string.base_url) + path;
    }

}
