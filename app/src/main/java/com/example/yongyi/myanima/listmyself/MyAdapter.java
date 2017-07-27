package com.example.yongyi.myanima.listmyself;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.yongyi.myanima.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Create by DELL
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date Create on 2017/7/10 10:38.
 */

public class MyAdapter extends BaseAdapter {
    private Context mcon;
    private List<String> mlist;

    public MyAdapter(Context con, List<String> list) {
        mcon = con;
        mlist = list;
    }

    /**
     * 将数据循环展示3遍
     *
     * @return
     */
    @Override
    public int getCount() {
        if (mlist != null) {
            return mlist.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {

        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hodler hodler = null;
        if (convertView == null) {
            hodler = new Hodler();
            convertView = LayoutInflater.from(mcon).inflate(R.layout.itme, null);
            hodler.tv = (TextView) convertView.findViewById(R.id.tv_itme);
            convertView.setTag(hodler);
        } else {
            hodler = (Hodler) convertView.getTag();
        }
        hodler.tv.setText(mlist.get(position));
        return convertView;
    }

    class Hodler {
        TextView tv;
    }
}
