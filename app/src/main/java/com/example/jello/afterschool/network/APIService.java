package com.example.jello.afterschool.network;

import com.example.jello.afterschool.model.AfterSchoolResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("/cgi-bin/afterschool_parent_homepage.pl/") // end point is after the first slash
    Call<AfterSchoolResponse> getResponse();

}
