package com.example.autotaal.testandroidplayer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.PowerManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
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

        //PowerManager powerManager = (PowerManager)context

    }

    private void createViews()
    {
        try {

            //
            // Create video player
            //

            Uri bla = Uri.parse("http://dump.autotaal.biz/bunny1080.mp4");

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

            //
            // Add transparent panel
            //

            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1920, 80);

            RelativeLayout tickerPanel = new RelativeLayout(this);
            tickerPanel.setLayoutParams(layoutParams);
            tickerPanel.setX(0);
            tickerPanel.setY(1000);
            tickerPanel.setBackgroundColor(Color.WHITE);
            tickerPanel.setAlpha(0.5f);


            mainFrameLayout.addView(tickerPanel);



            //
            // Add ticker tape text
            //

            TextView text = new TextView(this);
            mainFrameLayout.addView(text);

            text.setText("Dit is een testbericht voor een tickertape in Android");
            text.setY(1000);
            text.setTextColor(Color.BLACK);
            text.setTextSize(18);

            float textWidth = 0;

            text.measure(0, 0);
            textWidth = text.getMeasuredWidth();


            TranslateAnimation animation = new TranslateAnimation(1920, -1 * textWidth, 0, 0);
            animation.setDuration(20000);
            animation.setRepeatMode(Animation.RESTART);
            animation.setRepeatCount(Animation.INFINITE);
            animation.setInterpolator(new LinearInterpolator());

            text.setAnimation(animation);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
