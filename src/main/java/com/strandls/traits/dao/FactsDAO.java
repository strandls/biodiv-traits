/**
 * 
 */
package com.strandls.traits.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.strandls.traits.pojo.FactValuePair;
import com.strandls.traits.pojo.Facts;
import com.strandls.traits.util.AbstractDAO;

/**
 * @author Abhishek Rudra
 *
 */
public class FactsDAO extends AbstractDAO<Facts, Long> {

	private static final Logger logger = LoggerFactory.getLogger(FactsDAO.class);

	/**
	 * @param sessionFactory
	 */
	@Inject
	protected FactsDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public Facts findById(Long id) {
		Session session = sessionFactory.openSession();
		Facts entity = null;
		try {
			entity = session.get(Facts.class, id);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	public FactValuePair getTraitvaluePairIbp(Long factId) {
		String qry = "select t.id, t.name , v.id, v.value , t.traitTypes, t.isParticipatory from Facts f "
				+ "left join Traits t on f.traitInstanceId = t.id "
				+ "left join TraitsValue v on f.traitValueId = v.id " + "where f.id = :id";
		Session session = sessionFactory.openSession();
		FactValuePair fact = null;
		try {
			Query<Object[]> query = session.createQuery(qry);
			query.setParameter("id", factId);

			Object[] result = query.getSingleResult();
			fact = new FactValuePair(Long.parseLong(result[0].toString()), result[1].toString(),
					Long.parseLong(result[2].toString()), result[3].toString(), result[4].toString(),
					Boolean.parseBoolean(result[5].toString()));
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}

		return fact;
	}

	@SuppressWarnings("unchecked")
	public List<FactValuePair> getTraitValuePair(String objectType, Long objectId) {

		String qry = "select t.id, t.name , v.id, v.value, t.traitTypes, t.isParticipatory from Facts f "
				+ "left join Traits t on f.traitInstanceId = t.id "
				+ "left join TraitsValue v on f.traitValueId = v.id "
				+ "where f.objectId = :id and f.objectType = :type";
		Session session = sessionFactory.openSession();
		List<FactValuePair> fact = null;

		try {
			Query<Object[]> query = session.createQuery(qry);
			query.setParameter("id", objectId);
			query.setParameter("type", objectType);

			List<Object[]> resultList = new ArrayList<Object[]>();
			resultList = query.getResultList();
			fact = new ArrayList<FactValuePair>();
			for (Object[] result : resultList) {
				FactValuePair fvp = new FactValuePair(Long.parseLong(result[0].toString()), result[1].toString(),
						Long.parseLong(result[2].toString()), result[3].toString(), result[4].toString(),
						Boolean.parseBoolean(result[5].toString()));
				fact.add(fvp);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return fact;
	}

	@SuppressWarnings("unchecked")
	public List<Facts> findByTaxonId(Long taxonId) {
		String qry = "from Facts f where f.pageTaxonId = :taxonId";
		Session session = sessionFactory.openSession();
		List<Facts> resultList = null;
		try {
			Query<Facts> query = session.createQuery(qry);
			query.setParameter("taxonId", taxonId);
			resultList = query.getResultList();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return resultList;
	}

	@SuppressWarnings("unchecked")
	public List<Facts> fetchByTraitId(String objectType, Long objectId, Long traitId) {
		String qry = "from Facts where objectId = :id and objectType = :type and traitInstanceId = :traitId and isDeleted = false";
		Session session = sessionFactory.openSession();
		List<Facts> entity = null;
		try {
			Query<Facts> query = session.createQuery(qry);
			query.setParameter("id", objectId);
			query.setParameter("type", objectType);
			query.setParameter("traitId", traitId);
			entity = query.getResultList();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<Facts> fetchByValueList(String valueList) {
		String qry = "from Facts where traitValueId in (" + valueList + ")";
		Session session = sessionFactory.openSession();
		List<Facts> result = null;
		try {
			Query<Facts> query = session.createQuery(qry);
			result = query.getResultList();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}
}
