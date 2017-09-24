package com.mercari.mercaritest.data.model;


import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class HomeResponse {
    public String url;
    public Response rp;

    public HomeResponse(String url, Context context) {
        this.url = url;
        String res = null;
        // get data from json file
        JSONObject data = parseJsonData(this.url, context);

        try {
            res = data.getString("result");
            // when data is valid, do anaylsis
            if(res.equals("ok")) {
                JSONArray ja = data.getJSONArray("data");
                int len = ja.length();
                // if there are data of items, store
                if(len > 0) {
                    List<Item> list = new ArrayList<Item>();
                    for(int i=0; i<len; i++) {
                        JSONObject obj = ja.getJSONObject(i);
                        String id = obj.getString("id");
                        String name = obj.getString("name");
                        long num_likes = obj.getLong("num_likes");
                        long num_comments = obj.getLong("num_comments");
                        long price = obj.getLong("price");
                        String photo = obj.getString("photo");
                        String status = obj.getString("status");
                        list.add(new Item(id,name,num_likes,num_comments,price,photo,status));
                    }
                    rp = new Response(res, list);
                }else {
                    // if there is no data, end task
                    rp = null;
                    return;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            rp = null;
            return;
        }

    }

    // parseJsonData: get data from json file
    private JSONObject parseJsonData(String url, Context context) {
        String jsonStr = null;
        JSONObject res = null;

        try {
            // open json file by filename
            InputStream is = context.getAssets().open(url);
            // init array for storage
            int sizeOfJson = is.available();
            byte[] bytes = new byte[sizeOfJson];
            // read data into array
            is.read(bytes);
            is.close();
            //create jsonobject
            jsonStr = new String(bytes, "UTF-8");
            res = new JSONObject(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res;

    }

}
