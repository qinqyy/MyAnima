package com.example.yongyi.myanima;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextView all;
    private TextView rotate;
    private TextView scale;
    private  TextView translate;
    private TextView aphla;
    private RotateAnimation rotateAnimation;
    private ScaleAnimation scaleAnimation;
    private TranslateAnimation translateAnimation;
    private AlphaAnimation alphaAnimation;
    private ImageView imageView;
    public void init(){
        all=(TextView) findViewById(R.id.all);
        rotate=(TextView) findViewById(R.id.rotate);
        scale=(TextView) findViewById(R.id.scale);
        translate=(TextView) findViewById(R.id.translate);
        aphla=(TextView) findViewById(R.id.alpha);
        imageView=(ImageView) findViewById(R.id.imageview);
        rotateAnimation = new RotateAnimation(0,45);//顺时针旋转45度
        scaleAnimation=new ScaleAnimation(0,5,0,5);//横向放大5倍，纵向放大5倍
        translateAnimation=new TranslateAnimation(0,300,0,0);//横向移动300个单位
        alphaAnimation=new AlphaAnimation(1,0);//重不透明变成透明

        rotateAnimation.setDuration(2000);
        scaleAnimation.setDuration(2000);
        translateAnimation.setDuration(2000);
        alphaAnimation.setDuration(2000);

        rotateAnimation.setInterpolator(new AccelerateInterpolator());
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setInterpolator(new BounceInterpolator());
        alphaAnimation.setInterpolator(new AnticipateInterpolator());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public void onClick(View view) {
                    int id=view.getId();
        switch (id){
            case R.id.rotate:
                rotate.startAnimation(rotateAnimation);
                break;
            case R.id.scale:
                scale.startAnimation(scaleAnimation);
                break;
            case R.id.translate:
                translate.startAnimation(translateAnimation);
                break;
            case R.id.alpha:
                aphla.startAnimation(alphaAnimation);
                break;
            case R.id.bnt_run:
                AnimationSet animationSet=new AnimationSet(false);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(alphaAnimation);
                all.startAnimation(animationSet);
                break;
            case R.id.imageview:
                Animation animation= AnimationUtils.loadAnimation(ViewActivity.this,R.anim.anim);
                imageView.startAnimation(animation);
                break;
            case R.id.frame_bnt:
                Intent intent=new Intent(ViewActivity.this,FrameActivity.class);
                startActivity(intent);
                break;
            case R.id.property_bnt:
                Intent intent1=new Intent(ViewActivity.this,PropertyActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
