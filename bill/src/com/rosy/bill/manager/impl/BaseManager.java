package com.rosy.bill.manager.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rosy.bill.Constants;
import com.rosy.bill.dao.Dao;
import com.rosy.bill.dao.Page;
import com.rosy.bill.entity.IdEntity;
import com.rosy.bill.manager.Manager;


/**
 * Base class for Business Services - use this class for utility methods and
 * generic CRUD methods.
 * 
 * <p><a href="BaseManager.java.html"><i>View Source</i></a></p>
 *
 * @author Ben
 */


public class BaseManager<T, PK extends Serializable> implements Manager<T, PK> {
	
	private static Logger logger = LoggerFactory.getLogger(BaseManager.class);
   
	protected Dao<T, PK> dao;
    
    public void setDao(Dao<T, PK> dao) {
        this.dao = dao;
    }
    
    public Dao<T, PK> getDao() {
    	return this.dao;
    } 

	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#getSessionFactory()
	 */
	@Override
	public SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		return dao.getSessionFactory();
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		dao.setSessionFactory(sessionFactory);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#getSession()
	 */
	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return dao.getSession();
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#save(java.lang.Object)
	 */
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		dao.save(entity);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#delete(java.lang.Object)
	 */
	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		dao.delete(entity);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#delete(java.io.Serializable)
	 */
	@Override
	public void delete(PK id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#get(java.io.Serializable)
	 */
	@Override
	public T get(PK id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#get(java.util.Collection)
	 */
	@Override
	public List<T> get(Collection<PK> ids) {
		// TODO Auto-generated method stub
		return dao.get(ids);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#getAll()
	 */
	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#getAll(java.lang.String, boolean)
	 */
	@Override
	public List<T> getAll(String orderByProperty, boolean isAsc) {
		// TODO Auto-generated method stub
		return dao.getAll(orderByProperty, isAsc);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#findBy(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<T> findBy(final String propertyName, final Object value) {
		// TODO Auto-generated method stub
		return dao.findBy(propertyName, value);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#findUniqueBy(java.lang.String, java.lang.Object)
	 */
	@Override
	public T findUniqueBy(final String propertyName, final Object value) {
		// TODO Auto-generated method stub
		return dao.findUniqueBy(propertyName, value);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#find(java.lang.String, java.lang.Object[])
	 */
	@Override
	public <X> List<X> find(final String hql, final Object... values) {
		// TODO Auto-generated method stub
		return dao.find(hql, values);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#find(java.lang.String, java.util.Map)
	 */
	@Override
	public <X> List<X> find(final String hql, final Map<String, ?> values) {
		// TODO Auto-generated method stub
		return dao.find(hql, values);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#findUnique(java.lang.String, java.lang.Object[])
	 */
	@Override
	public <X> X findUnique(String hql, Object... values) {
		// TODO Auto-generated method stub
		return dao.findUnique(hql, values);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#findUnique(java.lang.String, java.util.Map)
	 */
	@Override
	public <X> X findUnique(String hql, Map<String, ?> values) {
		// TODO Auto-generated method stub
		return dao.findUnique(hql, values);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#batchExecute(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int batchExecute(String hql, Object... values) {
		// TODO Auto-generated method stub
		return dao.batchExecute(hql, values);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#batchExecute(java.lang.String, java.util.Map)
	 */
	@Override
	public int batchExecute(String hql, Map<String, ?> values) {
		// TODO Auto-generated method stub
		return dao.batchExecute(hql, values);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#createQuery(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Query createQuery(String queryString, Object... values) {
		// TODO Auto-generated method stub
		return dao.createQuery(queryString, values);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#createQuery(java.lang.String, java.util.Map)
	 */
	@Override
	public Query createQuery(String queryString, Map<String, ?> values) {
		// TODO Auto-generated method stub
		return dao.createQuery(queryString, values);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#find(org.hibernate.criterion.Criterion[])
	 */
	@Override
	public List<T> find(Criterion... criterions) {
		// TODO Auto-generated method stub
		return dao.find(criterions);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#findUnique(org.hibernate.criterion.Criterion[])
	 */
	@Override
	public T findUnique(Criterion... criterions) {
		// TODO Auto-generated method stub
		return dao.findUnique(criterions);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#createCriteria(org.hibernate.criterion.Criterion[])
	 */
	@Override
	public Criteria createCriteria(Criterion... criterions) {
		// TODO Auto-generated method stub
		return dao.createCriteria(criterions);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#initProxyObject(java.lang.Object)
	 */
	@Override
	public void initProxyObject(Object proxy) {
		// TODO Auto-generated method stub
		dao.initProxyObject(proxy);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#flush()
	 */
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		dao.flush();
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#distinct(org.hibernate.Query)
	 */
	@Override
	public Query distinct(Query query) {
		// TODO Auto-generated method stub
		return dao.distinct(query);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#distinct(org.hibernate.Criteria)
	 */
	@Override
	public Criteria distinct(Criteria criteria) {
		// TODO Auto-generated method stub
		return dao.distinct(criteria);
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#getIdName()
	 */
	@Override
	public String getIdName() {
		// TODO Auto-generated method stub
		return dao.getIdName();
	}


	/* (non-Javadoc)
	 * @see com.ruanko.sdb2b.service.Manager#isPropertyUnique(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean isPropertyUnique(String propertyName, Object newValue,
			Object oldValue) {
		// TODO Auto-generated method stub
		return dao.isPropertyUnique(propertyName, newValue, oldValue);
	}

	/* (non-Javadoc)
	 * @see com.rosy.bill.manager.Manager#getAll(com.rosy.bill.dao.Page)
	 */
	@Override
	public Page<T> getAll(Page<T> page) {
		// TODO Auto-generated method stub
		return dao.getAll(page);
	}

	/* (non-Javadoc)
	 * @see com.rosy.bill.manager.Manager#findPageBy(com.rosy.bill.dao.Page, java.lang.Object)
	 */
	@Override
	public Page<T> findPageBy(Page<T> page, T condition) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.rosy.bill.manager.Manager#logicDelete(java.lang.String[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void logicDelete(String... ids) {
		if (null == ids) return;
		for (String id : ids) {
			T t =  dao.get((PK) id);
			if (!(t instanceof IdEntity)) continue; 
			IdEntity obj = (IdEntity) t;
			obj.setDelFlag(Constants.DELFLAG_UN.shortValue());
			dao.save((T) obj );
		}
		
	}
    

   
}
