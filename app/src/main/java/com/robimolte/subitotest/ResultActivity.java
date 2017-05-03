package com.robimolte.subitotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.robimolte.subitotest.adapter.StargazerAdapter;
import com.robimolte.subitotest.model.Stargazer;

public class ResultActivity extends AppCompatActivity {


    List<Stargazer> stargazer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent i = getIntent();
        stargazer = (List<Stargazer>) i.getSerializableExtra("stargazer");

        StargazerAdapter adapter = new StargazerAdapter(this, (ArrayList<Stargazer>) stargazer);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listResult);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);



    }
}
