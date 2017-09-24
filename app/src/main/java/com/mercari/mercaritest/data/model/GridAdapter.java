package com.mercari.mercaritest.data.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mercari.mercaritest.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.mercari.mercaritest.R.layout.grid_cell;

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
        // load new view
        if(convertView==null || position<min || position>max || (up==true && position==min+1)) {
            // scroll up and load
            if(position<min || (up==true && position==min+1)) {
                up = true;
                down = false;
                min--;
                max--;
            }
            // scroll down and load
            if(position>max) {
                up = false;
                down = true;
                min++;
                max++;
            }
            // load cell
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View cellView = new View(context);
            cellView = inflater.inflate(grid_cell, null);

            // set value
            TextView priceTxt = (TextView) cellView.findViewById(R.id.itemPrice);
            TextView nameTxt = (TextView) cellView.findViewById(R.id.itemName);
            ImageView photoImg = (ImageView) cellView.findViewById(R.id.itemPhoto);

            // price
            priceTxt.setText("$"+Long.toString(data.get(position).price));

            // name
            nameTxt.setText(data.get(position).name);

            // photo
            String url = data.get(position).photo;
            Bitmap bp1 = loadImgFromUrlFunc(url.substring(0,4)+"s"+url.substring(4), data.get(position).id);
            Drawable dw1 = new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(bp1, width/3-9, width/3-9, false));
            photoImg.getLayoutParams().width = width/3-18;
            photoImg.getLayoutParams().height = width/3-18;
            photoImg.setBackground(dw1);

            // sold out
            if(data.get(position).status.equals("sold_out"))
                photoImg.setImageResource(R.mipmap.sold);

            return cellView;
        } else {
            // use exist view
            return convertView;
        }
    }

    // load bitmap from photo url
    private Bitmap loadImgFromUrlFunc(String url, String name) {
        Bitmap res = null;

        try {
            res = new loadImgFromUrl().execute(url).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return res;
    }

    // asynctask for loading photo from server
    private static class loadImgFromUrl extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {
            //invalid input
            if(params==null || params.length!=1)return null;
            InputStream is = null;
            Bitmap res = null;

            try {
                is = new URL(params[0]).openStream();
                res = BitmapFactory.decodeStream(is);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return res;
        }

    }
}
