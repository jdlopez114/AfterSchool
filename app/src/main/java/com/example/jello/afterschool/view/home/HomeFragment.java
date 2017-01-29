package com.example.jello.afterschool.view.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.model.AfterSchoolResponse;
import com.example.jello.afterschool.model.Teacher;
import com.example.jello.afterschool.network.APIService;
import com.example.jello.afterschool.network.RetroHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment {

//    Teacher teacherList = new Teacher();
    TextView teacherView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        teacherView = (TextView) view.findViewById(R.id.teach_view);
        AfterSchoolResponse afterSchoolResponse = RetroHelper.getFullResponse();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_view, container, false);
    }
}
