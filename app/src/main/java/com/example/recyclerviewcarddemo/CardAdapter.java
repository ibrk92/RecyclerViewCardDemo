package com.example.recyclerviewcarddemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private String[] titles = {"Chapter 1", "Chapter 2", "Chapter 3", "Chapter 4", "Chapter 5","Chapter 6","Chapter 7","Chapter 8"};
    private String[] details = {"details 1", "details 2","details 3", "details 4", "details 5", "details 6", "details 7", "details 8"};

    private int[] images = {R.drawable.android_image_1,R.drawable.android_image_2,R.drawable.android_image_3, R.drawable.android_image_4,
    R.drawable.android_image_5,R.drawable.android_image_6, R.drawable.android_image_7, R.drawable.android_image_8};





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.itemTitle.setText(titles[position]);
        holder.itemDetail.setText(details[position]);
        holder.itemImage.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemTitle;
        TextView itemDetail;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    Snackbar.make(v, "Click Detected on Item" + position, Snackbar.LENGTH_LONG).setAction("Action", null).show();

                }
            });

        }
    }
}
