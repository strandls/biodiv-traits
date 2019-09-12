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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.inject.Inject;
import com.strandls.traits.ApiConstants;
import com.strandls.traits.pojo.FactValuePair;
import com.strandls.traits.services.TraitsServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Abhishek Rudra
 *
 */
@Api("Traits Service")
@Path(ApiConstants.V1 + ApiConstants.FACTSERVICE)
public class TraitsController {

	@Inject
	private TraitsServices services;

	@GET
	@Path(ApiConstants.PING)
	@Produces(MediaType.TEXT_PLAIN)

	@ApiOperation(value = "Dummy API Ping", notes = "Checks validity of war file at deployment", response = String.class)
	public Response ping() {
		return Response.status(Status.OK).entity("PONG").build();
	}

	@GET
	@Path("/{observationId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)

	@ApiOperation(value = "Find Traits by Observation ID", notes = "Returns the key value pair of Tarits for a particular Observation", response = FactValuePair.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Traits not found", response = String.class) })

	public Response getFacts(
			@ApiParam(value = "ID of Show that needs to be fetched", required = true) @PathParam("observationId") String obvId) {

		Long id;
		try {
			id = Long.parseLong(obvId);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		List<FactValuePair> facts = services.getFacts(id);
		return Response.status(Status.OK).entity(facts).build();
	}

	@GET
	@Path(ApiConstants.IBP + "/{traitId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)

	@ApiOperation(value = "Find Traits by Observation ID for ibp", notes = "Returns the key value pair of Tarits for a particular Observation", response = FactValuePair.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Traits not found", response = String.class) })

	public Response getFactIbp(@PathParam("traitId") String traitId) {
		try {
			Long id = Long.parseLong(traitId);
			FactValuePair fact = services.getFactIbp(id);
			return Response.status(Status.OK).entity(fact).build();

		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

}