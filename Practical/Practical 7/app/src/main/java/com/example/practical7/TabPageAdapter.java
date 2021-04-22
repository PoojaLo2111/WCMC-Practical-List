package com.example.practical7;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabPageAdapter extends FragmentPagerAdapter {

    public TabPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {
        if(i==0){
            return new CardViewFragment();
        }
        else if(i==1){
            return new ListViewFragment();
        }
        else if(i==2){
            return new GridViewFragment();
        }
        else if(i==3){
            return new ScrollViewFragment();
        }
        else
            return new WebViewFragment();
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return "Card View";
        }
        else if(position == 1){
            return "List View";
        }
        else if(position == 2) {
            return "Grid View";
        }
        else if(position == 3){
            return "Scroll View";
        }
        else {
            return "Web View";
        }
    }
}
