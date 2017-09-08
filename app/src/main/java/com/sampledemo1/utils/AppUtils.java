package com.sampledemo1.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.sampledemo1.R;

/**
 * Created by Dk-30-12-16 on 9/7/2017.
 */

public class AppUtils {

    @SuppressLint("NewApi")
    public static int getDeviceWidth(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();

        if (android.os.Build.VERSION.SDK_INT >= 13) {
            display.getSize(size);
            int width = size.x;
            return width;

        } else {
            int width = display.getWidth();
            return width;
        }

    }

    public static float getPrecentWidth(Activity activity, float layoutX) {
        return ((layoutX * getDeviceWidth(activity)) / 100);
    }


    public static void scaleUpAnim(Activity activity, View view) {
        Animation animation;
        animation = AnimationUtils.loadAnimation(activity, R.anim.scale_up);
        view.startAnimation(animation);
    }

    public static void scaleDownAnim(Activity activity, View view) {
        Animation animation;
        animation = AnimationUtils.loadAnimation(activity, R.anim.scale_down);
        view.startAnimation(animation);
    }

}
