package com.jemedina.tarea1;

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
                int n = Integer.valueOf(edittext.getText().toString());
                String serieTxt = calcularSerieFibonacci(n);
                texto.setText(serieTxt);
            break;
            case R.id.boton2:
                texto.setText("");
            break;
        }
    }

    String calcularSerieFibonacci(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i <= n; i ++) {
            sb.append(funcionFibonacci(i) + ",");
        }
        sb.replace(sb.length()-1,sb.length(),"");
        return sb.toString();
    }

    private int funcionFibonacci(int num){
        if(num == 0 || num==1)
            return num;
        else
            return funcionFibonacci(num-1) + funcionFibonacci(num-2);
    }
}
