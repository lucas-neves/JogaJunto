package com.jogajunto;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String DEBUG_TAG = "GestureFunActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FrameLayout frame = (FrameLayout) findViewById(R.id.graphics_holder);
        PlayAreaView image = new PlayAreaView(this);
        frame.addView(image);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class PlayAreaView extends View {

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

            DisplayMetrics displaymetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            int height = displaymetrics.heightPixels;
            int width = displaymetrics.widthPixels;

            post(new Runnable() {
                @Override
                public void run() {
                    onAnimateStep();
                }
            });
            if(getX()< -(width/3) || getX()> (width*1.2)){
                changePlace();
            }
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

            //Log.v(DEBUG_TAG, "We're " + percentDistance + " of the way there!");
            if (percentTime < 1.0f) {
                post(new Runnable() {
                    @Override
                    public void run() {
                        onAnimateStep();
                    }
                });
            }
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
            gestures = new GestureDetector(MainActivity.this,
                    new MainActivity.GestureListener(this));
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

    }

    private class GestureListener implements GestureDetector.OnGestureListener,
            GestureDetector.OnDoubleTapListener {

        MainActivity.PlayAreaView view;

        public GestureListener(MainActivity.PlayAreaView view) {
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
