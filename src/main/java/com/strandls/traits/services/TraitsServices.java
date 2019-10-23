/**
 * 
 */
package com.strandls.traits.services;

import java.util.List;

import com.strandls.traits.pojo.FactValuePair;
import com.strandls.traits.pojo.TraitsValuePair;

/**
 * @author Abhishek Rudra
 *
 */
public interface TraitsServices {

	public List<FactValuePair> getFacts(String objectType, Long objectId);

	public FactValuePair getFactIbp(Long id);

	public List<TraitsValuePair> getTraitList(Long speciesId);

	public List<FactValuePair> createFacts(String objectType, Long objectId, List<FactValuePair> factList);

}
