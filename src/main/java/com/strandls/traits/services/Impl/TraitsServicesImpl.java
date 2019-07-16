/**
 * 
 */
package com.strandls.traits.services.Impl;

import java.util.List;

import com.google.inject.Inject;
import com.strandls.traits.dao.FactsDAO;
import com.strandls.traits.pojo.FactValuePair;
import com.strandls.traits.services.TraitsServices;

/**
 * @author Abhishek Rudra
 *
 */
public class TraitsServicesImpl implements TraitsServices {

	@Inject
	private FactsDAO factsDao;

	@Override
	public List<FactValuePair> getFacts(Long id) {
		List<FactValuePair> facts = factsDao.getTraitValuePair(id);
		return facts;
	}

}
