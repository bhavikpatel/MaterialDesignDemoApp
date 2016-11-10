package wikileaf.app.com.wikileaf.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import wikileaf.app.com.wikileaf.R;


/**
 * Created by student on 5/21/2016.
 */
@SuppressLint("ValidFragment")
public class TabSeattleFragment extends Fragment {

    MapView mMapView;
    private GoogleMap googleMap;
    LatLng mLatLng;
    Context context;
    FloatingActionButton fab1;

    @SuppressLint("ValidFragment")
    public TabSeattleFragment(SeattleFragment seattleFragment) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_seattle0, container, false);
        context=getActivity();
        // Inflate the layout for this fragment
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
        //googleMap = mMapView.getMap();
        // latitude and longitude

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // mapFragment.getMapAsync(this);
        if(googleMap==null){
            mMapView.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap1) {
                    googleMap=googleMap1;
                    loadPinOnMap();
                }
            });
            //googleMap=mMapView.getMap();
        }
    }

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
            IconGenerator iconGenerator=new IconGenerator(context);
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

            fab1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"FAB Click",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
