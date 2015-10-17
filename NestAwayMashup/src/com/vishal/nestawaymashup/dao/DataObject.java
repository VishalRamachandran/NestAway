/**==============================================================================================
 * File        : DataObject.java
 * Version     : 1.0
 * Author      : Vishal Ramachandran
 * Date        : 22 Sep 2013
 * Company     : 
 * Description : This is the base class for the Data Objects.
 * History     :
 * ==============================================================================================
 *  Sr.No.    Date             Name               Description
 * ==============================================================================================
 *  01.     22 Sep 2013       Vishal R   		 Initial Version
 * ==============================================================================================
 */
package com.vishal.nestawaymashup.dao;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class DataObject implements Serializable {
	
	
	/**
	 * Used to get table fields
	 * @return Array of fields
	 */
	public abstract String[] getFields();
	
	/**
	 * Used to get table fields
	 * @return array of field types
	 */
	public abstract String[] getFieldTypes();
	
	/**
	 * Used to get table field keys
	 * @return array of field keys
	 */
	public abstract String[] getFieldKeys();
	
	/**
	 * Used to get table name
	 * @return table name
	 */
	public abstract String getTableName();
	
	/**
	 * Used get content values
	 * @return array of content values
	 */
	public abstract ArrayList<ContentValues> getContentValues();
	
	/**
	 * Used to set content values
	 * @param cursor : cursor to set
	 */
	public abstract void setContentValues(Cursor cursor);
	
	/**
	 * Used to set content values
	 * @param values : Content Values to set
	 */
	public abstract void setContentValues(ContentValues values);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 289012703016212414L;
	
	/**
	 * Sets the request url
	 * @param url : request url to set
	 */
	public abstract void setRequestUrl(String url);
	
	/**
	 * Returns the request url
	 * @return request url
	 */
	public abstract String getRequestUrl();
	
	
	/**
	 * Used to set JSON values
	 * @param values : JSON object to set
	 */
	public abstract void setJSONValues(JSONArray values);
	
	/**
     * Used to set JSON values
     * @param values : JSON object to set
     */
    public abstract void setJSONValues(JSONObject values);
    
    /**
     * Used to set XML values
     * @param values : XML values to set
     */
    public abstract void setXMLValues(JSONObject values);

}

