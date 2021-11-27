package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Drinks extends AppCompatActivity {

    Button btn;
    Context ct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        ImageView air = (ImageView)findViewById(R.id.imgAir);
        ImageView apel = (ImageView)findViewById(R.id.imgApel);
        ImageView mangga = (ImageView)findViewById(R.id.imgMangga);
        ImageView alpukat = (ImageView)findViewById(R.id.imgAlpukat);


        air.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent goOrder = new Intent(Drinks.this, Order.class);
                goOrder.putExtra("name1", "Air Mineral");
                goOrder.putExtra("price1", "Rp 123");
                startActivity(goOrder);
                return false;
            }
        });

        apel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent goOrder = new Intent(Drinks.this, Order.class);
                goOrder.putExtra("name1", "Jus Apel");
                goOrder.putExtra("price1", "Rp 123");
                startActivity(goOrder);
                return false;
            }
        });

        mangga.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent goOrder = new Intent(Drinks.this, Order.class);
                goOrder.putExtra("name1", "Jus Mangga");
                goOrder.putExtra("price1", "Rp 123");
                startActivity(goOrder);
                return false;
            }
        });

        alpukat.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent goOrder = new Intent(Drinks.this, Order.class);
                goOrder.putExtra("name1", "Jus Alpukat");
                goOrder.putExtra("price1", "Rp 123");
                startActivity(goOrder);
                return false;
            }
        });

        btn = findViewById(R.id.orderBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Drinks.this, MyOrder.class);
                startActivity(intent);
            }
        });
    }
}