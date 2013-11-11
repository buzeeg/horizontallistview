package com.remifayolle.horizontallistviewsample;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by rem on 15/06/13.
 */
public class ColorListViewAdapter extends BaseAdapter implements ListAdapter {

    private String TAG = "ColorListViewAdapter";
    private Context mContext = null;
    private int mNbElements = 0;
    private ArrayList<Integer> mColorArray = null;

    public ColorListViewAdapter(Context context, int nbChilds) {
        mContext = context;
        mNbElements = nbChilds;

        // Init random color array
        mColorArray = new ArrayList<Integer>();
        Random color = new Random();
        for (int i=0; i<mNbElements; i++) {
            mColorArray.add(Color.rgb(color.nextInt(256),color.nextInt(256),color.nextInt(256)));
        }
    }

    @Override
    public int getCount() {
        return mNbElements;
    }

    @Override
    public Object getItem(int position) {
        return mColorArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        }
        else {
            Log.i(TAG, "Converting view !");
        }
        Integer color = mColorArray.get(position);
        if( v != null) {
            v.setBackgroundColor(color);
        }
        return v;
    }
}
