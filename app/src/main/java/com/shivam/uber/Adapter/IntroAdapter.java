package com.shivam.uber.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shivam.uber.IntroFragment;


public class IntroAdapter extends FragmentPagerAdapter {

    public IntroAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return IntroFragment.newInstance(position);
            case 1:
                return IntroFragment.newInstance(position);
            case 2:
                return IntroFragment.newInstance(position);
            default:
                return IntroFragment.newInstance(position);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
