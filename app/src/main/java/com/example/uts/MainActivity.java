package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView drink = (TextView) findViewById(R.id.drinks);
        ImageView binus = (ImageView)findViewById(R.id.binus);


        binus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toBinus = new Intent(Intent.ACTION_VIEW);
                toBinus.setData(Uri.parse("https://binus.ac.id/"));
                startActivity(toBinus);
            }
        });

        drink.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent goDrink = new Intent(getApplicationContext(), Drinks.class);
                startActivity(goDrink);
                return false;
            }
        });

        btn = findViewById(R.id.orderBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyOrder.class);
                startActivity(intent);
            }
        });
    }
}