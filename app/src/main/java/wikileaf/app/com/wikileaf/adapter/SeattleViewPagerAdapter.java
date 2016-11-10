package wikileaf.app.com.wikileaf.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import wikileaf.app.com.wikileaf.activity.SeattleFragment;
import wikileaf.app.com.wikileaf.activity.TabSeattleFragment;

/**
 * Created by student on 5/21/2016.
 */
public class SeattleViewPagerAdapter extends FragmentStatePagerAdapter {
    Fragment[] sattleFragmentArray;
    SeattleFragment seattleFragment;
    public SeattleViewPagerAdapter(FragmentManager fm, Fragment[] sattleFragmentArray, SeattleFragment seattleFragment) {
        super(fm);
        this.sattleFragmentArray=sattleFragmentArray;
        this.seattleFragment=seattleFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return sattleFragmentArray[position];
    }

    @Override
    public int getCount() {
        return sattleFragmentArray.length;
    }
}
