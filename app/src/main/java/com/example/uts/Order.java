package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Order extends AppCompatActivity {

    ArrayList<String> vName = new ArrayList<>();
    ArrayList<String> vPrice = new ArrayList<>();
    ArrayList<String> vQuantity = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent lastIntent = getIntent();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        String getName = lastIntent.getStringExtra("name1");
        String getPrice = lastIntent.getStringExtra("price1");
        TextView name = (TextView)findViewById(R.id.name);
        TextView price = (TextView)findViewById(R.id.price);
        EditText quantity = (EditText)findViewById(R.id.quantityTxt);

        name.setText(getName);
        price.setText(getPrice);

        vName.add(getName);
        vPrice.add(getPrice);


        Button myOrderButton = findViewById(R.id.myOrderBtn);
        Button drinkButton = findViewById(R.id.drinkBtn);

        myOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //mencoba untuk menyimpan data yang dimasukkan ketika quantity sudah diketik. Namun, tidak berhasil karena ketika nanti
                    //ke drinks lalu balik lagi ke order, listnya terbuat ulang dan data yang sebelumnya hilang sehingga tidak bisa
                    //dimasukkan ke my order.

//                String quantityValue = quantity.getText().toString();
//                vQuantity.add(quantityValue);
//                name.setText(quantityValue);
//                int size = vQuantity.size();
//                String size1 = Integer.toString(size);
//                price.setText(size1);
                Intent intent = new Intent(Order.this, MyOrder.class);
                startActivity(intent);
            }
        });

        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantityValue = quantity.getText().toString();
                vQuantity.add(quantityValue);
                Intent intent = new Intent(Order.this, Drinks.class);
                startActivity(intent);
            }
        });

    }
}