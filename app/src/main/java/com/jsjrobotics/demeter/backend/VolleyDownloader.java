package com.jsjrobotics.demeter.backend;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.example.jello.afterschool.backend.AfterSchoolResponse;


public class VolleyDownloader {

    private final RequestQueue mRequestQueue;

    public VolleyDownloader(Context context){
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public void downloadData(final String url, final Receiver<Optional<String>> listener) {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                response -> listener.accept(Optional.of(response)),
                buildErrorListener(listener)
        );
        mRequestQueue.add(request);
    }

    public void downloadData(final String url,
                             final Response.Listener<String> successListener,
                             final Response.ErrorListener failureListener) {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                successListener,
                failureListener
        );
        mRequestQueue.add(request);
    }

    private Response.ErrorListener buildErrorListener(final Receiver<Optional<String>> listener) {
        return volleyError -> {
            volleyError.printStackTrace();
            listener.accept(Optional.empty());
        };
    }

    private Response.Listener<String> buildSuccessListener(final Receiver<AfterSchoolResponse> listener) {
        return response -> {
            AfterSchoolResponse result = AfterSchoolResponse.parse(response);
            listener.accept(result);
        };
    }
}
