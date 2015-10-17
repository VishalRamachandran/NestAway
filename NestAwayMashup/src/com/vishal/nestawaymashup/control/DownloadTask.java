package com.vishal.nestawaymashup.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.vishal.nestawaymashup.dao.HousesDao;
import com.vishal.nestawaymashup.util.Utility;

public class DownloadTask extends AsyncTask<Void, Void, Void> {
	
	private EventListener mEventListener;
	private ProgressDialog progressDialog;
	private Context mContext;
	private HousesDao mHouseDao;
	
	public DownloadTask(EventListener eventListener, Context context) {
		this.mEventListener = eventListener;
		this.mContext = context;
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		Utility.showProgressBar(mContext, "Please wait...", "Data download in progress");
	}

	@Override
	protected Void doInBackground(Void... arg0) {
		
		String strResult = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL("http://a88a4240.ngrok.io");
            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();
 
            // Connecting to url
            urlConnection.connect();
 
            // Reading data from url
            iStream = urlConnection.getInputStream();
 
            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
 
            StringBuffer sb = new StringBuffer();
 
            String line = "";
            while( ( line = br.readLine()) != null){
                sb.append(line);
            }
 
            strResult = sb.toString();
 
            br.close();
            
            parseResponse(strResult);
 
        }catch(Exception e){
            Log.d("Exception while fetching data", e.toString());
        }finally{
            try {
				iStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
            urlConnection.disconnect();
        }
        
		return null;
	}
	
	private void parseResponse(String response) {
		try {
			JSONObject json = new JSONObject(response);
			
			mHouseDao = new HousesDao();
			mHouseDao.setJSONValues(json);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		Utility.dismissProgressBar(progressDialog);
		mEventListener.onEvent(mHouseDao);
	}
	

}
