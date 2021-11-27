package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderComplete extends AppCompatActivity {

    RecyclerView recyclerView;
    String namaMinuman[], harga[];
    int image[] = {R.drawable.air_mineral, R.drawable.jus_apel, R.drawable.jus_mangga, R.drawable.jus_alpukat};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        View inflated = this.getLayoutInflater().inflate(R.layout.row, null);

        Button btn = inflated.findViewById(R.id.deleteBtn);
        btn.setText("Ya halo");

        recyclerView = findViewById(R.id.recycler);
        namaMinuman = getResources().getStringArray(R.array.namaMinuman);
        harga = getResources().getStringArray(R.array.harga);

        Adapter adapter = new Adapter(this, namaMinuman, harga, image);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button backToMenu = findViewById(R.id.backToMenu);
        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}