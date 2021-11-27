package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyOrder extends AppCompatActivity {

    RecyclerView recyclerView;

    String namaMinuman[], harga[];
    int total = 1476;
    int image[] = {R.drawable.air_mineral, R.drawable.jus_apel, R.drawable.jus_mangga, R.drawable.jus_alpukat};
    TextView totalText;

    public int getTotal() {
        return total;
    }

    void setTotal(String text) {
        totalText = findViewById(R.id.hargaTotal);
        totalText.setText(text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        recyclerView = findViewById(R.id.recycler);

        namaMinuman = getResources().getStringArray(R.array.namaMinuman);
        harga = getResources().getStringArray(R.array.harga);

        Adapter adapter = new Adapter(this, namaMinuman, harga, image);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button payNow = findViewById(R.id.payNowBtn);
        payNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OrderComplete.class);
                startActivity(intent);
            }
        });
    }
}