/**
 * 
 */
package com.strandls.traits.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.inject.Inject;
import com.strandls.traits.ApiConstants;
import com.strandls.traits.pojo.FactValuePair;
import com.strandls.traits.pojo.TraitsValuePair;
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
	@Path("/{objectType}/{objectId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)

	@ApiOperation(value = "Find Traits by objectType and Object ID", notes = "Returns the key value pair of Tarits for a particular Object", response = FactValuePair.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Traits not found", response = String.class) })

	public Response getFacts(@PathParam("objectType") String objectType,
			@ApiParam(value = "ID of Show that needs to be fetched", required = true) @PathParam("objectId") String objectId) {

		try {
			Long objId = Long.parseLong(objectId);
			List<FactValuePair> facts = services.getFacts(objectType, objId);
			return Response.status(Status.OK).entity(facts).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}

	}

	@POST
	@Path(ApiConstants.CREATE + "/{objectType}/{objectId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	@ApiOperation(value = "Create facts for a Object", notes = "Returns the Success and failure", response = FactValuePair.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Traits not found", response = String.class),
			@ApiResponse(code = 206, message = "Patially created", response = String.class) })

	public Response createFacts(@PathParam("objectType") String objectType, @PathParam("objectId") String objectId,
			@ApiParam(name = "facts") List<FactValuePair> factValuePairs) {
		try {
			Long objId = Long.parseLong(objectId);
			List<FactValuePair> result = services.createFacts(objectType, objId, factValuePairs);
			if (result.isEmpty())
				return Response.status(Status.CREATED).entity(null).build();
			return Response.status(206).entity(result).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path(ApiConstants.IBP + "/{traitId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)

	@ApiOperation(value = "Find Traits by Traits ID for ibp", notes = "Returns the key value pair of Tarits", response = FactValuePair.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Traits not found", response = String.class) })

	public Response getFactIbp(@PathParam("traitId") String traitId) {
		try {
			Long id = Long.parseLong(traitId);
			FactValuePair fact = services.getFactIbp(id);
			return Response.status(Status.OK).entity(fact).build();

		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path(ApiConstants.SPECIESID + "/{speciesId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)

	@ApiOperation(value = "Find all Trait Values pair for Specific SpeciesId", notes = "Return the Key value pairs of Traits", response = TraitsValuePair.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Species Not Found", response = String.class) })

	public Response getTraitList(@PathParam("speciesId") String speciesId) {

		try {
			Long sGroup = Long.parseLong(speciesId);
			List<TraitsValuePair> result = services.getTraitList(sGroup);
			return Response.status(Status.OK).entity(result).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}

	}

}
