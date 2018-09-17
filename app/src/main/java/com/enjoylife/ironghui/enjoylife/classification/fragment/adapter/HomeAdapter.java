package com.enjoylife.ironghui.enjoylife.classification.fragment.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.enjoylife.ironghui.enjoylife.R;
import com.enjoylife.ironghui.enjoylife.classification.fragment.bean.CategoryBean;
import com.enjoylife.ironghui.enjoylife.classification.fragment.view.GridViewForScrollView;

import java.util.List;

/**
 * 右侧主界面ListView的适配器
 *
 * @author Administrator
 */
public class HomeAdapter extends BaseAdapter {

    private Context context;
    private List<CategoryBean.DataBean> foodDatas;

    public HomeAdapter(Context context, List<CategoryBean.DataBean> foodDatas) {
        this.context = context;
        this.foodDatas = foodDatas;
    }

    @Override
    public int getCount() {
        if (foodDatas != null) {
            return foodDatas.size();
        } else {
            return 10;
        }
    }

    @Override
    public Object getItem(int position) {
        return foodDatas.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CategoryBean.DataBean dataBean = foodDatas.get(position);
        List<CategoryBean.DataBean.DataListBean> dataList = dataBean.getDataList();
        ViewHold viewHold = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_home, null);
            viewHold = new ViewHold();
            viewHold.gridView = (GridViewForScrollView) convertView.findViewById(R.id.gridview);
            viewHold.blank = (TextView) convertView.findViewById(R.id.blank);
            convertView.setTag(viewHold);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }
        HomeItemAdapter adapter = new HomeItemAdapter(context, dataList);
        viewHold.blank.setText(dataBean.getModuleTitle());
        viewHold.gridView.setAdapter(adapter);
        viewHold.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, position + "", Toast.LENGTH_SHORT).show();
                Log.d("gridview", position + ":gridview");
            }
        });
        return convertView;
    }

    private static class ViewHold {
        private GridViewForScrollView gridView;
        private TextView blank;
    }

}
