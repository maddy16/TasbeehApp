package com.viremp.apps.tasbeehapp;

import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.viremp.apps.tasbeehapp.models.Prayer;

import org.w3c.dom.Text;

import java.io.Serializable;

public class TasbeehActivity extends AppCompatActivity {

    TextView prayerName,prayerAyat,tasbeehCountTxt;
    int tasbeehCount,totalCount;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbeeh);
        prayerName = (TextView) findViewById(R.id.prayerNameTasbeeh);
        prayerAyat = (TextView) findViewById(R.id.prayerAyat);
        tasbeehCountTxt = (TextView) findViewById(R.id.counterValue);
        progressBar = (ProgressBar) findViewById(R.id.progressBarCounter);
        progressBar.getProgressDrawable().setColorFilter(
                ContextCompat.getColor(this, R.color.colorPrimary), android.graphics.PorterDuff.Mode.SRC_IN);
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar!=null){
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(true);
        }
        Prayer prayer = (Prayer)getIntent().getSerializableExtra("prayer");
        prayerName.setText(prayer.getName());
        prayerAyat.setText(prayer.getDesc());
        tasbeehCount = totalCount = prayer.getCount();
        tasbeehCountTxt.setText(tasbeehCount +"");




    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void countClicked(View view) {
        tasbeehCount--;
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.zoomout);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                tasbeehCountTxt.setTextColor(getResources().getColor(R.color.colorPrimary));
                tasbeehCountTxt.setText(tasbeehCount +"");
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                tasbeehCountTxt.setTextColor(tasbeehCount==0?getResources().getColor(R.color.colorPrimary):getResources().getColor(R.color.black));
                animation = AnimationUtils.loadAnimation(TasbeehActivity.this,R.anim.zoomout);
//                tasbeehCountTxt.startAnimation(animation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        tasbeehCountTxt.startAnimation(animation);
        progressBar.setProgress((totalCount-tasbeehCount)*100/totalCount);
        if(tasbeehCount==0){
            view.setEnabled(false);

            ((Button)view).setText("Completed");
            tasbeehCountTxt.setTextColor(getResources().getColor(R.color.colorPrimary));
        }


    }
}
