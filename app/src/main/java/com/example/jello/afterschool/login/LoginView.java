package com.example.jello.afterschool.login;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.jello.afterschool.R;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;

class LoginView {
    private final EditText mUsername;
    private final EditText mPassword;
    private final Button mSubmit;
    private final LinearLayout mRoot;

    LoginView(LinearLayout content) {
        mRoot = content;
        mUsername = (EditText) content.findViewById(R.id.username);
        mPassword = (EditText) content.findViewById(R.id.password);
        mSubmit = (Button) content.findViewById(R.id.submit);
    }

    public void setOnSubmitListener(Receiver<Void> listener) {
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.accept(null);
            }
        });
    }

    public String getUsernameText() {
        return mUsername.getText().toString();
    }

    public String getPassword() {
        return mPassword.getText().toString();
    }

    public Context getContext() {
        return mRoot.getContext();
    }
}
