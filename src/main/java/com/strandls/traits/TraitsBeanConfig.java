/**
 * 
 */
package com.strandls.traits;

import io.swagger.jaxrs.config.BeanConfig;

/**
 * @author Abhishek Rudra
 *
 */
public class TraitsBeanConfig extends BeanConfig {
	
	public TraitsBeanConfig() {
		super();
	}

	public void config() {
		setVersion("1.0");
		setTitle("Traits Module MicroServices");
		setSchemes(new String[] { "http" });
		setHost("localhost:8080");
		setBasePath("/traitsModule/api");
		setResourcePackage("com.strandls.traits");
		setScan(true);
		setPrettyPrint(true);
		
	}
}
