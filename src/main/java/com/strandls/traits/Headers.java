/**
 * 
 */
package com.strandls.traits;

import javax.ws.rs.core.HttpHeaders;

import com.strandls.activity.controller.ActivitySerivceApi;

/**
 * @author Abhishek Rudra
 *
 */
public class Headers {

	public ActivitySerivceApi addActivityHeader(ActivitySerivceApi activityService, String token) {
		activityService.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, token);
		return activityService;
	}

}
