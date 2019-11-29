package edu.ualr.mxmckee.hospiceprognosis;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    @SuppressWarnings("deprecation")
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new LoginFragment(); //LoginFragment at position 0
            case 1:
                return new RegisterFragment(); //RegisterFragment at position 1
        }
        return null; //does not happen
    }

    @Override
    public int getCount() {
        return 2; //two fragments
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = getItem(position).getClass().getName();

        if (title.matches(LoginFragment.class.getName())) {
            String loginTitle = "LOG IN";
            return loginTitle;
        }
        else {
            String registerTitle = "REGISTER";
            return registerTitle;
        }
    }
}
