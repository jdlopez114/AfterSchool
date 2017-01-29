package com.example.jello.afterschool.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.model.AfterSchoolResponse;
import com.example.jello.afterschool.network.APIService;
import com.example.jello.afterschool.network.RetroHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by jello on 1/29/17.
 */

public class FragViewHelper {

    private RecyclerView teacherRV;
    private View root;

    public FragViewHelper() {
    }

    public FragViewHelper(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_recycler_view, viewGroup, false);
        teacherRV = (RecyclerView) viewGroup.findViewById(R.id.recycler_view);
    }

    public View returnView(){
        return root;
    }

    public AfterSchoolResponse getFullResponse() {

        Retrofit retrofit = RetroHelper.getInstance();

        final AfterSchoolResponse[] rr = new AfterSchoolResponse[1];
        APIService service = retrofit.create(APIService.class);

        Call<AfterSchoolResponse> call = service.getResponse();
        call.enqueue(new Callback<AfterSchoolResponse>() {

            @Override
            public void onResponse(Call<AfterSchoolResponse> call, Response<AfterSchoolResponse> response) {
                rr[0] = response.body();
            }

            @Override
            public void onFailure(Call<AfterSchoolResponse> call, Throwable t) {
            }
        });
        return rr[0];
    }

}

