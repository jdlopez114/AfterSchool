package com.example.jello.afterschool.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.jello.afterschool.R;
import com.example.jello.afterschool.model.AfterSchoolResponse;
import com.example.jello.afterschool.model.Children;
import com.example.jello.afterschool.network.APIService;
import com.example.jello.afterschool.network.Retro;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class StudentsFragment extends Fragment { // keep fragments as small as possible

    List<Children> childrenList = new ArrayList<>();
    TextView studentName;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        studentName = (TextView) view.findViewById(R.id.children_name);

        Retrofit retrofit = Retro.getInstance();

        APIService service = retrofit.create(APIService.class);

        Call<AfterSchoolResponse> call = service.getResponse();
        call.enqueue(new Callback<AfterSchoolResponse>() {

            @Override
            public void onResponse(Call<AfterSchoolResponse> call, Response<AfterSchoolResponse> response) {
                AfterSchoolResponse rr = response.body();
                childrenList = rr.getChildren();
                studentName.setText(childrenList.get(0).getName());
            }

            @Override
            public void onFailure(Call<AfterSchoolResponse> call, Throwable t) {
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.student_view, container, false);


    }


}
