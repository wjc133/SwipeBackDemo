
package me.imid.swipebacklayout.demo;

import main.java.me.imid.swipebacklayout.lib.SwipeBackLayout;
import main.java.me.imid.swipebacklayout.lib.app.SwipeBackActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class DemoActivity extends BaseActivity implements View.OnClickListener {
    private int[] mBgColors;
    private static int mBgIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        changeActionBarColor();
        findViews();
        // 设置从左拖动，并从右边滑出
        setEdgeFromLeft();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("tag", "onResume()");
    }

    private void changeActionBarColor() {
        getActionBar().setBackgroundDrawable(new ColorDrawable(getColors()[mBgIndex]));
        mBgIndex++;
        if (mBgIndex >= getColors().length) {
            mBgIndex = 0;
        }
    }

    private void findViews() {
        findViewById(R.id.btn_start).setOnClickListener(this);
        findViewById(R.id.btn_finish).setOnClickListener(this);
    }

    private int[] getColors() {
        if (mBgColors == null) {
            Resources resource = getResources();
            mBgColors = new int[]{
                    resource.getColor(R.color.androidColorA),
                    resource.getColor(R.color.androidColorB),
                    resource.getColor(R.color.androidColorC),
                    resource.getColor(R.color.androidColorD),
                    resource.getColor(R.color.androidColorE),
            };
        }
        return mBgColors;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                startActivity(new Intent(DemoActivity.this, SecondActivity.class));
                break;
            case R.id.btn_finish:
                scrollToFinishActivity();
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("tag","onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("tag","onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("tag", "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("tag","onStop()");
    }
}
