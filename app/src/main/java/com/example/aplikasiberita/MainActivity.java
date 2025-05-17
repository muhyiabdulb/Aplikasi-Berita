package com.example.aplikasiberita;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.aplikasiberita.adapter.BeritaAdapter;
import com.example.aplikasiberita.models.BeritaModel;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvBerita;
    BeritaAdapter beritaAdapter;
    List<BeritaModel> beritaList = new ArrayList<>();
    LinearLayout shimmerContainer;

    String url = "https://ok.surf/api/v1/cors/news-feed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AppBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Berita");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        // Shimmer container (LinearLayout yang isi shimmer-item)
        shimmerContainer = findViewById(R.id.shimmer_container);
        showShimmerItems(); // tampilkan shimmer dulu

        // RecyclerView
        rvBerita = findViewById(R.id.rvBerita);
        rvBerita.setLayoutManager(new LinearLayoutManager(this));
        beritaAdapter = new BeritaAdapter(this, beritaList);
        rvBerita.setAdapter(beritaAdapter);

        loadData(); // load data dari API
    }

    private void showShimmerItems() {
        LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < 5; i++) {
            View shimmerItem = inflater.inflate(R.layout.item_berita_shimmer, shimmerContainer, false);
            ShimmerFrameLayout shimmer = shimmerItem.findViewById(R.id.shimmer_layout);
            shimmer.startShimmer(); // aktifkan shimmer animasi
            shimmerContainer.addView(shimmerItem);
        }
    }

    private void loadData() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONArray articles = response.getJSONArray("Business");
                        for (int i = 0; i < articles.length(); i++) {
                            JSONObject obj = articles.getJSONObject(i);
                            String title = obj.getString("title");
                            String imageUrl = obj.getString("og");
                            String source = obj.getString("source");
                            String newsUrl = obj.getString("link");

                            beritaList.add(new BeritaModel(title, source, imageUrl, newsUrl));
                        }

                        // Sembunyikan shimmer & tampilkan data asli
                        shimmerContainer.setVisibility(View.GONE);
                        rvBerita.setVisibility(View.VISIBLE);
                        beritaAdapter.notifyDataSetChanged();

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(this, "Gagal parsing data", Toast.LENGTH_SHORT).show();
                        shimmerContainer.setVisibility(View.GONE);
                    }
                },
                error -> {
                    Toast.makeText(this, "Gagal load data", Toast.LENGTH_SHORT).show();
                    shimmerContainer.setVisibility(View.GONE);
                }
        );

        Volley.newRequestQueue(this).add(request);
    }
}
