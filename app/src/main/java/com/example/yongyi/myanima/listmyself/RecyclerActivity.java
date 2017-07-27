package com.example.yongyi.myanima.listmyself;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yongyi.myanima.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class RecyclerActivity extends AppCompatActivity {
private RecyclerView mrecyview;
    private RecyAdapter mAdapter;
    private List<String> listarry = new ArrayList<>();
    private int index;
    private Handler mHandler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        mrecyview=(RecyclerView)findViewById(R.id.recycler);
        getlist();
        mrecyview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        mAdapter=new RecyAdapter(this,listarry);
        mrecyview.setAdapter(mAdapter);
        getup();
    }
    public void getlist() {
        for (int i = 0; i < 10; i++) {
            listarry.add("数据" + i);
        }
    }

    Timer autoUpdate = new Timer();

    public void getup() {
        autoUpdate.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        index += 1;
                        if (index > listarry.size()) {
                            index = 0;
//                            if(isone){
                           autoUpdate.cancel();
//                            }
//                            isone=true;
                        }
                        mrecyview.smoothScrollToPosition(index);
                    }
                });
            }
        }, 0, 100);
    }
}
