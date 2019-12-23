package me.sofiworker.rxjava2;

import android.app.Application;
import android.os.Handler;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/23 10:29
 * @description application
 */
public class App extends Application {

    private static Handler sHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        sHandler = new Handler();
    }


    public static Handler getHandler(){
        return sHandler;
    }
}
