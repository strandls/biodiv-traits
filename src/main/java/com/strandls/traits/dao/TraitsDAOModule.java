/**
 * 
 */
package com.strandls.traits.dao;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

/**
 * @author Abhishek Rudra
 *
 */
public class TraitsDAOModule extends AbstractModule {

	@Override
	protected void configure() {

		bind(FactsDAO.class).in(Scopes.SINGLETON);
		bind(TraitTaxonomyDefinitionDao.class).in(Scopes.SINGLETON);
		bind(TraitsValueDao.class).in(Scopes.SINGLETON);

	}
}
