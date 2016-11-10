package wikileaf.app.com.wikileaf.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.ui.IconGenerator;
import com.melnykov.fab.FloatingActionButton;
import com.melnykov.fab.ScrollDirectionListener;

import java.util.ArrayList;
import java.util.HashMap;

import wikileaf.app.com.wikileaf.R;
import wikileaf.app.com.wikileaf.adapter.SeattleAdapter;
import wikileaf.app.com.wikileaf.adapter.SeattleListAdapter;

/**
 * Created by student on 5/21/2016.
 */
@SuppressLint("ValidFragment")
public class TabSeattleFragment1 extends Fragment {

  //  RecyclerView recyclerList;
    ListView lstview;
    FloatingActionButton fab;
    RelativeLayout rvList,rvMap;
    FloatingActionButton fab1;

    MapView mMapView;
    private GoogleMap googleMap;
    LatLng mLatLng;
    Context context;

    public TabSeattleFragment1(SeattleFragment seattleFragment) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab_fragment_seattle1, container, false);
        // Inflate the layout for this fragment
        rvList=(RelativeLayout)rootView.findViewById(R.id.rvList);
        rvList.setVisibility(View.VISIBLE);
        rvMap=(RelativeLayout)rootView.findViewById(R.id.rvMap);
        rvMap.setVisibility(View.GONE);

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        fab1=(FloatingActionButton)rootView.findViewById(R.id.fab1);
        fab1.setColorNormal(getActivity().getResources().getColor(R.color.colorPrimary));
        fab1.setColorPressed(getActivity().getResources().getColor(R.color.colorPrimaryDark));
        fab1.setColorRipple(getActivity().getResources().getColor(R.color.colorPrimaryDark));
        fab1.setType(FloatingActionButton.TYPE_NORMAL);

        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();// needed to get the map to display immediately
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap1) {
                googleMap=googleMap1;
                loadPinOnMap();
            }
        });
       // googleMap = mMapView.getMap();
        // latitude and longitude

        lstview=(ListView)rootView.findViewById(R.id.lstview);
        fab=(FloatingActionButton)rootView.findViewById(R.id.fab);
        fab.setColorNormal(getActivity().getResources().getColor(R.color.colorPrimary));
        fab.setColorPressed(getActivity().getResources().getColor(R.color.colorPrimaryDark));
        fab.setColorRipple(getActivity().getResources().getColor(R.color.colorPrimaryDark));
        fab.setType(FloatingActionButton.TYPE_NORMAL);

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvList.setVisibility(View.VISIBLE);
               // rvList.bringToFront();
                rvMap.setVisibility(View.GONE);
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvList.setVisibility(View.GONE);
                rvMap.setVisibility(View.VISIBLE);
            //    rvMap.bringToFront();
            }
        });

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // mapFragment.getMapAsync(this);
        if(googleMap==null){
            //googleMap=mMapView.getMap();
            mMapView.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap1) {
                    googleMap=googleMap1;
                    loadPinOnMap();
                }
            });
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<HashMap<String,String>> dataList=new ArrayList<>();
        for(int i=0;i<10;i++){
            HashMap<String,String> map=new HashMap<>();
            map.put("data",""+i);
            dataList.add(map);
        }
        if(lstview!=null){
            lstview.setDivider(null);
            SeattleAdapter seattleAdapter=new SeattleAdapter(getActivity());
            lstview.setAdapter(seattleAdapter);
        }else{
            lstview=(ListView)getActivity().findViewById(R.id.lstview);
            lstview.setDivider(null);
            SeattleAdapter seattleAdapter=new SeattleAdapter(getActivity());
            lstview.setAdapter(seattleAdapter);
        }
        fab.attachToListView(lstview, new ScrollDirectionListener() {
            @Override
            public void onScrollDown() {
                //fab.hide();
                fab.show();
            }

            @Override
            public void onScrollUp() {
                //fab.show();
                fab.hide();
            }
        });
       /* fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvList.setVerticalGravity(View.GONE);
                rvMap.setVerticalGravity(View.VISIBLE);
            }
        });*/
        /*SeattleListAdapter seattleListAdapter=new SeattleListAdapter(getActivity(),dataList);
        if(recyclerList!=null){
            recyclerList.setAdapter(seattleListAdapter);
        }else{
            recyclerList= (RecyclerView) getActivity().findViewById(R.id.recyclerList);
            recyclerList.setAdapter(seattleListAdapter);
        }*/
    }

    /* @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView=(RecyclerView)getActivity().findViewById(R.id.recyclerView);
        ArrayList<HashMap<String,String>> dataList=new ArrayList<>();
        for(int i=0;i<10;i++){
            HashMap<String,String> map=new HashMap<>();
            map.put("data",""+i);
            dataList.add(map);
        }
        SeattleListAdapter seattleListAdapter=new SeattleListAdapter(getActivity(),dataList);
    }*/
    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    public void loadPinOnMap(){
        if(googleMap!=null) {
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            googleMap.getMaxZoomLevel();
            googleMap.getUiSettings().setZoomControlsEnabled(false);
            googleMap.getUiSettings().setCompassEnabled(false);

            double latitude = 17.385044;
            double longitude = 78.486671;
            mLatLng = new LatLng(latitude,longitude);
            ///////////////////////////////////////////Add markar here

            // new AddMarkarAsyncTask().execute();
            IconGenerator iconGenerator=new IconGenerator(getActivity());
            iconGenerator.setColor(getActivity().getResources().getColor(R.color.colorPrimary));
            // iconGenerator.setBackground(getActivity().getResources().getDrawable(R.drawable.rounded_markar_baground));
            View view1=getActivity().getLayoutInflater().inflate(R.layout.custom_markar_layout,null);
            iconGenerator.setContentView(view1);
            Bitmap icon = iconGenerator.makeIcon();
            if(googleMap!=null){
                googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(icon))
                        .position(mLatLng));
            }

            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(mLatLng)
                    .zoom(12)
                    .bearing(0)
                    .tilt(30)
                    .build();
            googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
    }
}
