package com.jemedina.practica8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent  intent = getIntent();
        Bundle extras = intent.getExtras();
        texto = findViewById(R.id.texto);
        if (extras!= null){
            String dato= extras.getString("MENSAJE");
            texto.setText(dato);
        }
    }
}
