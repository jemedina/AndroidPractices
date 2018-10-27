package com.jemedina.memorama;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        TextView tv = findViewById(R.id.textView2);
        Bundle bundle = getIntent().getExtras();
        Integer puntuacion = bundle.getInt(Constantes.PUNTUACION_TAG);
        tv.setText("Has logrado: " + puntuacion + " puntos!");
    }

}
