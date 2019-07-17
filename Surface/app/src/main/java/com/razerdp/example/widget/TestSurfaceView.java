package com.razerdp.example.widget;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

/**
 * Created by 大灯泡 on 2019/7/17.
 */
public class TestSurfaceView extends GLSurfaceView {
    private static final String TAG = "TestSurfaceView";


    public TestSurfaceView(Context context) {
        super(context);
    }

    public TestSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
