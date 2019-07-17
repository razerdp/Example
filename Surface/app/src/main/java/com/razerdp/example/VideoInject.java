package com.razerdp.example;

import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by 大灯泡 on 2019/7/17.
 */
public class VideoInject {
    private MediaPlayer mPlayer;
    private boolean pendingPlay;
    private String videoPath;
    private int rawid;
    private SurfaceView surfaceView;

    public void injectSurfaceView(SurfaceView surfaceView) {
        this.surfaceView = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        holder.addCallback(cb);
    }


    private SurfaceHolder.Callback cb = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            checkAndInitMedia(holder);
            if (pendingPlay) {
                if (rawid != 0) {
                    playVideo(rawid);
                } else if (!TextUtils.isEmpty(videoPath)) {
                    playVideo(videoPath);
                }
                pendingPlay = false;
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            if (mPlayer == null) return;
            if (mPlayer.isPlaying()) {
                mPlayer.stop();
            }
            mPlayer.release();
        }
    };

    private void checkAndInitMedia(SurfaceHolder holder) {
        if (mPlayer != null) return;
        mPlayer = new MediaPlayer();
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mPlayer.setDisplay(holder);
        mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    public void playVideo(int rawid) {
        if (rawid == 0) return;
        if (mPlayer == null) {
            pendingPlay = true;
            this.rawid = rawid;
            return;
        }
        try {
            AssetFileDescriptor tFd = surfaceView.getResources().openRawResourceFd(rawid);
            mPlayer.setDataSource(tFd.getFileDescriptor(), tFd.getStartOffset(), tFd.getLength());
            mPlayer.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playVideo(String path) {
        if (mPlayer == null) {
            pendingPlay = true;
            videoPath = path;
            return;
        }
        try {
            mPlayer.setDataSource(path);
            mPlayer.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
