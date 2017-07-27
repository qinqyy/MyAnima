package com.example.yongyi.myanima.listmyself;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.yongyi.myanima.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ListActivity extends AppCompatActivity implements AbsListView.OnScrollListener {
    private ListView mlist;
    private List<String> listarry = new ArrayList<>();
    private MyAdapter mAdapter;
    private ScrollView mscrollview;
    private LinearLayout mll;
    private int index;
private Handler mHandler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mlist = (ListView) findViewById(R.id.list);
        mscrollview = (ScrollView) findViewById(R.id.scrollview);
        mll = (LinearLayout) findViewById(R.id.ll);

        getlist();
        mAdapter = new MyAdapter(this, listarry);
        mlist.setAdapter(mAdapter);
        getup();
        //mlist.setOnScrollListener(this);
        //mlist.setSelection(listarry.size());

        addview();
    }

    public void addview() {
        TextView textView = new TextView(this);
        textView.setText("Text View " + 1);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        mll.addView(textView, p);

        Button buttonView = new Button(this);
        buttonView.setText("Button " + 2);
        mll.addView(buttonView, p);

        Button buttonView1 = new Button(this);
        buttonView.setText("Button " + 3);
        mll.addView(buttonView1, p);

        Button buttonView2 = new Button(this);
        buttonView.setText("Button " + 4);
        mll.addView(buttonView2, p);

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                int off = mll.getMeasuredHeight() - mscrollview.getHeight();   //计算移动量
                if (off > 0) {
                    mscrollview.scrollTo(0, off);   //自动移动
                }
            }
        });
    }

    public void getlist() {
        for (int i = 0; i < 7; i++) {
            listarry.add("数据" + i);
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        if (firstVisibleItem <= 2) { //到顶部添加数据
            mlist.setSelection(listarry.size() + 2);
        } else if (firstVisibleItem + visibleItemCount > mAdapter.getCount() - 2) {//到底部添加数据
            mlist.setSelection(firstVisibleItem - listarry.size());
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
                        if (index > mlist.getCount()) {
                            index = 0;
//                            if(isone){
                            autoUpdate.cancel();
//                            }
//                            isone=true;
                        }
                        mlist.smoothScrollToPosition(index);
                    }
                });
            }
        }, 0, 100);
    }



}
