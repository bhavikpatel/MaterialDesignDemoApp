package wikileaf.app.com.wikileaf.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import wikileaf.app.com.wikileaf.R;
import wikileaf.app.com.wikileaf.adapter.SeattleViewPagerAdapter;

/**
 * Created by student on 5/21/2016.
 */
public class SeattleFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private SeattleViewPagerAdapter viewPagerAdapter;
    SeattleFragment seattleFragment;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        seattleFragment=this;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_seattle, container, false);

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tabLayout = (TabLayout) getActivity().findViewById(R.id.tabs);
        viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager);

        AdView mAdView = (AdView) getActivity().findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

      /*  TextView name=(TextView)getActivity().findViewById(R.id.name);
        name.setText("Bhavik");*/
        Fragment SattleFragmentArray[]={new TabSeattleFragment(seattleFragment),new TabSeattleFragment1(seattleFragment),
        new TabSeattleFragment2(seattleFragment),new TabSeattleFragment3(seattleFragment),new TabSeattleFragment4(seattleFragment)};

        viewPagerAdapter = new SeattleViewPagerAdapter(getActivity().getSupportFragmentManager(),SattleFragmentArray,SeattleFragment.this);
        viewPager.setAdapter(viewPagerAdapter);

        final TabLayout.Tab gm1 = tabLayout.newTab();
        final TabLayout.Tab oz18 = tabLayout.newTab();
        final TabLayout.Tab oz14 = tabLayout.newTab();
        final TabLayout.Tab oz12 = tabLayout.newTab();
        final TabLayout.Tab oz1 = tabLayout.newTab();

        gm1.setText("1 GM");
        oz18.setText("1/8 OZ");
        oz14.setText("1/4 OZ");
        oz12.setText("1/2 OZ");
        oz1.setText("1 OZ");

        tabLayout.addTab(gm1, 0);
        tabLayout.addTab(oz18, 1);
        tabLayout.addTab(oz14, 2);
        tabLayout.addTab(oz12,3);
        tabLayout.addTab(oz1,4);

        tabLayout.setTabTextColors(ContextCompat.getColorStateList(getActivity(), R.drawable.tab_selector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(getActivity(), R.color.indicator));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
