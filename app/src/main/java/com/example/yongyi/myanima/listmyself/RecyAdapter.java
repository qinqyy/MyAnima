package com.example.yongyi.myanima.listmyself;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yongyi.myanima.R;

import java.util.List;

/**
 * @author Create by DELL
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date Create on 2017/7/10 14:18.
 */

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.Hodler> {
    private Context mcon;
    private List<String> mlist;

    public RecyAdapter(Context con, List<String> list) {
        mcon = con;
        mlist = list;
    }

    @Override
    public Hodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcon).inflate(R.layout.itme, null);
        Hodler hodler = new Hodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(Hodler holder, int position) {
        holder.tv.setText(mlist.get(position));
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class Hodler extends RecyclerView.ViewHolder {
        private TextView tv;
        public Hodler(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_itme);

        }
    }
}
