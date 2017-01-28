package com.example.jello.afterschool;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MenuFragment extends Fragment {
    private static final String ARG_TEXT = "arg_text";
    private static final String ARG_COLOR = "arg_color";

    private String text;
    private int color;

    private View mContent;
    private TextView mTextView;

    public static Fragment newInstance(String text, int color) {
        Fragment frag = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        args.putInt(ARG_COLOR, color);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // retrieve text and color from bundle or savedInstanceState
        if (savedInstanceState == null) {
            Bundle args = getArguments();
            text = args.getString(ARG_TEXT);
            color = args.getInt(ARG_COLOR);
        } else {
            text = savedInstanceState.getString(ARG_TEXT);
            color = savedInstanceState.getInt(ARG_COLOR);
        }

        // initialize views
        mContent = view.findViewById(R.id.fragment_content);
        mTextView = (TextView) view.findViewById(R.id.text);

        // set text and background color
        mTextView.setText(text);
        mContent.setBackgroundColor(color);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(ARG_TEXT, text);
        outState.putInt(ARG_COLOR, color);
        super.onSaveInstanceState(outState);
    }
}