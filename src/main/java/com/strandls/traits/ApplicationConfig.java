/**
 * 
 */
package com.strandls.traits;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.strandls.traits.controller.TraitsController;
import com.strandls.traits.pojo.FactValuePair;

/**
 * @author Abhishek Rudra
 *
 */
public class ApplicationConfig extends Application {

	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resource = new HashSet<Class<?>>();
		
		//SWAGGER ANNOTATION CLASS
		resource.add(TraitsController.class);
		resource.add(FactValuePair.class);
		
		resource.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
		resource.add(io.swagger.jaxrs.listing.ApiListingResource.class);

		return resource;
	}
}
