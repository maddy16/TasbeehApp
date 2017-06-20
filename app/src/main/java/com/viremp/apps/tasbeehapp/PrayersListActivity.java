package com.viremp.apps.tasbeehapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import com.viremp.apps.tasbeehapp.models.Prayer;

import java.util.ArrayList;
import java.util.List;

public class PrayersListActivity extends AppCompatActivity {

    static class ListItemClickListener implements View.OnClickListener{

        List<Prayer> mList;

        ListItemClickListener(List<Prayer> mList) {
            this.mList = mList;
        }

        @Override
        public void onClick(View v) {
            int itemPosition = instance.rv.getChildLayoutPosition(v);
            Prayer prayer = mList.get(itemPosition);
            Intent intent = new Intent(instance,TasbeehActivity.class);
            intent.putExtra("prayer",prayer);
            instance.startActivity(intent);

        }
    }
    static PrayersListActivity instance;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayers_list);
        instance = this;
        rv= (RecyclerView) findViewById(R.id.prayers_list);
        PrayerListAdapter adapter = new PrayerListAdapter(this,getPrayers());
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);

    }


    public List<Prayer> getPrayers(){
        List<Prayer> list = new ArrayList<>();

        for(int i =0;i<=10;i++){
            Prayer prayer = new Prayer();
            prayer.setName(i+1+".\u200F سوتے وقت کی دعا ");
            prayer.setDesc("\u200F اللَّهُمَّ بِاسْمِكَ أَمُوتُ وَأَحْيَا ");
            prayer.setCount((i+1)*20);
            list.add(prayer);
        }
        return list;
    }

}
