package com.example.uts;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder>{

    Context ct;
    String namaMinuman[], vharga[];
    int images[];
    MyOrder order;

    public Adapter(Context ct, String namaMinuman[], String harga[], int images[]){
        this.ct = ct;
        this.namaMinuman = namaMinuman;
        this.vharga = harga;
        this.images = images;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new viewHolder(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.nama.setText(namaMinuman[position]);
        holder.harga.setText(vharga[position]);
        holder.image.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    public static String[] remove(String[] arr, int index)
    {
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(arr));

        arrayList.remove(index);

        return arrayList.toArray(new String[0]);
    }


    public static int[] removeint(int[] arr, int index)
    {
        if (arr == null || index < 0
                || index >= arr.length) {

            return arr;
        }

        int[] tampung = new int[arr.length - 1];

        for (int i = 0, j = 0; i < arr.length; i++) {

            if (i == index) {
                continue;
            }
            tampung[j++] = arr[i];
        }

        return tampung;
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView nama, harga;
        ImageView image;
        private Adapter adapter;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
            harga = itemView.findViewById(R.id.price);
            image = itemView.findViewById(R.id.imageView);


            if(ct instanceof OrderComplete)
            {
                itemView.findViewById(R.id.deleteBtn).setVisibility(View.GONE);
            }

            itemView.findViewById(R.id.deleteBtn).setOnClickListener(view -> {

                //mencoba untuk mengganti total ketika sebuah item terdelete, namun tidak berhasil

//                int index = getAdapterPosition();
//                String temp = adapter.vharga[index];
//
//                String[] pisah = temp.split(" ");
//                int harga = Integer.valueOf(pisah[1]);
//                int total =  order.getTotal() - harga;
//                String tempp =  "Rp " + total;
//                order.setTotal(tempp);
//                hargaTotal.setText(tempp);


                adapter.namaMinuman = remove(namaMinuman, getAdapterPosition());
                adapter.vharga = remove(vharga, getAdapterPosition());
                adapter.images = removeint(images, getAdapterPosition());
                adapter.notifyItemRemoved(getAdapterPosition());


            });
        }
        public viewHolder linkAdapter(Adapter adapter){
            this.adapter = adapter;
            return this;
        }
    }
}
