package com.wangmaodou.zhihupage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Maodou on 2016/8/29.
 */
public class StartPageView extends View {

    private final String logo="知乎";
    private final String slogan="与世界分享你的知识、经验和见解";

    private int alpha=0;
    private Paint upPaint,downPaint;
    private ValueAnimator mValueAnimator;
    private final int mainColor=Color.BLUE;

    public StartPageView(Context context){
        super(context);
        init();
    }

    public void init(){
        upPaint=new Paint();
        upPaint.setColor(Color.WHITE);
        upPaint.setAntiAlias(true);
        upPaint.setTextSize(Tools.sp2px(getContext(),70));
        upPaint.setTextAlign(Paint.Align.CENTER);
        upPaint.setAlpha(0);

        downPaint=new Paint();
        downPaint.setColor(Color.WHITE);
        downPaint.setAntiAlias(true);
        downPaint.setTextAlign(Paint.Align.CENTER);
        downPaint.setTextSize(Tools.sp2px(getContext(),20));
        downPaint.setAlpha(0);

        mValueAnimator=createValueAnimator(5000);
        mValueAnimator.start();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(mainColor);
        if (alpha<=255)
            upPaint.setAlpha(alpha);
        if (alpha>255)
            downPaint.setAlpha(alpha-255);
        drawText(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:

                startAnimation();
                Log.d("======","Action_Down");
                break;

            case MotionEvent.ACTION_UP:
        }
        return true;
    }

    private void drawText(Canvas canvas){
        canvas.save();
        canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);
        canvas.drawText(logo,0,-300,upPaint);
        canvas.drawText(slogan,0,-100,downPaint);
        canvas.restore();
    }

    private void startAnimation(){

        if (!mValueAnimator.isRunning()){
            mValueAnimator.start();
        }
    }

    private ValueAnimator createValueAnimator(long duriation){
        ValueAnimator va=ValueAnimator.ofInt(0,510);
        va.setDuration(duriation);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                alpha=(int)valueAnimator.getAnimatedValue();
                invalidate();
                Log.d("==========",""+alpha);
            }
        });
        return va;
    }
}