package com.sampledemo1.activities;

import android.view.View;
import android.widget.TextView;

import com.sampledemo1.R;
import com.sampledemo1.base.NumberClickBaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SendActivity extends NumberClickBaseActivity {

    @BindView(R.id.txt_eth)
    TextView txt_eth;

    @BindView(R.id.txt_dollar)
    TextView txt_dollar;

    @BindView(R.id.txt_error)
    TextView txt_error;

    @BindView(R.id.txt_title)
    TextView txt_title;


    String ethValue = "0";

    @Override
    public void setView() {
        setContentView(R.layout.activity_send);
    }

    @Override
    public void mCreate() {
        txt_title.setText(getString(R.string.send_title));
    }

    @Override
    public void clickOne() {
        setValueToEth("1");
    }

    @Override
    public void clickTwo() {
        setValueToEth("2");
    }

    @Override
    public void clickThree() {
        setValueToEth("3");
    }

    @Override
    public void clickFour() {
        setValueToEth("4");
    }

    @Override
    public void clickFive() {
        setValueToEth("5");
    }

    @Override
    public void clickSix() {
        setValueToEth("6");
    }

    @Override
    public void clickSeven() {
        setValueToEth("7");
    }

    @Override
    public void clickEight() {
        setValueToEth("8");
    }

    @Override
    public void clickNine() {
        setValueToEth("9");
    }

    @Override
    public void clickZero() {
        if (ethValue.length() > 0) {
            if (ethValue.contains(".")) {
                setValueToEth("0");
                return;
            }

            String tempValue = ethValue.substring(0, 1);
            if (!tempValue.equalsIgnoreCase("0")) {
                setValueToEth("0");
            }
        }

    }

    @Override
    public void clickback() {

        if (ethValue.length() > 0) {
            ethValue = ethValue.substring(0, ethValue.length() - 1);
            if (ethValue.length() == 0) {
                ethValue = "0";
            }
            txt_eth.setText(ethValue);
            calculateDollar();
        }

        if (!allowDigitsToEnter()) {
            return;
        }

    }

    @Override
    public void clickDot() {
        if (!allowDigitsToEnter()) {
            return;
        }
        if (!ethValue.contains(".")) {
            ethValue = ethValue + ".";
            txt_eth.setText(ethValue);
            calculateDollar();
        }
        allowDigitsToEnter();
    }


    @OnClick(R.id.btn_back)
    public void backBtnClick() {
        finish();
    }


    //validation 10 digits
    private boolean allowDigitsToEnter() {
        if (ethValue.length() == 10) {
            txt_error.setVisibility(View.VISIBLE);
            txt_error.setText("Maximum 10 digits allowed to enter.");
            return false;
        } else {
            txt_error.setVisibility(View.GONE);
            return true;
        }
    }

    //set values to ETH and USD with calculation
    private void setValueToEth(String value) {
        if (!allowDigitsToEnter()) {
            return;
        }


        if (ethValue.length() > 0) {

            if (!ethValue.contains(".")) {
                String tempValue = ethValue.substring(0, 1);
                if (tempValue.equalsIgnoreCase("0")) {
                    ethValue = "";
                }
            }

        }
        ethValue = ethValue + value;
        txt_eth.setText(ethValue);
        calculateDollar();
    }

    //calculate dollar rate
    private void calculateDollar() {
        double eth = Double.parseDouble(ethValue);
        double usd = eth * 325.4;
        String usdValue = String.format("%.02f", usd);
        if (eth == 0) {
            usdValue = "0";
        }
        txt_dollar.setText("" + usdValue);
    }


}
