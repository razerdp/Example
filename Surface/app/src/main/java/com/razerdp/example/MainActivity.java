package com.razerdp.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.razerdp.example.widget.VideoSurfaceView;

public class MainActivity extends AppCompatActivity {

    private VideoSurfaceView videoSurface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        videoSurface = findViewById(R.id.video_surface);

        VideoInject videoInject = new VideoInject();
        videoInject.injectSurfaceView(videoSurface);
        videoInject.playVideo(R.raw.test);
    }
}
