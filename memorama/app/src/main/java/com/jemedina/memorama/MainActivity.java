package com.jemedina.memorama;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable {

    final int TOTAL_PAIRS = 8;

    List<ImageView> imageViews;
    List<Integer> numeros;
    List<Drawable> imagenes;

    TextView erroresTv, puntosTv;

    Integer firstCard = null, firstCardIndex = null, secondCard = null, secondCardIndex = null;
    boolean eventsLocked = false;

    Thread waitASecondThread = null;

    int matchedPairs = 0, errores = 0, puntuacion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        erroresTv = findViewById(R.id.erroresTv);
        puntosTv = findViewById(R.id.puntuacionTv);
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
        if(!eventsLocked) {
            if (firstCard == null) {
                firstCardIndex = Integer.valueOf(view.getTag().toString()) - 1;
                firstCard = numeros.get(firstCardIndex);
                ((ImageView) view).setImageDrawable(imagenes.get(firstCard));
            } else {
                secondCardIndex = Integer.valueOf(view.getTag().toString()) - 1;
                if(secondCardIndex != firstCardIndex) {
                    eventsLocked = true;
                    secondCard = numeros.get(secondCardIndex);
                    ((ImageView) view).setImageDrawable(imagenes.get(secondCard));
                    waitASecondThread = new Thread(this);
                    waitASecondThread.start();
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(800);

            MainActivity.this.runOnUiThread(new Runnable()
            {
                public void run()
                {
                    if (firstCard.equals(secondCard)) {
                        Toast.makeText(getApplicationContext(), "Cool!", Toast.LENGTH_SHORT).show();
                        imageViews.get(firstCardIndex).setOnClickListener(null);
                        imageViews.get(secondCardIndex).setOnClickListener(null);
                        matchedPairs ++;
                        puntuacion += Constantes.PUNTUACION_BASE / (errores+1);
                        puntosTv.setText("Puntuación: " + puntuacion);

                        if(matchedPairs == TOTAL_PAIRS) {
                            Toast.makeText(getApplicationContext(), "Game Over", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this, GameOverActivity.class);
                            i.putExtra(Constantes.PUNTUACION_TAG, puntuacion);
                            startActivity(i);
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Las tarjetas no coinciden :(\nIntentalo de nuevo!", Toast.LENGTH_SHORT).show();
                        imageViews.get(firstCardIndex).setImageResource(R.drawable.cover);
                        imageViews.get(secondCardIndex).setImageResource(R.drawable.cover);
                        errores ++;
                        erroresTv.setText("Errores: " + errores);
                    }
                    firstCard = null;
                    eventsLocked = false;
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
