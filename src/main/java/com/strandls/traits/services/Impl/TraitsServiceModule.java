/**
 * 
 */
package com.strandls.traits.services.Impl;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.strandls.traits.services.TraitsServices;

/**
 * @author Abhishek Rudra
 *
 */
public class TraitsServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(TraitsServices.class).to(TraitsServicesImpl.class).in(Scopes.SINGLETON);
		bind(LogActivities.class).in(Scopes.SINGLETON);
	}
}
