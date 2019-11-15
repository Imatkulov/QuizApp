package com.geektech.quizapp.presentation.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.geektech.quizapp.presentation.history.HistoryFragment;
import com.geektech.quizapp.presentation.settings.SettingsFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
            return new MainFragment();
            case 1:
            return new HistoryFragment();
            case 2:
            return new SettingsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
