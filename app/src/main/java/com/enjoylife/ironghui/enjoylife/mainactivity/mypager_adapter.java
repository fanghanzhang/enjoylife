package com.enjoylife.ironghui.enjoylife.mainactivity;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by heyu on 16/6/8.
 */
public class mypager_adapter extends PagerAdapter {

    private List<ImageView> mImageViewList;

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 0;
    }

    /**
     * Determines whether a page View is associated with a specific key object
     * as returned by {@link #instantiateItem(ViewGroup, int)}. This method is
     * required for a PagerAdapter to function properly.
     *
     * @param view   Page View to check for association with <code>object</code>
     * @param object Object to check for association with <code>view</code>
     * @return true if <code>view</code> is associated with the key object <code>object</code>
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {


        return false;
    }

    /**
     * 销毁预加载以外的view对象, 会把需要销毁的对象的索引位置传进来，就是position，
     * 因为mImageViewList只有五条数据，而position将会取到很大的值，
     * 所以使用取余数的方法来获取每一条数据项。
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mImageViewList.get(position % mImageViewList.size()));
    }
    /**
     * 创建一个view，
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mImageViewList.get(position % mImageViewList.size()));
        return mImageViewList.get(position % mImageViewList.size());
    }

}
