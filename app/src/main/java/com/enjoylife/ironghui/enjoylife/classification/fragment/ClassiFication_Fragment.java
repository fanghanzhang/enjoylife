package com.enjoylife.ironghui.enjoylife.classification.fragment;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.enjoylife.ironghui.enjoylife.R;
import com.enjoylife.ironghui.enjoylife.classification.fragment.adapter.HomeAdapter;
import com.enjoylife.ironghui.enjoylife.classification.fragment.adapter.MenuAdapter;
import com.enjoylife.ironghui.enjoylife.classification.fragment.bean.CategoryBean;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by heyu on 2018/8/3.
 */

public class ClassiFication_Fragment extends Fragment {


    @BindView(R.id.lv_menu)
    ListView lvMenu;
    @BindView(R.id.lv_home)
    ListView lvHome;
    @BindView(R.id.tv_titile)
    TextView tvTitile;
    Unbinder unbinder;
    private List<Integer> showTitle;
    private List<String> menuList = new ArrayList<>();
    private List<CategoryBean.DataBean> homeList = new ArrayList<>();
    private MenuAdapter menuAdapter;
    private HomeAdapter homeAdapter;
    private int currentItem;

    public static ClassiFication_Fragment getFragmeng() {
        ClassiFication_Fragment fragmeng = new ClassiFication_Fragment();
        return fragmeng;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(getActivity());
        initHtml(getActivity());
    }

    private String initHtml(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        //获得assets资源管理器
        AssetManager assetManager = context.getAssets();
        //使用IO流读取json文件内容
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open("protocol.html"), "utf-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.classification_fragment_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView(view);
        loadData();//加载数据
        initHtml(getActivity());
        return view;
    }

    private void initView(View view) {

        menuAdapter = new MenuAdapter(view.getContext(), menuList);
        lvMenu.setAdapter(menuAdapter);
        homeAdapter = new HomeAdapter(view.getContext(), homeList);
        lvHome.setAdapter(homeAdapter);
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                menuAdapter.setSelectItem(position);
                menuAdapter.notifyDataSetInvalidated();
                tvTitile.setText(menuList.get(position));
                lvHome.setSelection(showTitle.get(position));
            }
        });
        lvHome.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int scrollState;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                this.scrollState = scrollState;
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    return;
                }
                int current = showTitle.indexOf(firstVisibleItem);
//				lv_home.setSelection(current);
                if (currentItem != current && current >= 0) {
                    currentItem = current;
                    tvTitile.setText(menuList.get(currentItem));
                    menuAdapter.setSelectItem(currentItem);
                    menuAdapter.notifyDataSetInvalidated();
                }
            }
        });
    }

    private void loadData() {
        String json = getJson(getContext(), "category.json");
        CategoryBean categoryBean = JSONObject.parseObject(json, CategoryBean.class);
        showTitle = new ArrayList<>();
        for (int i = 0; i < categoryBean.getData().size(); i++) {
            CategoryBean.DataBean dataBean = categoryBean.getData().get(i);
            menuList.add(dataBean.getModuleTitle());
            showTitle.add(i);
            homeList.add(dataBean);
        }
        tvTitile.setText(categoryBean.getData().get(0).getModuleTitle());

        menuAdapter.notifyDataSetChanged();
        homeAdapter.notifyDataSetChanged();

    }

    public static String getJson(Context context, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        //获得assets资源管理器
        AssetManager assetManager = context.getAssets();
        //使用IO流读取json文件内容
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(fileName), "utf-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
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
//			SendRequest() 发送网络

        } else {
            // 相当于Fragment的onPause

        }
    }

    @Override
    public boolean getUserVisibleHint() {

        return super.getUserVisibleHint();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
