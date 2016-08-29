package com.wangmaodou.zhihupage;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    StartPageView mStartPageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        init();
        CreateStartPage();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                destroyStartPage();
            }
        },5000);
    }

    private void init(){
        mStartPageView=new StartPageView(this);
    }

    private void CreateStartPage(){
        WindowManager.LayoutParams l=new WindowManager.LayoutParams();
        l.type= WindowManager.LayoutParams.TYPE_APPLICATION;
        l.format= PixelFormat.RGBA_8888;
        l.flags=WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
        l.flags=WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        l.width= WindowManager.LayoutParams.MATCH_PARENT;
        l.height=WindowManager.LayoutParams.MATCH_PARENT;
        getWindowManager().addView(mStartPageView,l);
    }

    private void destroyStartPage(){
        getWindowManager().removeView(mStartPageView);
    }
}
