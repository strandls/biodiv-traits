/**
 * 
 */
package com.strandls.traits.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.strandls.traits.pojo.FactValuePair;
import com.strandls.traits.pojo.Facts;
import com.strandls.traits.pojo.FactsCreateData;
import com.strandls.traits.pojo.FactsUpdateData;
import com.strandls.traits.pojo.TraitsValue;
import com.strandls.traits.pojo.TraitsValuePair;

/**
 * @author Abhishek Rudra
 *
 */
public interface TraitsServices {

	public List<FactValuePair> getFacts(String objectType, Long objectId);

	public FactValuePair getFactIbp(Long id);

	public List<TraitsValuePair> getAllTraits();

	public List<TraitsValuePair> getTraitList(Long speciesId);

	public List<FactValuePair> createFacts(HttpServletRequest request, String objectType, Long objectId,
			FactsCreateData factsCreateData);

	public List<Facts> fetchByTaxonId(Long taxonId);

	public List<Long> fetchTaxonIdByValueId(String valueList);

	public List<TraitsValue> fetchTraitsValue(Long traitId);

	public List<FactValuePair> updateTraits(HttpServletRequest request, String objectType, Long objectId, Long traitId,
			FactsUpdateData factsUpdateData);

}
