package com.sampledemo1.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sampledemo1.R;
import com.sampledemo1.utils.AppUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReceiveActivity extends AppCompatActivity {

    @BindView(R.id.txt_title)
    TextView txt_title;

    @BindView(R.id.img_scanner)
    ImageView img_scanner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        ButterKnife.bind(this);
        txt_title.setText(getString(R.string.receive_title));


        RelativeLayout.LayoutParams p = (RelativeLayout.LayoutParams) img_scanner.getLayoutParams();
        p.height = (int) AppUtils.getPrecentWidth(this, 50);
        p.width = (int) AppUtils.getPrecentWidth(this, 50);

        img_scanner.setLayoutParams(p);

    }


    @OnClick(R.id.btn_back)
    public void backClick() {
        finish();
    }

}
