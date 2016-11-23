package com.jogajunto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import com.jogajunto.modelo.Favorito;
import com.jogajunto.modelo.Quadra;
import com.jogajunto.tasks.FavoritarQuadraTask;
import com.jogajunto.tasks.ReceberQuadrasTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class PlayAreaView extends View {

    private static final String DEBUG_TAG = "GestureFunActivity";

    private GestureDetector gestures;
    private Matrix translate;
    private Bitmap droid;
    private Context context;

    private Matrix animateStart;
    private Interpolator animateInterpolator;
    private long startTime;
    private long endTime;
    private float totalAnimDx;
    private float totalAnimDy;
    private int screenSize;

    ReceberQuadrasTask task = new ReceberQuadrasTask();
    List<Quadra> quadras = task.doInBackground();


    public PlayAreaView(Context context) {
        super(context);
        this.context = context;
        translate = new Matrix();
        gestures = new GestureDetector(context,
                new GestureListener(this));

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        screenSize = display.getWidth();

        MainActivity.quadras = quadras;

        droid = getBitmapFromURL(quadras.get(0).getImage_Path());
        droid = getResizedBitmap(droid, screenSize, true);
    }

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

        if(dx < getLeft()-100) {
            deslikeAction();
        }else if(dx > getRight()+100) {
            likeAction();
        }

    }

    public void likeAction(){
        try{
            new FavoritarQuadraTask(context).execute(new Favorito(Autenticacao.idCliente, quadras.get(0).getId_Quadra()));
            changeImage(screenSize);
            onResetLocation();
        }catch (Exception e){
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void deslikeAction(){
        changeImage(screenSize);
        onResetLocation();
    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            // Log exception
            return null;
        }
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

    public void changeImage(int screenSize){

        if(quadras.size()>1){
            quadras.remove(0);
            droid = getBitmapFromURL(quadras.get(0).getImage_Path());
            droid = getResizedBitmap(droid, screenSize, true);
        }else{
            droid = getBitmapFromURL("http://acaboudeacabar.xpg.uol.com.br/wp-content/uploads/2016/08/destaque_acaboudeacabar.png");
            droid = getResizedBitmap(droid, screenSize, true);
        }
    }

    public static Bitmap getResizedBitmap(Bitmap realImage, float maxImageSize,
                                   boolean filter) {
        float ratio = Math.min(
                (float) maxImageSize / realImage.getWidth(),
                (float) maxImageSize / realImage.getHeight());
        int width = Math.round((float) ratio * realImage.getWidth());
        int height = width - width/3;

        Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, width,
                height, filter);
        return newBitmap;
    }

    public String[] showInformations(){
        String[] quadra = new String[6];
        quadra[0] = quadras.get(0).getImage_Path();
        quadra[1] = quadras.get(0).getDescricao();
        quadra[2] = quadras.get(0).getEndereco().getLogradouro();
        quadra[3] = quadras.get(0).getDono().getTelefone();
        quadra[4] = String.valueOf(quadras.get(0).getValor_Quadra());
        quadra[5] = quadras.get(0).getOpcionais();
        return quadra;
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

