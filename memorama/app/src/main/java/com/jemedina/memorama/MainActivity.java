package com.jemedina.memorama;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    List<ImageView> imageViews;
    List<Integer> numeros;
    List<Drawable> imagenes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagenes = new ArrayList<>();
        numeros = new ArrayList<>();
        for(int i=0;i < 8;i++){
            numeros.add(i);
            numeros.add(i);
        }

        Collections.shuffle(numeros);
        imageViews = new ArrayList<>();

        imageViews.add((ImageView) findViewById(R.id.img1));
        imageViews.add((ImageView) findViewById(R.id.img2));
        imageViews.add((ImageView) findViewById(R.id.img3));
        imageViews.add((ImageView) findViewById(R.id.img4));
        imageViews.add((ImageView) findViewById(R.id.img5));
        imageViews.add((ImageView) findViewById(R.id.img6));
        imageViews.add((ImageView) findViewById(R.id.img7));
        imageViews.add((ImageView) findViewById(R.id.img8));
        imageViews.add((ImageView) findViewById(R.id.img9));
        imageViews.add((ImageView) findViewById(R.id.img10));
        imageViews.add((ImageView) findViewById(R.id.img11));
        imageViews.add((ImageView) findViewById(R.id.img12));
        imageViews.add((ImageView) findViewById(R.id.img13));
        imageViews.add((ImageView) findViewById(R.id.img14));
        imageViews.add((ImageView) findViewById(R.id.img15));
        imageViews.add((ImageView) findViewById(R.id.img16));

        imagenes.add(ContextCompat.getDrawable(getApplicationContext(),R.drawable.img1));
        imagenes.add(ContextCompat.getDrawable(getApplicationContext(),R.drawable.img2));
        imagenes.add(ContextCompat.getDrawable(getApplicationContext(),R.drawable.img3));
        imagenes.add(ContextCompat.getDrawable(getApplicationContext(),R.drawable.img4));
        imagenes.add(ContextCompat.getDrawable(getApplicationContext(),R.drawable.img5));
        imagenes.add(ContextCompat.getDrawable(getApplicationContext(),R.drawable.img6));
        imagenes.add(ContextCompat.getDrawable(getApplicationContext(),R.drawable.img7));
        imagenes.add(ContextCompat.getDrawable(getApplicationContext(),R.drawable.img8));


        for(int i = 0;i < 16; i++){
            imageViews.get(i).setImageResource(R.drawable.cover);
            imageViews.get(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        ((ImageView)view).setImageDrawable(imagenes.get(numeros.get(Integer.valueOf(view.getTag().toString())-1)));
    }
}
