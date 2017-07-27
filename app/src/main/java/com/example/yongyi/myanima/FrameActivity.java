package com.example.yongyi.myanima;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class FrameActivity extends AppCompatActivity {
private ImageView imageView;
    private AnimationDrawable drawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        imageView=(ImageView)findViewById(R.id.frame_image);
        imageView.setBackgroundResource(R.drawable.anim_frame);
        drawable=(AnimationDrawable) imageView.getBackground();
        drawable.addFrame(getResources().getDrawable(R.drawable.qt5),2000);// 动态添加帧
        drawable.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        drawable.start();
    }
}
