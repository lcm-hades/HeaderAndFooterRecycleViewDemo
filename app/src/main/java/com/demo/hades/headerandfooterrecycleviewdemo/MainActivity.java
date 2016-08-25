package com.demo.hades.headerandfooterrecycleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView first_rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        List<String> listData = new ArrayList<>();
//        for (int i=0; i<10; i++){
//            listData.add("test " + i);
//        }
//
//        first_rv = (RecyclerView) findViewById(R.id.first_rv);
//
//        first_rv.setItemAnimator(new DefaultItemAnimator());
//        first_rv.setHasFixedSize(true);
//        first_rv.setLayoutManager(new GridLayoutManager(this, 4));
//
//        RecyclerViewAdapter adt = new RecyclerViewAdapter(this, listData);
//        TextView tv = new TextView(this);
//        tv.setText("kkkkkkkkkkkkkkkkkkkkkk");
//        adt.addHeaderView(tv);
//        first_rv.setAdapter(adt);
    }
}
