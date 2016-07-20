package com.example.autotaal.testandroidplayer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.VideoView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends Activity {

    private FrameLayout mainFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        mainFrameLayout = (FrameLayout) findViewById(R.id.MainFrameLayout);

        mainFrameLayout.removeAllViewsInLayout();


createViews();

    }

    private void createViews()
    {
        try {

            //Uri bla = Uri.parse("http://download.openbricks.org/sample/H264/big_buck_bunny_1080p_H264_AAC_25fps_7200K.MP4");
            Uri bla = Uri.parse("http://dump.autotaal.biz/bunny1080.mp4");
            //Uri bla = Uri.parse("http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4");
            //Uri bla = Uri.parse("http://192.168.168.116:8080/bunny1080.mp4");

            VideoView myVideoView = new VideoView(this);
            mainFrameLayout.addView(myVideoView);

            myVideoView.setVideoURI(bla);

            // Do repeat
            myVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    myVideoView.seekTo(0);
                    myVideoView.start();
                }
            });

            myVideoView.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
