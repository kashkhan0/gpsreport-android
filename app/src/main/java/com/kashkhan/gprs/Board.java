package com.kashkhan.gprs;

/**
 * Created by kashifkhan on 1/4/18.
 */

//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.util.AttributeSet;
//import android.view.View;

import android.view.View;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.location.Location;

import android.util.AttributeSet;

/**
 * Created by kashifkhan on 1/4/18.
 */

public class Board extends View {


    private Bitmap left3green80 = null;
    private Bitmap  right3green80 = null;
    private Paint p;
    private static float xx = 0;
    private static double londisp = 0;
    private static double latdisp = 0;
    private static float timesincegps = 0;

    private static String statusstr = "";

    public void setlon(double sx) {
        this.londisp = sx;
    }
    public void setlat(double sy) {
        this.latdisp = sy;
    }
    public void setstatusstr(String sy) {
        this.statusstr = sy;
    }
    public void resetgps() {
        this.timesincegps = 0;
    }

    public Board(Context context, AttributeSet aSet) {
        super(context, aSet);
        left3green80 =  BitmapFactory.decodeResource(getResources(), R.drawable.left3green80);
        right3green80 =  BitmapFactory.decodeResource(getResources(), R.drawable.right3green80);
        p = new Paint();
    }


    private void drawmap(Canvas canvas, float dx, float dy)
    {

    }

    @Override
    synchronized public void onDraw(Canvas canvas)
    {
        xx+=1;
        timesincegps+=1;
        float canvasww  = canvas.getWidth();
        float canvaswh = canvas.getHeight();


        p.setColor(Color.argb(250,250,110,100));
        canvas.drawRect(0.0f,  0.01f*canvaswh , 0.1f*canvasww+timesincegps*2 , 0.02f*canvaswh , p);
        // custom drawing code here
        p.setAntiAlias(true);
        p.setColor(Color.YELLOW);
        p.setStyle(Paint.Style.FILL);


        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        // make the entire canvas white
        paint.setColor(Color.WHITE);
//        canvas.drawPaint(paint);

        // draw blue circle with anti aliasing turned on
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        //   canvas.drawCircle(initX, initY, radius, paint);

        // draw red rectangle with anti aliasing turned off
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        //  canvas.drawRect(initX, initY + 300, rectWidth + radius, initY + rectHeight , paint);
        //  canvas.drawRect(initX, initY, initX + rectWidth, initY + rectHeight , p);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        //  canvas.drawText(" codes", initX, initY + 600, paint);
        paint.setTextSize(canvaswh*0.04f);
//        canvas.drawText(""+String.format("%.0f",xx) ,10.0f  ,  initY + 80, paint);
        canvas.drawText("lon: "+ londisp ,canvasww*0.01f ,   canvaswh*0.2f, paint);
        canvas.drawText("lat: "+ latdisp ,canvasww*0.01f ,  canvaswh*0.25f, paint);
        canvas.drawText(""+ statusstr ,canvasww*0.01f ,canvaswh*0.3f, paint);

    }







}
