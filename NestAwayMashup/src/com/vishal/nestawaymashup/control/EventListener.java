/**==============================================================================================
 * File        : EventListener.java
 * Version     : 1.0
 * Author      : Vishal Ramachandran
 * Date        : 22 Sep 2013
 * Company     : VuFirst
 * Description : This class is used for callback to the UI
 * History     :
 * ==============================================================================================
 *  Sr.No.    Date             Name               Description
 * ==============================================================================================
 *  01.     22 Sep 2013      Vishal R        Initial Version
 * ==============================================================================================
 */
package com.vishal.nestawaymashup.control;

import com.vishal.nestawaymashup.dao.DataObject;


public interface EventListener {
	
	/**
     * Used to notify response 
     * @param event : Event Object
     */
    public void onEvent(DataObject dataObject);
    
}
