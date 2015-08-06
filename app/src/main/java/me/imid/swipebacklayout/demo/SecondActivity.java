package me.imid.swipebacklayout.demo;

import android.os.Bundle;

import main.java.me.imid.swipebacklayout.lib.SwipeBackLayout;
import main.java.me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class SecondActivity extends SwipeBackActivity implements SwipeBackLayout.SwipeListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_layout);
		
		setEdgeFromLeft();
		getSwipeBackLayout().setSwipeListener(this);
	}

	@Override
	public void onScrollStateChange(int state, float scrollPercent) {

	}

	@Override
	public void onEdgeTouch(int edgeFlag) {

	}

	@Override
	public void onScrollOverThreshold() {

	}

	@Override
	public void onPositionChanged(float scrollPercent) {

	}
}
