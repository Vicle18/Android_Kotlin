package com.example.customview2


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

class CustomView : View, GestureDetector.OnGestureListener {
    private var TAG : String = "CustomView";
    private var gestureDetector: GestureDetector? = null;
    private lateinit var paintCircle: Paint;
    private lateinit var paintButtomLeft: Paint;
    private lateinit var paintButtomRight: Paint;
    private lateinit var paintTopRight: Paint;
    private lateinit var paintTopLeft: Paint;

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        Log.i(TAG, "Constructor(Context, AttributeSet")
        gestureDetector = GestureDetector(getContext(), this)
        paintTopRight = Paint()
        paintTopLeft = Paint()
        paintCircle = Paint()
        paintButtomLeft = Paint()
        paintButtomRight = Paint()
        paintCircle.color = Color.WHITE;
        paintCircle.style = Paint.Style.FILL;

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(gestureDetector!!.onTouchEvent(event)){
            return true;
        }
        return super.onTouchEvent(event)
    }

    override fun onShowPress(e: MotionEvent?) {

    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return false;
    }

    override fun onDown(e: MotionEvent?): Boolean {
        if(e!=null){
            if(e?.x < width/2 && e?.y < height/2) {
                paintCircle.color = paintTopRight.color;
            } else if (e?.x > width/2 && e?.y < height/2){
                paintCircle.color = paintTopLeft.color;
            } else if (e?.x < width/2 && e?.y > height/2){
                paintCircle.color = paintButtomLeft.color;
            } else if (e?.x > width/2 && e?.y > height/2){
                paintCircle.color = paintButtomRight.color;
            }
        }

        invalidate();
        return true;
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        return false;
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        return false;
    }

    override fun onLongPress(e: MotionEvent?) {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas);

        val topRightRect = Rect(0,0,((width/2)), (height/2));
        val topLeftRect = Rect((width/2),0,width, (height/2));
        val bottomLeftRect = Rect(0,(height/2),(width/2), height);
        val bottomRightRect = Rect((width/2),(height/2),width, height);


        val border_paint = Paint()
        border_paint.style = Paint.Style.STROKE
        border_paint.color = Color.BLACK
        border_paint.strokeWidth = 6f

        //Adding paint values
        paintTopRight.color = Color.RED;
        paintTopRight.style = Paint.Style.FILL;
        paintTopLeft.color = Color.GREEN;
        paintTopLeft.style = Paint.Style.FILL;
        paintButtomLeft.color = Color.BLUE;
        paintButtomLeft.style = Paint.Style.FILL;
        paintButtomRight.color = Color.YELLOW;
        paintButtomRight.style = Paint.Style.FILL;
        
        //Drawing the rectangles
        canvas?.drawRect(topRightRect, paintTopRight);
        canvas?.drawRect(topRightRect, border_paint);
        canvas?.drawRect(topLeftRect, paintTopLeft);
        canvas?.drawRect(topLeftRect, border_paint);
        canvas?.drawRect(bottomLeftRect, paintButtomLeft);
        canvas?.drawRect(bottomLeftRect, border_paint);
        canvas?.drawRect(bottomRightRect, paintButtomRight);
        canvas?.drawRect(bottomRightRect, border_paint);

        canvas?.drawCircle((width/2).toFloat(), (height/2).toFloat(), ((width/2).toFloat()*0.5).toFloat(), paintCircle)
        canvas?.drawCircle((width/2).toFloat(), (height/2).toFloat(), ((width/2).toFloat()*0.5).toFloat(), border_paint)
    }



}