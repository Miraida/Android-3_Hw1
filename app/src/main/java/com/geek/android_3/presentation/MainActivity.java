package com.geek.android_3.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.geek.android_3.R;

public class MainActivity extends AppCompatActivity {
   private RecyclerView recyclerView;
   private EmojiAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recycler);
        adapter = new EmojiAdapter();
        recyclerView.setAdapter(adapter);
    }
}