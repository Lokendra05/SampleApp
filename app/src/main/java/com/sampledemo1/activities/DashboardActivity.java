package com.sampledemo1.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sampledemo1.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardActivity extends AppCompatActivity {

    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        ButterKnife.bind(this);
        activity = this;

    }


    @OnClick(R.id.ll_receive)
    public void receiveClick() {
        Intent i = new Intent(activity, ReceiveActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.ll_send)
    public void sendClick(){
        Intent i = new Intent(activity, SendActivity.class);
        startActivity(i);
    }
}
