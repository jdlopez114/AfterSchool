package com.example.jello.afterschool.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.jello.afterschool.parent.homeScreen.android.HomeScreenActivity;
import com.example.jello.afterschool.presenter.MainActivity;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.Receiver;
import com.jsjrobotics.defaultTemplate.lifecycle.functional.WeakReferenceSupplier;

import java.lang.ref.WeakReference;
import java.util.function.Consumer;

class LoginPresenter {
    private static final String PARENT = "parent";
    private static final String TEACHER = "teacher";
    private final WeakReferenceSupplier<LoginActivity> mActivity;
    private final WeakReferenceSupplier<LoginView> mView;

    LoginPresenter(LoginActivity activity, LoginView view) {
        mActivity = new WeakReferenceSupplier<>(activity);
        mView = new WeakReferenceSupplier<>(view);
        mView.get().ifPresent(v ->  v.setOnSubmitListener(buildSubmitListener()));

    }

    private Receiver<Void> buildSubmitListener() {
        return ignored -> {
            Optional<LoginView> optionalView = mView.get();
            Optional<LoginActivity> optionalActivity = mActivity.get();
            if (!(optionalActivity.isPresent() && optionalView.isPresent())) {
                return;
            }
            LoginView view = optionalView.get();
            LoginActivity activity = optionalActivity.get();
            String username = view.getUsernameText();
            String password = view.getPassword();
            handleLogin(activity, username, password);

        };
    }

    private void handleLogin(Activity activity, String username, String password) {
        if (username.toLowerCase().equals(PARENT) && !password.isEmpty()) {
            Intent intent = new Intent();
            intent.setClass(activity, HomeScreenActivity.class);
            activity.startActivity(intent);
        } else if (username.toLowerCase().equals(TEACHER) && !password.isEmpty()){
            Intent intent = new Intent();
            intent.setClass(activity, MainActivity.class);
            activity.startActivity(intent);
        } else {
            Toast.makeText(activity, "Invalid username or password", Toast.LENGTH_LONG).show();
        }
    }

}
