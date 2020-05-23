/**
 * 
 */
package com.strandls.traits.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import com.strandls.traits.pojo.TraitsValue;
import com.strandls.traits.util.AbstractDAO;

/**
 * @author Abhishek Rudra
 *
 */
public class TraitsValueDao extends AbstractDAO<TraitsValue, Long> {

	private final Logger logger = LoggerFactory.getLogger(TraitsValueDao.class);

	/**
	 * @param sessionFactory
	 */
	@Inject
	protected TraitsValueDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public TraitsValue findById(Long id) {
		Session session = sessionFactory.openSession();
		TraitsValue entity = null;
		try {
			entity = session.get(TraitsValue.class, id);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<TraitsValue> findTraitsValue(Long traitId) {

		String qry = "from TraitsValue where traitInstanceId = :traitId and isDeleted = false";
		Session session = sessionFactory.openSession();
		List<TraitsValue> entity = null;
		try {
			Query<TraitsValue> query = session.createQuery(qry);
			query.setParameter("traitId", traitId);

			entity = query.getResultList();

		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return entity;
	}

}
