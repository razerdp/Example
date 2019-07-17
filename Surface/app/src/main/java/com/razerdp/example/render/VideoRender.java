package com.razerdp.example.render;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by 大灯泡 on 2019/7/17.
 */
public class VideoRender implements GLSurfaceView.Renderer {
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        initSurface(gl,config);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

    }

    @Override
    public void onDrawFrame(GL10 gl) {

    }


    private void initSurface(GL10 gl, EGLConfig config) {
        //background color
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    }
}
