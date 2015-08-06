package me.imid.swipebacklayout.demo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import main.java.me.imid.swipebacklayout.lib.SwipeBackLayout;
import main.java.me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Elite Group
 * Created by wjc133 on 2015/8/6.
 */
public class BaseActivity extends SwipeBackActivity implements SwipeBackLayout.SwipeListener,Handler.Callback {

    private boolean isFront;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WhistleApp.addCallback(this);
        getSwipeBackLayout().setSwipeListener(this);
    }

    @Override
    public void onScrollStateChange(int state, float scrollPercent) {

    }

    @Override
    public void onEdgeTouch(int edgeFlag) {
        Log.v("edgeFlag",edgeFlag+"");
    }

    @Override
    public void onScrollOverThreshold() {

    }

    @Override
    public void onPositionChanged(float scrollPercent) {
        isFront=true;
        Message msg=Message.obtain();
        Bundle bundle=new Bundle();
        bundle.putFloat(Utils.SCROLL_PERCENT,scrollPercent);
        msg.setData(bundle);
        msg.what=Utils.SCROLL_EVENT;
        WhistleApp.mHandler.sendMessage(msg);
    }


    @Override
    protected void onResume() {
        super.onResume();
        isFront=false;
    }

    @Override
    public boolean handleMessage(Message msg) {
        if (isFront){
            return true;
        }
        float percent=msg.getData().getFloat(Utils.SCROLL_PERCENT);
        View view=getWindow().getDecorView();
        view.setTranslationX(-(1-percent)*view.getWidth()/4);
        return true;
    }

    @Override
    protected void onDestroy() {
        WhistleApp.removeCallback(this);
        super.onDestroy();
    }
}
