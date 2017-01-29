package com.example.jello.afterschool.view.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.jello.afterschool.R;

public class ChatFragment extends Fragment { // keep fragments as small as possible

    TextView studentName;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        studentName = (TextView) view.findViewById(R.id.children_name);

    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return new ChatViewHelper(inflater, container, savedInstanceState).returnView();
//    }


}
