package com.enjoylife.ironghui.enjoylife.home.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.enjoylife.ironghui.enjoylife.R;
import com.enjoylife.ironghui.enjoylife.home.adapter.home_listview_adapter;
import com.enjoylife.ironghui.enjoylife.mainactivity.MyViewPager;

/**
 * Created by heyu on 2018/8/3.
 */

public class Home_Fragment extends Fragment {

    ViewPager mViewPager;
    static MyViewPager myViewPager;
    ListView mHome_Listview;
    home_listview_adapter mHome_listview_adapter;

    public static Home_Fragment getFragmeng(MyViewPager viewPager) {
        Home_Fragment fragmeng = new Home_Fragment();
        myViewPager = viewPager;
        return fragmeng;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.home_fragment_layout, container, false);

        mHome_Listview = view.findViewById(R.id.home_list);
        mHome_listview_adapter = new home_listview_adapter(getActivity().getBaseContext());
        mHome_Listview.setAdapter(mHome_listview_adapter);

        return view;
    }

    /**
     * 在此处处理网络请求
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
//			SendRequest();


        } else {
            // 相当于Fragment的onPause

        }
    }
}
