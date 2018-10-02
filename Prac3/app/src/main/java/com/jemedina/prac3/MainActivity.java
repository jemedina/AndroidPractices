package com.jemedina.prac3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.edittext);
        et2 = findViewById(R.id.edittext2);

        et1.setHint("Cambiamos la propiedad hint");
        et2.setHint("Cambiamos tambien esta parte");
    }


}
