package com.example.animatedgamewithfragment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {
    Paint p;
    Sprite sprite;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        sprite = new Sprite();//instantiate Sprite here, to access screen dims later
        p = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(Color.GRAY);//set paint to gray
        canvas.drawRect(getLeft(),getTop(),getRight(),getBottom(),p);//paint background gray
        sprite.update();//process sprite movement and status checks and changes
        sprite.draw(canvas);//sprite draws itself
        invalidate();//redraws screen, invokes onDraw()
    }
}
