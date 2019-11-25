/**
 * 
 */
package com.strandls.traits.services.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.pac4j.core.profile.CommonProfile;

import com.google.inject.Inject;
import com.strandls.authentication_utility.util.AuthUtil;
import com.strandls.taxonomy.ApiException;
import com.strandls.taxonomy.controllers.TaxonomyServicesApi;
import com.strandls.traits.dao.FactsDAO;
import com.strandls.traits.dao.TraitTaxonomyDefinitionDao;
import com.strandls.traits.dao.TraitsValueDao;
import com.strandls.traits.pojo.FactValuePair;
import com.strandls.traits.pojo.Facts;
import com.strandls.traits.pojo.TraitTaxonomyDefinition;
import com.strandls.traits.pojo.Traits;
import com.strandls.traits.pojo.TraitsValue;
import com.strandls.traits.pojo.TraitsValuePair;
import com.strandls.traits.services.TraitsServices;

/**
 * @author Abhishek Rudra
 *
 */
public class TraitsServicesImpl implements TraitsServices {

	@Inject
	private FactsDAO factsDao;

	@Inject
	private TraitTaxonomyDefinitionDao traitTaxonomyDef;

	@Inject
	private TaxonomyServicesApi taxonomyService;

	@Inject
	private TraitsValueDao traistValueDao;

	@Override
	public List<FactValuePair> getFacts(String objectType, Long objectId) {
		List<FactValuePair> facts = factsDao.getTraitValuePair(objectType, objectId);
		return facts;
	}

	@Override
	public FactValuePair getFactIbp(Long id) {
		FactValuePair fact = factsDao.getTraitvaluePairIbp(id);
		return fact;
	}

	@Override
	public List<TraitsValuePair> getTraitList(Long speciesId) {
		List<TraitTaxonomyDefinition> taxonList = traitTaxonomyDef.findAllTraitList("8,9,10,11,12,13"); // trait id
		List<Long> rootTrait = traitTaxonomyDef.findAllRootTrait();
		Set<Long> traitSet = new HashSet<Long>();
		List<TraitsValuePair> traitValuePair = new ArrayList<TraitsValuePair>();
		try {
			if (speciesId == 829 || speciesId == 830) {
				traitSet.addAll(traitTaxonomyDef.findAllObservationTrait());
			} else {
				List<String> taxonomyList = new ArrayList<String>();
				for (TraitTaxonomyDefinition ttd : taxonList) {
					taxonomyList.add(ttd.getTaxonomyDefifintionId().toString());
				}
				List<String> resultList = taxonomyService.getTaxonomyBySpecies(speciesId.toString(), taxonomyList);

				for (String result : resultList) {
					for (TraitTaxonomyDefinition ttd : taxonList) {
						if (ttd.getTaxonomyDefifintionId().toString().equals(result)) {
							traitSet.add(ttd.getTraitTaxonId());
						}
					}
				}
			}

			for (Long trait : rootTrait) {
				traitSet.add(trait);
			}
			Map<Traits, List<TraitsValue>> traitValueMap = traitTaxonomyDef.findTraitValueList(traitSet);

			for (Traits traits : traitValueMap.keySet()) {
				traitValuePair.add(new TraitsValuePair(traits, traitValueMap.get(traits)));
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return traitValuePair;

	}

	@Override
	public List<FactValuePair> createFacts(HttpServletRequest request, String objectType, Long objectId,
			List<FactValuePair> factsList) {

		CommonProfile profile = AuthUtil.getProfileFromRequest(request);
		String userName = profile.getUsername();
		Long userId = Long.parseLong(profile.getId());
		List<FactValuePair> failedList = new ArrayList<FactValuePair>();
		for (FactValuePair factValue : factsList) {
			if (factValue.getNameId().equals(traistValueDao.findById(factValue.getValueId()).getTraitInstanceId())) {
				Facts fact = new Facts(null, 0L, userName, userId, false, 822L, objectId, null, factValue.getNameId(),
						factValue.getValueId(), null, objectType, null, null, null, null);
				Facts result = factsDao.save(fact);
				if (result == null)
					failedList.add(factValue);
			} else
				factsList.add(factValue);
		}

		return failedList;

	}

	@Override
	public List<Facts> fetchByTaxonId(Long taxonId) {
		List<Facts> result = factsDao.findByTaxonId(taxonId);
		return result;
	}

}
