package com.vishal.nestawaymashup.dao;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.ContentValues;
import android.database.Cursor;

public class HousesDao extends DataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mBhkDetails;
	private String mHouseType;
	private int mID;
	private int mStatusCode;
	private String mTitle;
	private double mLatitude;
	private double mLongitude;
	private int mBedAvailCount;
	private int mMinRent;
	private String mSlug;
	private String mNestawayID;
	private int mShared;
	private int mPrivate;
	private String mImgUrl;
	private String mGender;
	private String mLocality;
	private ArrayList<HousesDao> mHouseList = new ArrayList<HousesDao>();

	@Override
	public String[] getFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getFieldTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getFieldKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ContentValues> getContentValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContentValues(Cursor cursor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContentValues(ContentValues values) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRequestUrl(String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getRequestUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setJSONValues(JSONArray values) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJSONValues(JSONObject values) {
		try {
			if (values != null) {
				JSONArray jsonArray = values.getJSONArray("houses");
				
				//Iterate the jsonArray and print the info of JSONObjects
			     for(int i=0; i < jsonArray.length(); i++){
			        JSONObject jsonObject = jsonArray.getJSONObject(i);
			        
			        HousesDao dao = new HousesDao();
			        dao.setBhkDetails(jsonObject.optString("bhk_details").toString());
			        dao.setHouseType(jsonObject.optString("house_type").toString());
			        dao.setID(jsonObject.optInt("id"));
			        dao.setStatusCode(jsonObject.optInt("status_code"));
			        dao.setTitle(jsonObject.optString("title"));
			        dao.setLatitude(jsonObject.optDouble("lat_double"));
			        dao.setLongitude(jsonObject.optDouble("long_double"));
			        dao.setBedAvailCount(jsonObject.optInt("bed_available_count"));
			        dao.setMinRent(jsonObject.optInt("min_rent"));
			        dao.setSlug(jsonObject.optString("slug"));
			        dao.setNestawayID(jsonObject.optString("nestaway_id"));
			        dao.setShared(jsonObject.optInt("shared"));
			        dao.setPrivate(jsonObject.optInt("private"));
			        dao.setImgUrl(jsonObject.optString("image_url"));
			        dao.setGender(jsonObject.optString("gender"));
			        dao.setLocality(jsonObject.optString("locality"));
			        
			        mHouseList.add(dao);
			     }
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setXMLValues(JSONObject values) {
		// TODO Auto-generated method stub
		
	}

	public String getBhkDetails() {
		return mBhkDetails;
	}

	public void setBhkDetails(String mBhkDetails) {
		this.mBhkDetails = mBhkDetails;
	}

	public String getHouseType() {
		return mHouseType;
	}

	public void setHouseType(String mHouseType) {
		this.mHouseType = mHouseType;
	}

	public int getID() {
		return mID;
	}

	public void setID(int mID) {
		this.mID = mID;
	}

	public int getStatusCode() {
		return mStatusCode;
	}

	public void setStatusCode(int mStatusCode) {
		this.mStatusCode = mStatusCode;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public double getLatitude() {
		return mLatitude;
	}

	public void setLatitude(double mLatitude) {
		this.mLatitude = mLatitude;
	}

	public double getLongitude() {
		return mLongitude;
	}

	public void setLongitude(double mLongitude) {
		this.mLongitude = mLongitude;
	}

	public int getBedAvailCount() {
		return mBedAvailCount;
	}

	public void setBedAvailCount(int mBedAvailCount) {
		this.mBedAvailCount = mBedAvailCount;
	}

	public int getMinRent() {
		return mMinRent;
	}

	public void setMinRent(int mMinRent) {
		this.mMinRent = mMinRent;
	}

	public String getSlug() {
		return mSlug;
	}

	public void setSlug(String mSlug) {
		this.mSlug = mSlug;
	}

	public String getNestawayID() {
		return mNestawayID;
	}

	public void setNestawayID(String mNestawayID) {
		this.mNestawayID = mNestawayID;
	}

	public int getShared() {
		return mShared;
	}

	public void setShared(int mShared) {
		this.mShared = mShared;
	}

	public int getPrivate() {
		return mPrivate;
	}

	public void setPrivate(int mPrivate) {
		this.mPrivate = mPrivate;
	}

	public String getImgUrl() {
		return mImgUrl;
	}

	public void setImgUrl(String mImgUrl) {
		this.mImgUrl = mImgUrl;
	}

	public String getGender() {
		return mGender;
	}

	public void setGender(String mGender) {
		this.mGender = mGender;
	}

	public String getLocality() {
		return mLocality;
	}

	public void setLocality(String mLocality) {
		this.mLocality = mLocality;
	}

	public ArrayList<HousesDao> getHouseList() {
		return mHouseList;
	}

	public void setHouseList(ArrayList<HousesDao> mHouseList) {
		this.mHouseList = mHouseList;
	}

}
