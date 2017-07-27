package com.example.yongyi.myanima;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

public class PropertyActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView imageView;
    private ObjectAnimator objectAnimator;
    private  ValueAnimator valueAnimator;
private ImageView imageView2;
    public void init(){
        imageView=(ImageView) findViewById(R.id.image_proper);
        imageView2=(ImageView) findViewById(R.id.image_properva);
        PropertyValuesHolder holder=PropertyValuesHolder.ofFloat("translationX",400);
        PropertyValuesHolder holder1=PropertyValuesHolder.ofFloat("ImageAlpha",0.5f);
        PropertyValuesHolder holder2=PropertyValuesHolder.ofInt("background",0xffffffff);
        //objectAnimator=ObjectAnimator.ofPropertyValuesHolder(imageView,holder,holder1,holder2);
       // objectAnimator=ObjectAnimator.ofFloat(imageView,"Alpha",0.5f);
        objectAnimator=ObjectAnimator.ofArgb(imageView,"background",0xffffffff);
        objectAnimator.setInterpolator(new DecelerateInterpolator());
        objectAnimator.setRepeatCount(1);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.setDuration(1000).start();

        valueAnimator=ValueAnimator.ofFloat(180);
        valueAnimator.setTarget(imageView2);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float h=imageView2.getHeight();
                float aa=(float)valueAnimator.getAnimatedValue();
              imageView2.setPivotX(imageView2.getWidth());
                imageView2.setPivotY(h);
              // imageView2.setRotationY(aa);
                imageView2.setRotationX(-aa);

            }
        });
        valueAnimator.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
          init();
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this,"WWW",Toast.LENGTH_SHORT).show();
    }
}
