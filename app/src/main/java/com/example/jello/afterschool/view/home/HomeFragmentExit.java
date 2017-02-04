package com.example.jello.afterschool.view.home;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jello.afterschool.R;
import com.example.jello.afterschool.model.Children;
import com.example.jello.afterschool.network.APIService;
import com.squareup.picasso.Picasso;

public class HomeFragmentExit extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        String actionTitle = "";
        Bitmap imageBitmap = null;
        String transText = "";
        String transitionName = "";

        if (bundle != null) {
            transitionName = bundle.getString("TRANS_NAME");
            actionTitle = bundle.getString("ACTION");
            imageBitmap = bundle.getParcelable("IMAGE");
            transText = bundle.getString("TRANS_TEXT");
        }

        getActivity().setTitle(actionTitle);
        View view = inflater.inflate(R.layout.selected_student_view, container, false);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.findViewById(R.id.imageView).setTransitionName(transitionName);
            view.findViewById(R.id.textView).setTransitionName(transText);
        }

        ((ImageView) view.findViewById(R.id.imageView)).setImageBitmap(imageBitmap);
        ((TextView) view.findViewById(R.id.textView)).setText(actionTitle);

        return view;
    }


//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        ImageView image = (ImageView) view.findViewById(R.id.image);
//
//    }
}