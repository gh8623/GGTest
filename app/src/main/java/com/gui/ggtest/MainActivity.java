package com.gui.ggtest;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.gui.ggtest.activity.ChooseCityActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Toolbar toolbar;
    RecyclerView my_recycler_view ;
    FloatingActionButton fab;

    MyAdapter recyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        recyAdapter = new MyAdapter(MainActivity.this);
        List<String> listData = new ArrayList<String>();
        listData.add("aa1");
        listData.add("b");
        listData.add("a1");
        listData.add("d1");
        listData.add("df1");
        listData.add("1r");
        listData.add("e1");
        listData.add("q1");
        listData.add("t1");
        listData.add("w1");
        listData.add("g1");
        listData.add("z1");
        listData.add("b1");
        listData.add("z1");
        listData.add("1f");
        listData.add("1c");
        recyAdapter.addAll(listData);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        my_recycler_view.setAdapter(recyAdapter);
    }

    private void initView() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        my_recycler_view = (RecyclerView)findViewById(R.id.my_recycler_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
        setSupportActionBar(toolbar);
        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        NavigationView view = (NavigationView) findViewById(R.id.navigation_view);
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_choose_city:
                        Intent intent = new Intent(MainActivity.this, ChooseCityActivity.class);
                        startActivity(intent);
                        break;
                }
                menuItem.setChecked(true);
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                Snackbar.make(v,"我是底部标题",Snackbar.LENGTH_LONG)
                        .setAction("隐藏", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //这里的单击事件代表点击消除Action后的响应事件
                            }
                        })
                        .show();
                break;
        }
    }
}
