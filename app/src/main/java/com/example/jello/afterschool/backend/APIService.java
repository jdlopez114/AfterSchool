package com.example.jello.afterschool.backend;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jello on 1/28/17.
 */

public interface APIService {

    @GET("/cgi-bin/afterschool_parent_homepage.pl") // end point is after the first slash
    Call<APIResponse> getAnimals();

}
