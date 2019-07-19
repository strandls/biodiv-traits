/**
 * 
 */
package com.strandls.traits;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author Abhishek Rudra
 *
 */
public class ApplicationConfig extends ResourceConfig {

	public ApplicationConfig() {
		packages("com.strandls.traits.controller");
		register(io.swagger.jaxrs.listing.SwaggerSerializers.class);
		register(io.swagger.jaxrs.listing.ApiListingResource.class);

	}
}
