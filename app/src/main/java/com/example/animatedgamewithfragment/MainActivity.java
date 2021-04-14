package com.example.animatedgamewithfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.media.Rating;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {
    Sprite sprite;
    DrawFragment drawFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.add(R.id.fragment_container, DrawFragment.newInstance(),"FirstDrawing");
        // Complete the changes added above
        ft.commit();
    }

    private void findSprite() {
        drawFragment = (DrawFragment) getSupportFragmentManager().findFragmentByTag("FirstDrawing");
        sprite = drawFragment.drawView.sprite;
    }
    public void moveLeft(View view) {
        if(sprite==null) {findSprite();}
        sprite.setdX(Math.abs(sprite.getdX())*-1);
    }
    public void moveRight(View view) {
        if(sprite==null) {findSprite();}
        sprite.setdX(Math.abs(sprite.getdX()));
    }
    public void redCheckBoxClicked(View view) {
        if(sprite==null) {findSprite();}
        if(((CheckBox)view).isChecked()){
            sprite.setColor(Color.RED);
        } else sprite.setColor(Color.BLUE);
    }
    public void greenCheckBoxClicked(View view) {
        if(sprite==null) {findSprite();}
        if(((CheckBox)view).isChecked()){
            sprite.offsetTo(200,200);
        } else sprite.setColor(Color.GREEN);
        RatingBar rB =(RatingBar)(drawFragment.getView().findViewById(R.id.ratingBar));
        sprite.setdX((int)rB.getRating());
        System.out.println("test: "+ rB.getRating());
    }
}