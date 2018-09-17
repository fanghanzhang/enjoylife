package com.enjoylife.ironghui.enjoylife.mainactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.enjoylife.ironghui.enjoylife.R;
import com.enjoylife.ironghui.enjoylife.classification.fragment.ClassiFication_Fragment;
import com.enjoylife.ironghui.enjoylife.home.fragment.Home_Fragment;
import com.enjoylife.ironghui.enjoylife.personalcenter.fragment.PersonAlcenter_Fragment;
import com.enjoylife.ironghui.enjoylife.shoppingcart.fragment.ShoppingCart_Fragment;
import com.enjoylife.ironghui.enjoylife.util.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by heyu on 2018/8/3.
 */
public class MainActivity extends FragmentActivity {

    private int currentTabIndex;
    LinearLayout mHomne_Button,mClassiFication_button,mShoppingCart_button,mPersonAlcenter_button;
    ImageView mHome_button_ico,mClassiFication_button_ico,mShoppingCart_button_ico,mPersonAlcenter_button_ico;
    TextView  mHome_button_text,mClassiFication_button_text,mShoppingCart_button_text,mPersonAlcenter_button_text;
    List<LinearLayout> mButton_List = new ArrayList<LinearLayout>();
    List<ImageView> mButton_ico_List = new ArrayList<ImageView>();
    List<TextView> mButton_ico_text_List = new ArrayList<TextView>();
    List<Fragment> mFragments = new ArrayList<Fragment>();

    public static MainActivity mainActicity;
    MainFragment_Adapter mFragment_Adapter;

    MyViewPager mViewPager;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity_layout);
        InitButton();
        mViewPager=findViewById(R.id.content);
        mViewPager.setNoScroll(true);
        mFragment_Adapter = new MainFragment_Adapter(getSupportFragmentManager(), mFragments);
        mViewPager.setOffscreenPageLimit(mFragments.size());
        mViewPager.setAdapter(mFragment_Adapter);
        mViewPager.setCurrentItem(0);
        mViewPager.setNoScroll(true);
        mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
        SetButtonOnclick();



    }



    public void InitButton(){


        mHomne_Button=(LinearLayout) findViewById(R.id.Home_button);
        mClassiFication_button=(LinearLayout)findViewById(R.id.ClassiFication_button);
        mShoppingCart_button=(LinearLayout)findViewById(R.id.ShoppingCart_button);
        mPersonAlcenter_button=(LinearLayout)findViewById(R.id.PersonAlcenter_button);

        mHome_button_ico=(ImageView) findViewById(R.id.Home_button_ico);
        mClassiFication_button_ico=(ImageView)findViewById(R.id.ClassiFication_button_ico);
        mShoppingCart_button_ico=(ImageView)findViewById(R.id.ShoppingCart_button_ico);
        mPersonAlcenter_button_ico=(ImageView)findViewById(R.id.PersonAlcenter_button_ico);

        mHome_button_text=(TextView) findViewById(R.id.Home_button_text);
        mClassiFication_button_text=(TextView)findViewById(R.id.ClassiFication_button_text);
        mShoppingCart_button_text=(TextView)findViewById(R.id.ShoppingCart_button_text);
        mPersonAlcenter_button_text=(TextView)findViewById(R.id.PersonAlcenter_button_text);

        mButton_List.add(mHomne_Button);
        mButton_List.add(mClassiFication_button);
        mButton_List.add(mShoppingCart_button);
        mButton_List.add(mPersonAlcenter_button);


        mButton_ico_List.add(mHome_button_ico);
        mButton_ico_List.add(mClassiFication_button_ico);
        mButton_ico_List.add(mShoppingCart_button_ico);
        mButton_ico_List.add(mPersonAlcenter_button_ico);

        mButton_ico_text_List.add(mHome_button_text);
        mButton_ico_text_List.add(mClassiFication_button_text);
        mButton_ico_text_List.add(mShoppingCart_button_text);
        mButton_ico_text_List.add(mPersonAlcenter_button_text);

        mFragments.add(Home_Fragment.getFragmeng(mViewPager));
        mFragments.add(ClassiFication_Fragment.getFragmeng());
        mFragments.add(ShoppingCart_Fragment.getFragmeng());
        mFragments.add(PersonAlcenter_Fragment.getFragmeng());



    }



    /**
     *点击事件
     */
    public void SetButtonOnclick() {

        for (int i=0;i<mButton_List.size();i++){
            mButton_List.get(i).setOnClickListener(new MyOnClickListener(i));
        }

    }

    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;

        }

        public void setViewpagerIndex(int index) {

        }

        public void onClick(View v) {

            Constants.mFrom="";
            setViewpagerIndex(index);
            mViewPager.setCurrentItem(index);
            currentTabIndex = index;
        }
    }


    /**
     * 设置菜单按钮背景
     * @param index
     */
    public void setMenuButtonBG(int index) {
        for (int i = 0; i < mButton_ico_List.size(); i++) {
            if (i == index) {
//                mButton_ico_List.get(i).setBackgroundDrawable(mDrawablesdown.get(i));
//                mButton_ico_text_List.get(index).setTextColor(
//                        getResources().getColor(R.color.main_down));
            } else {
//                mButton_ico_List.get(i).setBackgroundDrawable(mDrawablespass.get(i));
//                mButton_ico_text_List.get(i).setTextColor(
//                        MainActicity.this.getResources()
//                                .getColor(R.color.main_pass));
            }
        }
    }


    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        public void onPageSelected(int arg0) {
            setMenuButtonBG(arg0);

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    }

}
