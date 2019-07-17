package com.razerdp.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.razerdp.example.widget.TestSurfaceView;

public class MainActivity extends AppCompatActivity {

    private TestSurfaceView videoSurface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
    }
}
