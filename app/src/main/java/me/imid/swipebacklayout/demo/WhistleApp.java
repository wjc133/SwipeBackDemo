package me.imid.swipebacklayout.demo;

import android.app.Application;
import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Elite Group
 * Created by wjc133 on 2015/8/6.
 */
public class WhistleApp extends Application implements Handler.Callback {
    public static Handler mHandler;
    private List<Handler.Callback> callbacks;

    @Override
    public void onCreate() {
        super.onCreate();
        callbacks=new ArrayList<Handler.Callback>();
        mHandler=new Handler();
    }

    public void addCallback(Handler.Callback callback){
        callbacks.add(callback);
    }

    public void removeCallback(Handler.Callback callback){
        callbacks.remove(callback);
    }


    @Override
    public boolean handleMessage(Message msg) {
        notifyCallbacks();
    }

    private void notifyCallbacks() {

    }
}
