package com.example.developer.android_dev_samples;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.TypedValue;

import timber.log.Timber;

/**
 * Created by developer on 14/2/18.
 */

public class AvatarImageView extends AppCompatImageView {

    private static final int STROKE_WIDTH = 2;
    private Paint paint;
    private float outlineStrokeWidth;

    public AvatarImageView(Context context) {
        super(context);
        init();
    }

    public AvatarImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AvatarImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        outlineStrokeWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                STROKE_WIDTH, getResources().getDisplayMetrics());
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void drawCircle() {
        invalidate();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
        Timber.v("canvas width %s", canvasWidth);
        Timber.v("canvas height %s", canvasHeight);
        float pointX = canvasWidth * 0.5f;
        float pointY = canvasHeight * 0.5f;
        Timber.v("point x %s", pointX);
        Timber.v("point y %s", pointY);
        float circleRadius = 0.5f;
        paint.setColor(getContext().getColor(R.color.colorAccent));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPaint(paint);
        canvas.drawCircle(pointX, pointY, circleRadius, paint);
    }
}
