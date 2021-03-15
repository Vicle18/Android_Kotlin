package com.example.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

class CustomView : View, GestureDetector.OnGestureListener {
    private var TAG : String = "CustomView";

    private var colors: IntArray = intArrayOf(
            Color.BLACK,
            Color.DKGRAY,
            Color.GRAY,
            Color.WHITE);

    private var gestureDetector: GestureDetector? = null;
    private var indexOfCurrentColor = 0;
    private lateinit var paint: Paint;

    constructor(context: Context?) : super(context)

    @SuppressLint("ClickableViewAccessibility")
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        setOnTouchListener{ _, event ->
            gestureDetector?.onTouchEvent(event)
            Log.i(TAG, "onTouchListener")
            true;
        }
        gestureDetector = GestureDetector(getContext(), this)
        paint = Paint()
    }

    override fun onShowPress(e: MotionEvent?) {

    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return false;
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return false;
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        if(indexOfCurrentColor > 0) {
            if (velocityX > 0) {
                indexOfCurrentColor--;
            }
        }
        if (indexOfCurrentColor < colors.size) {
            if (velocityX < 0) {
                indexOfCurrentColor++;
            }
        }
        invalidate();
        return true;
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        return false;
    }

    override fun onLongPress(e: MotionEvent?) {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas);
        paint.color = colors[indexOfCurrentColor];
        paint.style = Paint.Style.FILL;
        canvas?.drawPaint(paint)
    }



}