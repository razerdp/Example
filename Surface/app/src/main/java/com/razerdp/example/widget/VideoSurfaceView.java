package com.razerdp.example.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * Created by 大灯泡 on 2019/7/17.
 */
public class VideoSurfaceView extends SurfaceView {
    private static final String TAG = "VideoSurfaceView";


    public VideoSurfaceView(Context context) {
        this(context, null);
    }

    public VideoSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VideoSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
