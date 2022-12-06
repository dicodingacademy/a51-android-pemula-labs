package com.dicoding.picodiploma.myviewandviewgroup;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.dicoding.picodiploma.myviewandviews.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Google Pixel");
        }
    }
}
