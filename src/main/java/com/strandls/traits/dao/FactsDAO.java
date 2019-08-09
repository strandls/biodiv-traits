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
		String qry = "select t.name , v.value from Facts f " + "left join Traits t on f.trait_instance_id = t.id "
				+ "left join TraitsValue v on f.trait_value_id = v.id " + "where f.id = :id";
		Session session = sessionFactory.openSession();
		FactValuePair fact = null;
		try {
			Query<Object[]> query = session.createQuery(qry);
			query.setParameter("id", factId);

			Object[] result = query.getSingleResult();
			fact = new FactValuePair(result[0].toString(), result[1].toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}

		return fact;
	}

	@SuppressWarnings("unchecked")
	public List<FactValuePair> getTraitValuePair(Long id) {

		String qry = "select t.name , v.value from Facts f " + "left join Traits t on f.trait_instance_id = t.id "
				+ "left join TraitsValue v on f.trait_value_id = v.id " + "where f.object_id = :id";
		Session session = sessionFactory.openSession();
		List<FactValuePair> fact = null;

		try {
			Query<Object[]> query = session.createQuery(qry);
			query.setParameter("id", id);

			List<Object[]> list = new ArrayList<Object[]>();
			list = query.getResultList();
			fact = new ArrayList<FactValuePair>();
			for (Object[] f : list) {
				FactValuePair fvp = new FactValuePair(f[0].toString(), f[1].toString());
				fact.add(fvp);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return fact;
	}

}
