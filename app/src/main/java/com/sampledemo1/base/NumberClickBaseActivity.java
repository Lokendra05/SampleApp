package com.sampledemo1.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sampledemo1.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dk-30-12-16 on 9/6/2017.
 */

public abstract class NumberClickBaseActivity extends AppCompatActivity {

    public abstract void setView(); //for set content view of activity

    public abstract void mCreate(); //in place of onCreate for initialization

    protected Activity activity;

    public abstract void clickOne(); //for button 1s click

    public abstract void clickTwo();//for button 2 click

    public abstract void clickThree();//for button 3 click

    public abstract void clickFour();//for button 4 click

    public abstract void clickFive();//for button 5 click

    public abstract void clickSix();//for button 6 click

    public abstract void clickSeven();//for button 7 click

    public abstract void clickEight();//for button 8 click

    public abstract void clickNine();//for button 9 click

    public abstract void clickZero();//for button 0 click

    public abstract void clickback();//for button back click

    public abstract void clickDot();//for button . click


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
        ButterKnife.bind(this);
        mCreate();
    }


    @OnClick(R.id.rl_one)
    public void oneClick() {
        clickOne();
    }

    @OnClick(R.id.rl_two)
    public void twoClick() {
        clickTwo();
    }

    @OnClick(R.id.rl_three)
    public void threeClick() {
        clickThree();
    }


    @OnClick(R.id.rl_four)
    public void fourClick() {
        clickFour();
    }

    @OnClick(R.id.rl_five)
    public void fiveClick() {
        clickFive();
    }

    @OnClick(R.id.rl_six)
    public void sixClick() {
        clickSix();
    }

    @OnClick(R.id.rl_seven)
    public void sevenClick() {
        clickSeven();
    }

    @OnClick(R.id.rl_eight)
    public void eightClick() {
        clickEight();
    }

    @OnClick(R.id.rl_nine)
    public void nineClick() {
        clickNine();
    }

    @OnClick(R.id.rl_zero)
    public void zeroClick() {
        clickZero();
    }

    @OnClick(R.id.rl_back)
    public void backClick() {
        clickback();
    }

    @OnClick(R.id.rl_dot)
    public void dotClick() {
        clickDot();
    }

}
