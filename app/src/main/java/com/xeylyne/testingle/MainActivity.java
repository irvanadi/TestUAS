package com.xeylyne.testingle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ResultAPI> results;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        setInitRecyclerView();
    }

    private void setInitRecyclerView() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        loadData();
    }

    private void loadData() {
        Call<ReqAPI> call = RetrofitInstance.getInstance().request();
        call.enqueue(new Callback<ReqAPI>() {
            @Override
            public void onResponse(Call<ReqAPI> call, Response<ReqAPI> response) {
                results = response.body().getResult();
                mainAdapter = new MainAdapter(MainActivity.this, results);
                recyclerView.setAdapter(mainAdapter);
                mainAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ReqAPI> call, Throwable t) {

            }
        });
    }

}
