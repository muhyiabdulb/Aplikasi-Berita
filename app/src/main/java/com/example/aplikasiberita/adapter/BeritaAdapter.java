package com.example.aplikasiberita.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.aplikasiberita.DetailActivity;
import com.example.aplikasiberita.R;
import com.example.aplikasiberita.models.BeritaModel;

import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder> {

    private Context context;
    private List<BeritaModel> beritaList;

    public BeritaAdapter(Context context, List<BeritaModel> beritaList) {
        this.context = context;
        this.beritaList = beritaList;
    }

    @Override
    public BeritaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_berita, parent, false);
        return new BeritaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeritaViewHolder holder, int position) {
        BeritaModel berita = beritaList.get(position);
        holder.title.setText(berita.getTitle());
        holder.source.setText(berita.getSource());
//        Glide.with(context).load(berita.getSourceIcon()).into(holder.image);
        Glide.with(context)
                .load(berita.getSourceIcon())
                .transform(new RoundedCorners(20)) // rounded corner 20dp
                .placeholder(R.drawable.image_rounded)
                .into(holder.image);


        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("url", berita.getNewsUrl());
            context.startActivity(intent);
        });


    }


    @Override
    public int getItemCount() {
        return beritaList.size();
    }

    public static class BeritaViewHolder extends RecyclerView.ViewHolder {
        TextView title, source;
        ImageView image;

        public BeritaViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            source = itemView.findViewById(R.id.source);
            image = itemView.findViewById(R.id.image);
        }
    }
}
