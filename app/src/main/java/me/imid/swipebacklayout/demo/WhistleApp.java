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
    private static List<Handler.Callback> callbacks=new ArrayList<Handler.Callback>();

    @Override
    public void onCreate() {
        super.onCreate();
        mHandler=new Handler(this);
    }

    public static void addCallback(Handler.Callback callback){
        callbacks.add(callback);
    }

    public static void removeCallback(Handler.Callback callback){
        callbacks.remove(callback);
    }


    @Override
    public boolean handleMessage(Message msg) {
        notifyCallbacks(msg);
        return true;
    }

    private void notifyCallbacks(Message msg) {
        for (Handler.Callback callback:callbacks){
            callback.handleMessage(msg);
        }
    }
}
