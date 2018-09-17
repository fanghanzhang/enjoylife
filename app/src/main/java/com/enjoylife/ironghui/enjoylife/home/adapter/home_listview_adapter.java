package com.enjoylife.ironghui.enjoylife.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.enjoylife.ironghui.enjoylife.R;

/**
 * Created by heyu on 2018/8/6.
 */

public class home_listview_adapter extends BaseAdapter {


    Context mContext;

    public home_listview_adapter(Context context){
        mContext=context;

    }
    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolde mViewHolde;
        if (convertView==null){
            convertView= LinearLayout.inflate(mContext, R.layout.item_homelistview_layout,null);
            mViewHolde=new ViewHolde();
            convertView.setTag(mViewHolde);
        }else {
            mViewHolde= (ViewHolde) convertView.getTag();
        }

        return convertView;
    }


    class ViewHolde{
     ImageView mImageView;
     TextView mTextView;


    }
}
