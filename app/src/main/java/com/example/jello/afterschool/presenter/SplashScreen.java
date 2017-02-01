package com.example.jello.afterschool.presenter;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.example.jello.afterschool.R;
import com.felipecsl.gifimageview.library.GifImageView;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;

public class SplashScreen extends AppCompatActivity {

    private GifImageView gifImageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        gifImageView = (GifImageView) findViewById(R.id.gifImageView);
//        progressBar = (ProgressBar) findViewById(R.id.progressBar);
//        progressBar.setVisibility(progressBar.VISIBLE);


        // set gifimageview resource
        try {
            InputStream inputStream = getAssets().open("bart_splash.gif");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();

        } catch (IOException e) {
//            e.printStackTrace();
        }
        // wait 3 seconds then start activity main
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                SplashScreen.this.startActivity(new Intent(SplashScreen.this, MainActivity.class));
                SplashScreen.this.finish();
            }
        }, 3000); //3 secs
    }
}
