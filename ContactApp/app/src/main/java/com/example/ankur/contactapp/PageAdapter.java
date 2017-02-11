package com.example.ankur.contactapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by ankur on 10/2/17.
 */

public class PageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ContactListFragment();
                break;
            case 1:
                fragment = new SmsListFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
