package com.example.jello.afterschool.backend;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jello.afterschool.R;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;


public class AfterSchoolApi {

    private final RequestQueue mRequestQueue;
    private final String mBaseUrl;

    public AfterSchoolApi(Context context){
        mRequestQueue = Volley.newRequestQueue(context);
        mBaseUrl = context.getString(R.string.base_url);
    }

    public void downloadData(String urlPath, Receiver<AfterSchoolResponse> listener) {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                mBaseUrl + urlPath,
                buildSuccessListener(listener),
                buildErrorListener(listener)
        );
        mRequestQueue.add(request);
    }

    private Response.ErrorListener buildErrorListener(Receiver<AfterSchoolResponse> listener) {
        return volleyError -> {
            volleyError.printStackTrace();
            listener.accept(AfterSchoolResponse.emptyResponse());
        };
    }

    private Response.Listener<String> buildSuccessListener(final Receiver<AfterSchoolResponse> listener) {
        return response -> {
            AfterSchoolResponse result = AfterSchoolResponse.parse(response);
            listener.accept(result);
        };
    }
}
