package com.vishal.nestawaymashup;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.vishal.nestawaymashup.control.DownloadTask;
import com.vishal.nestawaymashup.control.EventListener;
import com.vishal.nestawaymashup.dao.DataObject;
import com.vishal.nestawaymashup.dao.HousesDao;


public class MainActivity extends FragmentActivity implements EventListener {
	
	GoogleMap googleMap;
	private ArrayList<HousesDao> mHouseList = new ArrayList<HousesDao>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				new DownloadTask(MainActivity.this, MainActivity.this).execute();

			}
		});
		
		
	}
	
	private void drawMap() {
		// Getting Google Play availability status
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());
 
        // Showing status
        if(status!=ConnectionResult.SUCCESS){ // Google Play Services are not available
 
            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
            dialog.show();
 
        }else { // Google Play Services are available
 
            // Getting reference to the SupportMapFragment of activity_main.xml
            SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
 
            // Getting GoogleMap object from the fragment
            googleMap = fm.getMap();
 
            // Enabling MyLocation Layer of Google Map
            googleMap.setMyLocationEnabled(true);
            
            double lat;
            double lng;
            
            for (int i= 0; i < mHouseList.size(); i++) {
            	lat = mHouseList.get(i).getLatitude();
            	lng = mHouseList.get(i).getLongitude();
            	// Drawing marker on the map
                drawMarker(new LatLng(lat, lng));
            }
            
        }
 
        googleMap.setOnMapClickListener(new OnMapClickListener() {
 
            @Override
            public void onMapClick(LatLng point) {
 
            }
        });
 
        
	}
	
	private void drawMarker(LatLng point){
        // Creating an instance of MarkerOptions
        MarkerOptions markerOptions = new MarkerOptions();
 
        // Setting latitude and longitude for the marker
        markerOptions.position(point);
 
        // Adding marker on the Google Map
        googleMap.addMarker(markerOptions);
    }

	@Override
	public void onEvent(DataObject dataObject) {
		//Send the result to UI handler
		Message message = new Message();
		message.obj = dataObject;
		uiHandler.sendMessage(message);

	}
	
	/**
	 * UI handler to handle messages
	 */
	@SuppressLint("HandlerLeak")
	private Handler uiHandler = new Handler() {

		/*
		 * (non-Javadoc)
		 * @see android.os.Handler#handleMessage(android.os.Message)
		 */
		@Override
		public void handleMessage(Message msg) {
			if (msg.obj instanceof HousesDao) {
				HousesDao dao = (HousesDao) msg.obj;
				mHouseList = dao.getHouseList();
				
			}
			
		}

	};
}
