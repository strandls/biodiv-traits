/**
 * 
 */
package com.strandls.traits.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import com.strandls.traits.pojo.TraitTaxonomyDefinition;
import com.strandls.traits.pojo.Traits;
import com.strandls.traits.pojo.TraitsValue;
import com.strandls.traits.util.AbstractDAO;

/**
 * @author Abhishek Rudra
 *
 */
public class TraitTaxonomyDefinitionDao extends AbstractDAO<TraitTaxonomyDefinition, Long> {

	private final Logger logger = LoggerFactory.getLogger(TraitTaxonomyDefinitionDao.class);

	/**
	 * @param sessionFactory
	 */
	@Inject
	protected TraitTaxonomyDefinitionDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public TraitTaxonomyDefinition findById(Long id) {
		Session session = sessionFactory.openSession();
		TraitTaxonomyDefinition entity = null;
		try {
			entity = session.get(TraitTaxonomyDefinition.class, id);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<TraitTaxonomyDefinition> findAllTraitList(String traitList) {
		String qry = "from TraitTaxonomyDefinition where traitTaxonId in (" + traitList + ")";
		List<TraitTaxonomyDefinition> result = new ArrayList<TraitTaxonomyDefinition>();
		Session session = sessionFactory.openSession();
		try {
			Query<TraitTaxonomyDefinition> query = session.createQuery(qry);
			result = query.getResultList();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Long> findAllRootTrait() {
		String qry = "select t.id from Traits t left join TraitTaxonomyDefinition ttd on ttd.traitTaxonId = t.id where ttd.taxonomyDefifintionId is NULL";
		Session session = sessionFactory.openSession();
		List<Long> resultList = new ArrayList<Long>();

		try {
			Query<Long> query = session.createQuery(qry);
			resultList = query.getResultList();

		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}

		return resultList;
	}

	@SuppressWarnings("unchecked")
	public Map<Traits, List<TraitsValue>> findTraitValueList(Set<Long> traitSet) {

		String qry = "from Traits t left join TraitsValue tv on t.id = tv.traitInstanceId where t.id in (:traitSet) "
				+ "and t.showInObservation = TRUE";
		Session session = sessionFactory.openSession();
		List<Object[]> resultList = new ArrayList<Object[]>();
		Map<Traits, List<TraitsValue>> traitValueMap = new HashMap<Traits, List<TraitsValue>>();
		try {
			Query<Object[]> query = session.createQuery(qry);
			query.setParameter("traitSet", traitSet);
			resultList = query.getResultList();
			for (Object[] result : resultList) {
				Traits traits = (Traits) result[0];
				TraitsValue traitsValue = (TraitsValue) result[1];
				List<TraitsValue> traitsValuesList = new ArrayList<TraitsValue>();
				if (!traitValueMap.containsKey(traits)) {
					traitsValuesList.add(traitsValue);
				} else {
					traitsValuesList = traitValueMap.get(traits);
					traitsValuesList.add(traitsValue);
				}
				traitValueMap.put(traits, traitsValuesList);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return traitValueMap;
	}

}
