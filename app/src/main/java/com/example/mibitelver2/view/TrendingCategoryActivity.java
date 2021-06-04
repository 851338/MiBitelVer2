package com.example.mibitelver2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mibitelver2.R;
import com.example.mibitelver2.model.VideoByCategory;
import com.example.mibitelver2.utils.Constants;
import com.example.mibitelver2.view.adapter.TrendingCategoryAdapter;

import java.util.List;

public class TrendingCategoryActivity extends AppCompatActivity {

    String categoryTxt;
    List<VideoByCategory> videoByCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_category);

        TrendingCategoryAdapter adapter = new TrendingCategoryAdapter(videoByCategories);
        RecyclerView recyclerView = findViewById(R.id.trending_category_RV);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        TextView category = findViewById(R.id.trending_category_categoryTv);

        if(getIntent().hasExtra(Constants.trending_category)) {
            categoryTxt = getIntent().getStringExtra(Constants.trending_category);
            category.setText(categoryTxt);
        }
    }
}