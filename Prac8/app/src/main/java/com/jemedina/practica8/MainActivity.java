package com.jemedina.practica8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button boton;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = findViewById(R.id.boton);
        boton.setOnClickListener(this);
        editText = findViewById(R.id.editText);
    }

    @Override
    public void onClick(View view) {
        String dato = editText.getText().toString();
        switch (view.getId()){
            case R.id.boton:
                Intent siguiente = new Intent(MainActivity.this, SecondActivity.class);
                siguiente.putExtra("MENSAJE", dato);
                startActivity(siguiente);
                break;
        }
    }
}
