package com.bawei.viewpage;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 猥琐的熊猫 on 2017/11/23.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
