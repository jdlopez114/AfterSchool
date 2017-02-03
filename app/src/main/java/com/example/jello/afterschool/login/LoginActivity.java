package com.example.jello.afterschool.login;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jello.afterschool.R;

public class LoginActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        LinearLayout content = (LinearLayout) findViewById(R.id.content);
        LoginView mView = new LoginView(content);
        LoginPresenter mPresenter = new LoginPresenter(this, mView);
    }

}
