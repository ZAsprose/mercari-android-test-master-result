package com.mercari.mercaritest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.GridView;

import com.mercari.mercaritest.data.model.GridAdapter;
import com.mercari.mercaritest.data.model.HomeResponse;

public class MainActivity extends AppCompatActivity implements AbsListView.OnScrollListener{

    private GridView grid;
    private int THRESHOLD = 3;
    private android.os.Handler mHandler = new android.os.Handler();
    private GridAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // load json file
        HomeResponse hr = new HomeResponse("all.json", this.getBaseContext());

        // load gridView
        grid = (GridView)findViewById(R.id.container);
        mAdapter = new GridAdapter(this.getBaseContext(), hr.rp.data);

        // set adapter
        grid.setAdapter(mAdapter);
        grid.setOnScrollListener(this);

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        mHandler.postDelayed(addItemRunn, 1000);
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        mHandler.postDelayed(addItemRunn, 1000);
    }

    // thread for dynamtic load adapter
    private Runnable addItemRunn = new Runnable() {
        @Override
        public void run() {
            mAdapter.addItems(5);
        }
    };
}
