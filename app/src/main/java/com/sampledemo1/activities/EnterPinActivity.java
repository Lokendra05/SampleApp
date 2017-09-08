package com.sampledemo1.activities;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sampledemo1.R;
import com.sampledemo1.base.NumberClickBaseActivity;
import com.sampledemo1.utils.AppUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class EnterPinActivity extends NumberClickBaseActivity {


    @BindView(R.id.img_holo_1)
    ImageView img_holo_1;

    @BindView(R.id.img_holo_2)
    ImageView img_holo_2;

    @BindView(R.id.img_holo_3)
    ImageView img_holo_3;

    @BindView(R.id.img_holo_4)
    ImageView img_holo_4;


    @BindView(R.id.img_fill_1)
    ImageView img_fill_1;

    @BindView(R.id.img_fill_2)
    ImageView img_fill_2;

    @BindView(R.id.img_fill_3)
    ImageView img_fill_3;

    @BindView(R.id.img_fill_4)
    ImageView img_fill_4;

    @BindView(R.id.txt_title)
    TextView txt_title;


    String tempPin = "";
    String constantPin = "1234";


    @Override
    public void setView() {
        setContentView(R.layout.activity_enter_pin);
    }

    @Override
    public void mCreate() {
        activity = this;

        txt_title.setText(getString(R.string.enter_pin_title));

        RelativeLayout.LayoutParams p = (RelativeLayout.LayoutParams) img_holo_1.getLayoutParams();
        p.width = (int) AppUtils.getPrecentWidth(activity, 8);
        p.height = (int) AppUtils.getPrecentWidth(activity, 8);

        img_holo_1.setLayoutParams(p);
        img_holo_2.setLayoutParams(p);
        img_holo_3.setLayoutParams(p);
        img_holo_4.setLayoutParams(p);

        img_fill_1.setLayoutParams(p);
        img_fill_2.setLayoutParams(p);
        img_fill_3.setLayoutParams(p);
        img_fill_4.setLayoutParams(p);


    }

    @Override
    public void clickOne() {
        setValues("1");

    }

    @Override
    public void clickTwo() {
        setValues("2");
    }

    @Override
    public void clickThree() {
        setValues("3");
    }

    @Override
    public void clickFour() {
        setValues("4");
    }

    @Override
    public void clickFive() {
        setValues("5");
    }

    @Override
    public void clickSix() {
        setValues("6");
    }

    @Override
    public void clickSeven() {
        setValues("7");
    }

    @Override
    public void clickEight() {
        setValues("8");
    }

    @Override
    public void clickNine() {
        setValues("9");
    }

    @Override
    public void clickZero() {
        setValues("0");
    }

    @Override
    public void clickDot() {
        setValues(".");
    }

    @Override
    public void clickback() {
        int tempPinLength = tempPin.length();

        if (tempPinLength > 0) {
            tempPin = tempPin.substring(0, tempPinLength - 1);
        }

        switch (tempPinLength) {
            case 1:
                img_fill_1.setVisibility(View.GONE);
                AppUtils.scaleDownAnim(activity, img_fill_1);
                break;
            case 2:
                img_fill_2.setVisibility(View.GONE);
                AppUtils.scaleDownAnim(activity, img_fill_2);
                break;
            case 3:
                img_fill_3.setVisibility(View.GONE);
                AppUtils.scaleDownAnim(activity, img_fill_3);
                break;
            case 4:
                img_fill_4.setVisibility(View.GONE);
                AppUtils.scaleDownAnim(activity, img_fill_4);
                break;
        }

    }


    private void setValues(String values) {

        if (tempPin.length() < 4) {

            tempPin = tempPin + values;


        }


        int tempPinLength = tempPin.length();

        switch (tempPinLength) {
            case 1:
                scaleUpImgView(img_fill_1);
                break;
            case 2:
                scaleUpImgView(img_fill_2);
                break;
            case 3:
                scaleUpImgView(img_fill_3);
                break;
            case 4:
                scaleUpImgView(img_fill_4);
                break;
        }


    }


    private void scaleUpImgView(ImageView imgView) {
        if (imgView.getVisibility() != View.VISIBLE) {
            imgView.setVisibility(View.VISIBLE);
            AppUtils.scaleUpAnim(activity, imgView);
        }

    }


    @OnClick(R.id.btn_back)
    public void backBtnClick() {
        finish();
    }



    @OnClick(R.id.btn_next)
    public void nextClick(){

        if(TextUtils.isEmpty(tempPin)){
            Toast.makeText(activity, "Please enter pin first", Toast.LENGTH_SHORT).show();
            return;
        }

        if(tempPin.length()!=4){
            Toast.makeText(activity, "Please enter complete pin", Toast.LENGTH_SHORT).show();
            return;
        }

        if(tempPin.equalsIgnoreCase(constantPin)){
            Intent i = new Intent(activity, DashboardActivity.class);
            startActivity(i);
            Toast.makeText(activity, "Successfully Login", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(activity, "Invalid Credential", Toast.LENGTH_SHORT).show();
        }
    }

}
