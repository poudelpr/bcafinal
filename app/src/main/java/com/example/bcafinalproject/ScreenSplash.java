package com.example.bcafinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ScreenSplash extends AppCompatActivity {
    private static final int Splash_DURATION = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_screen_splash);
        ImageView img = findViewById(R.id.logo_image);
        ImageView image = findViewById(R.id.text);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(ScreenSplash.this,HereStart.class);
                startActivity(intent);
                finish();
            }
        }, Splash_DURATION);
    }
}