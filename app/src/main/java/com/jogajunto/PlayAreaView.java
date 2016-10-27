package com.jogajunto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;

public class PlayAreaView extends View {

    private static final String DEBUG_TAG = "GestureFunActivity";

    private GestureDetector gestures;
    private Matrix translate;
    private Bitmap droid;

    private Matrix animateStart;
    private Interpolator animateInterpolator;
    private long startTime;
    private long endTime;
    private float totalAnimDx;
    private float totalAnimDy;
    private int indiceQuadra = 1;

    public void onAnimateMove(float dx, float dy, long duration) {
        animateStart = new Matrix(translate);
        animateInterpolator = new OvershootInterpolator();
        startTime = System.currentTimeMillis();
        endTime = startTime + duration;
        totalAnimDx = dx;
        totalAnimDy = dy;

        post(new Runnable() {
            @Override
            public void run() {
                onAnimateStep();
            }
        });

        if(dx < getLeft()-100 || dx > getRight()+100)
            changePlace();
    }

    public void changePlace(){

        switch (indiceQuadra){
            case 1:
                droid = BitmapFactory.decodeResource(getResources(),
                        R.drawable.quadra1);
                indiceQuadra++;
                break;

            case 2:
                droid = BitmapFactory.decodeResource(getResources(),
                        R.drawable.quadra2);
                indiceQuadra++;
                break;

            case 3:
                droid = BitmapFactory.decodeResource(getResources(),
                        R.drawable.quadra3);
                indiceQuadra++;
                break;

            case 4:
                droid = BitmapFactory.decodeResource(getResources(),
                        R.drawable.quadra4);
                indiceQuadra++;
                break;
            case 5:
                droid = BitmapFactory.decodeResource(getResources(),
                        R.drawable.quadra5);
                indiceQuadra=1;
                break;
        }
    }

    public void changeByButton(){
        changePlace();
        onResetLocation();
    }

    private void onAnimateStep() {
        long curTime = System.currentTimeMillis();
        float percentTime = (float) (curTime - startTime)
                / (float) (endTime - startTime);
        float percentDistance = animateInterpolator
                .getInterpolation(percentTime);
        float curDx = percentDistance * totalAnimDx;
        float curDy = percentDistance * totalAnimDy;
        translate.set(animateStart);
        onMove(curDx, curDy);

        Log.v(DEBUG_TAG, "We're " + percentDistance + " of the way there!");
        if (percentTime < 1.0f) {
            post(new Runnable() {
                @Override
                public void run() {
                    onAnimateStep();
                }
            });
        }

        if(curDx < getLeft()-100 || curDx > getRight()+100)
            onResetLocation();

    }

    public void onMove(float dx, float dy) {
        translate.postTranslate(dx, dy);
        invalidate();
    }

    public void onResetLocation() {
        translate.reset();
        invalidate();
    }

    public void onSetLocation(float dx, float dy) {
        translate.postTranslate(dx, dy);
    }

    public PlayAreaView(Context context) {
        super(context);
        translate = new Matrix();
        gestures = new GestureDetector(context,
                new GestureListener(this));
        droid = BitmapFactory.decodeResource(getResources(),
                R.drawable.quadra2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // Log.v(DEBUG_TAG, "onDraw");
        canvas.drawBitmap(droid, translate, null);
        Matrix m = canvas.getMatrix();

        //Log.d(DEBUG_TAG, "Matrix: " + translate.toShortString());
        //Log.d(DEBUG_TAG, "Canvas: " + m.toShortString());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestures.onTouchEvent(event);
    }

    private class GestureListener implements GestureDetector.OnGestureListener,
            GestureDetector.OnDoubleTapListener {

        PlayAreaView view;

        public GestureListener(PlayAreaView view) {
            this.view = view;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            Log.v(DEBUG_TAG, "onDown");
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2,
                               final float velocityX, final float velocityY) {
            //Log.v(DEBUG_TAG, "onFling");
            final float distanceTimeFactor = 0.4f;
            final float totalDx = (distanceTimeFactor * velocityX / 2);
            final float totalDy = (distanceTimeFactor * velocityY / 2);

            view.onAnimateMove(totalDx, totalDy,
                    (long) (1000 * distanceTimeFactor));
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.v(DEBUG_TAG, "onDoubleTap");
            view.onResetLocation();
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.v(DEBUG_TAG, "onLongPress");
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {
            //Log.v(DEBUG_TAG, "onScroll");

            view.onMove(-distanceX, -distanceY);
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            Log.v(DEBUG_TAG, "onShowPress");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.v(DEBUG_TAG, "onSingleTapUp");
            return false;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.v(DEBUG_TAG, "onDoubleTapEvent");
            return false;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.v(DEBUG_TAG, "onSingleTapConfirmed");
            return false;
        }

    }

}

