/**
 * 
 */
package com.strandls.traits.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;
import com.strandls.traits.ApiConstants;
import com.strandls.traits.pojo.FactValuePair;
import com.strandls.traits.services.TraitsServices;

/**
 * @author Abhishek Rudra
 *
 */

@Path(ApiConstants.V1 + ApiConstants.FACTSERVICE)
public class TraitsController {
	
	@Inject
	private TraitsServices services;
	
	@GET
	@Path(ApiConstants.PING)
	@Produces(MediaType.TEXT_PLAIN)
	public String ping() {
		return "PONG";
	}
	
	@GET
	@Path("/{observationId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<FactValuePair> getFacts(@PathParam("observationId") String obvId) {
		List<FactValuePair> facts = services.getFacts(Long.parseLong(obvId));
		return facts;
	}

}
