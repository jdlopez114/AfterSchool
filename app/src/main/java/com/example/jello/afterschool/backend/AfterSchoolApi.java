package com.example.jello.afterschool.backend;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jello.afterschool.R;
import com.example.jello.afterschool.backend.child.AfterSchoolChildResponse;
import com.example.jello.afterschool.backend.parent.AfterSchoolParentResponse;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;


public class AfterSchoolApi {

    private final RequestQueue mRequestQueue;
    private final String mBaseUrl;

    public AfterSchoolApi(Context context){
        mRequestQueue = Volley.newRequestQueue(context);
        mBaseUrl = context.getString(R.string.base_url);
    }

    public static String getUrl(Context context, String path) {
        return context.getString(R.string.base_url) + path;
    }

    public void downloadParentHompage(String urlPath, Receiver<AfterSchoolParentResponse> listener) {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                mBaseUrl + urlPath,
                buildParentSuccessListener(listener),
                buildParentErrorListener(listener)
        );
        mRequestQueue.add(request);
    }

    private Response.ErrorListener buildParentErrorListener(Receiver<AfterSchoolParentResponse> listener) {
        return volleyError -> {
            volleyError.printStackTrace();
            listener.accept(AfterSchoolParentResponse.emptyResponse());
        };
    }

    private Response.Listener<String> buildParentSuccessListener(final Receiver<AfterSchoolParentResponse> listener) {
        return response -> {
            AfterSchoolParentResponse result = AfterSchoolParentResponse.parse(response);
            listener.accept(result);
        };
    }

    public void downloadChildDetail(String urlPath, Receiver<AfterSchoolChildResponse> listener) {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                mBaseUrl + urlPath,
                buildChildSuccessListener(listener),
                buildChildErrorListener(listener)
        );
        mRequestQueue.add(request);
    }

    private Response.ErrorListener buildChildErrorListener(Receiver<AfterSchoolChildResponse> listener) {
        return volleyError -> {
            volleyError.printStackTrace();
            listener.accept(AfterSchoolChildResponse.emptyResponse());
        };
    }

    private Response.Listener<String> buildChildSuccessListener(Receiver<AfterSchoolChildResponse> listener) {
        return response -> {
            AfterSchoolChildResponse result = AfterSchoolChildResponse.parse(response);
            listener.accept(result);
        };
    }
}
