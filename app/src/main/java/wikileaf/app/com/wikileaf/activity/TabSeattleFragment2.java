package wikileaf.app.com.wikileaf.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wikileaf.app.com.wikileaf.R;

/**
 * Created by student on 5/21/2016.
 */
@SuppressLint("ValidFragment")
public class TabSeattleFragment2 extends Fragment {

    public TabSeattleFragment2(SeattleFragment seattleFragment) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_seattle, container, false);
        // Inflate the layout for this fragment
        return rootView;
    }
}
