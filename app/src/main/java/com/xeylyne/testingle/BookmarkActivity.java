package com.xeylyne.testingle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class BookmarkActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DataHelper dataHelper;
    ArrayList<Place> results = new ArrayList<>();
    BookmarkAdapter bookmarkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);
        recyclerView = findViewById(R.id.recyclerView);
        dataHelper = new DataHelper(this);

        setInitRecyclerView();
    }

    private void setInitRecyclerView() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(BookmarkActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        loadData();
    }

    private void loadData() {
        results = dataHelper.getAllData();
        bookmarkAdapter = new BookmarkAdapter(BookmarkActivity.this, results);
        recyclerView.setAdapter(bookmarkAdapter);
        bookmarkAdapter.notifyDataSetChanged();
    }
}
