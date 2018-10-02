package com.jemedina.prac4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imagen);

        img.setScaleX(0.3f);
        img.setScaleY(0.3f);
        img.setImageResource(R.drawable.android2);
    }
}
