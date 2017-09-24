package com.mercari.mercaritest.data.model;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by zasprose on 9/24/17.
 */

public class GridAdapter extends BaseAdapter {

    private Context context;
    private List<Item> data;
    // width of screen
    private int width;
    // for dynamtic loading adapter
    private int min, max, mCount;
    private boolean up = false;
    private boolean down = false;

    public GridAdapter(Context context, List data) {
        this.context = context;
        this.data = data;
        // calculate screen width
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        this.width = metrics.widthPixels;
        // init variable
        this.min = 0;
        this.max = 3*(metrics.heightPixels/(width/3))-1;
        this.mCount = max-min+1;
    }

    // dynamtic add loading item
    public void addItems(int count) {
        mCount += count;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
