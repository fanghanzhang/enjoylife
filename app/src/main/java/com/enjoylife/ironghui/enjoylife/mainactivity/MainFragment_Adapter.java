package com.enjoylife.ironghui.enjoylife.mainactivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import java.util.List;

/**
 * vatty *
 * 
 * heyu
 * 
 */
public class MainFragment_Adapter extends FragmentPagerAdapter {
	private List<Fragment> fragmentsList;
	FragmentManager fm;

	public MainFragment_Adapter(FragmentManager fm) {
		super(fm);

	}

	public MainFragment_Adapter(FragmentManager fm, List<Fragment> fragments) {
		super(fm);
		this.fragmentsList = fragments;
		this.fm = fm;
	}

	@Override
	public int getCount() {
		return fragmentsList.size();
	}

	@Override
	public Fragment getItem(int arg0) {
		return fragmentsList.get(arg0);
	}

	@Override
	public int getItemPosition(Object object) {
		return super.getItemPosition(object);
	}

	@Override
	public Object instantiateItem(View container, int position) {
		Fragment fragment = (Fragment) super.instantiateItem(container,position);
		String fragmentTag = fragment.getTag();
		FragmentTransaction ft = fm.beginTransaction();
		ft.remove(fragment);
		fragment = fragmentsList.get(position);
		ft.add(container.getId(), fragment, fragmentTag);
		ft.attach(fragment);
		ft.commit();
		return fragment;
	}

}
