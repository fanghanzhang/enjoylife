package com.enjoylife.ironghui.enjoylife.personalcenter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.enjoylife.ironghui.enjoylife.R;

/**
 * Created by heyu on 2018/8/3.
 */

public class PersonAlcenter_Fragment extends Fragment{



    public static PersonAlcenter_Fragment getFragmeng() {
        PersonAlcenter_Fragment fragmeng = new PersonAlcenter_Fragment();
        return fragmeng;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        View view =inflater.inflate(R.layout.personalcenter_fragment_layout,container,false);


//        Init(view);
        return view;
    }

    /**
     * 在此处处理网络请求
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
