package com.viremp.apps.tasbeehapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.viremp.apps.tasbeehapp.models.Prayer;

import java.util.List;

/**
 * Created by Maddy on 15/06/2017.
 */

public class PrayerListAdapter extends
        RecyclerView.Adapter<PrayerListAdapter.MyViewHolder>{

    private List<Prayer> prayerList;
    private PrayersListActivity.ListItemClickListener listItemClickListener;
    Context context;
    public PrayerListAdapter(Context context,List<Prayer> prayerList) {
        this.prayerList = prayerList;
        this.context = context;
        listItemClickListener = new PrayersListActivity.ListItemClickListener(prayerList);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.prayer_item,parent, false);
        v.setOnClickListener(listItemClickListener);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Prayer Prayer = prayerList.get(position);
        holder.name.setText(Prayer.getName());
        holder.shortDet.setText(Prayer.getDesc());
        holder.detailsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,PrayerEditorActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return prayerList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView shortDet;
        ImageView detailsIcon;
        public MyViewHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.prayer_name);
            shortDet= (TextView) itemView.findViewById(R.id.prayer_short_det);
            detailsIcon = (ImageView) itemView.findViewById(R.id.info_btn);

        }
    }
}
