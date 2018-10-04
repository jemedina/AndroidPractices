package com.jemedina.prac5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView texto;
    EditText edittext;
    Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Identificamos los elementos del XML y los asociamos con la parte lógica
        texto = (TextView) findViewById(R.id.texto);
        edittext = (EditText) findViewById(R.id.edittext);
        btn1 = (Button) findViewById(R.id.boton1);
        btn2 = (Button) findViewById(R.id.boton2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.boton1:
                String dato = edittext.getText().toString();
                texto.setText(dato);
                break;
            case R.id.boton2:
                texto.setText("");
                break;
        }
    }
}
