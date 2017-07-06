package com.example.hd.polygonchartview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HONGDA on 2017/7/6.19:01
 */

public class PolygonChartView extends View {

    private int center;//中心点
    private int defalutSize = 300;//默认大小

    //多边形半径
    private float one_radius;//最外层多边形半径


    private Paint centerLinePaint;


    public PolygonChartView(Context context) {
        this(context, null);
    }

    public PolygonChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PolygonChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        defalutSize = dp_px(defalutSize);

        initPaint();
    }

    private void initPaint() {
        centerLinePaint = new Paint();
        centerLinePaint.setAntiAlias(true);
        centerLinePaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCenterLine(canvas);
    }

    //绘制多边形的中心线
    private void drawCenterLine(Canvas canvas) {
        canvas.save();
        canvas.rotate(0, center, center);

        float endY = getPaddingTop();

        float degree = (float) (360 / 7 + 0.5);
        for (int i = 0; i < 7; i++) {
            canvas.drawLine(center, center, center, endY, centerLinePaint);
            canvas.rotate(degree, center, center);
        }
        canvas.restore();
    }

    //绘制最外层多边形
    private void drawOne(){
    }


    /**
     * dp转px
     *
     * @param values
     * @return
     */
    public int dp_px(int values) {

        float density = getResources().getDisplayMetrics().density;
        return (int) (values * density + 0.5f);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int withMode = MeasureSpec.getMode(widthMeasureSpec);
        int withSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getSize(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width, height;
        if (withMode == MeasureSpec.EXACTLY) {
            width = withSize;
        } else {
            width = Math.min(withSize, defalutSize);//最小为300
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = Math.min(heightSize, defalutSize);
        }

        center = width / 2;

        one_radius = center - getPaddingTop();

        setMeasuredDimension(width, height);


    }
}
