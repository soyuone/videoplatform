package com.song.videoplatform.common.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;

import com.song.videoplatform.common.page.Page;

/**
 * <p>
 * Title: videoplatform_[工具类]_[Hibernate]
 * </p>
 * <p>
 * Description: [Hibernate工具类实现]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2016年10月13日
 * @author (lastest modification by $Author$)
 * @since 20100901
 * @param <T>
 * @param <ID>
 */
public class HibernateBaseDaoImpl<T, ID extends Serializable> implements HibernateBaseDao<T, ID> {

	protected Logger log = Logger.getLogger(HibernateBaseDaoImpl.class);

	private Class<T> clazz;

	@Autowired
	@Qualifier("sessionFactory")
	protected SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public HibernateBaseDaoImpl() {
		clazz = (Class<T>) ((ParameterizedType) super.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
		}
		if (null == session || false == session.isOpen()) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	// 获得Dao对应的实体类
	public Class<T> getEntityClass() {
		return clazz;
	}

	private boolean filterProperty(String name) {
		try {
			BeanWrapper bw = new BeanWrapperImpl(getEntityClass().newInstance());
			bw.getPropertyValue(name);
		}
		catch (Exception e) {
			log.error("Could not resolve property:" + name, e);
			return false;
		}
		return true;
	}

	@Override
	public Query createQuery(String hql, Object... values) {
		// hql不允许为空，否则报异常: IllegalArgumentException
		Assert.hasText(hql);
		Query query = getSession().createQuery(hql);
		if (null != values) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}

	@Override
	public SQLQuery createSQLQuery(String sql, Object... values) {
		SQLQuery SQLQuery = getSession().createSQLQuery(sql);
		if (null != values) {
			for (int i = 0; i < values.length; i++) {
				SQLQuery.setParameter(i, values[i]);
			}
		}
		return SQLQuery;
	}

	@Override
	public Criteria createCriteria(Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(getEntityClass());
		if (criterions != null && criterions.length > 0) {
			for (Criterion c : criterions) {
				criteria.add(c);
			}
		}
		return criteria;
	}

	@Override
	public T save(T po) {
		// 插入或更新，identifier非必需
		getSession().saveOrUpdate(po);
		return po;
	}

	@Override
	public void delete(T obj) {
		getSession().delete(obj);
	}

	@Override
	public void deleteById(ID id) {
		delete(get(id));
	}

	@Override
	public T update(T po) {
		// merge,update,saveOrUpdate在所有属性无变动时均不会发送sql语句
		// merge,update,saveOrUpdate更新时set会包含所有属性，只有显示指定@DynamicUpdate(true)下才会只更新变更的字段
		getSession().merge(po);
		return po;
	}

	@Override
	public T get(ID id) {
		return get(id, false);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(ID id, boolean lock) {
		T entity;
		if (lock) {
			entity = (T) getSession().get(getEntityClass(), id, LockOptions.UPGRADE);
		}
		else {
			entity = (T) getSession().get(getEntityClass(), id);
		}
		return entity;

	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean duplicatecheck(String idProperty, Object id, Map<String, Object> map) {
		Criteria criteria = createCriteria();
		// map不为空
		if (map != null) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				String field = entry.getKey();
				if (filterProperty(field)) {
					criteria.add(Restrictions.eq(field, entry.getValue()));
				}
				else {
					log.error("Could not resolve property:" + field);
				}
			}
		}
		// idProperty是否排除
		if (null == id) {
			List list = criteria.list();
			if (list != null && list.size() > 0) {
				return true;
			}
		}
		else {
			List list = criteria.add(Restrictions.ne(idProperty, id)).list();
			if (list != null && list.size() > 0) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<T> findByPage(Page<T> page) {
		Criteria criteria = createCriteria();

		if (null == page) {
			page = new Page<T>();
			// 获取总条数
			criteria.setProjection(null);
			int total = ((Long) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
			page.setTotal(total);

			// 清空Projection
			criteria.setProjection(null);
			page.setResult(criteria.list());
		}
		else {
			if (page.getQueryFunction() != null) {
				criteria = page.getQueryFunction().andCriteria(criteria);
			}
			// 清空Projection
			criteria.setProjection(null);
			int total = ((Long) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();

			// 设置查询结果为实体对象，而不是返回数组
			criteria.setProjection(null);
			criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);

			if (page.getStart() > -1) {
				criteria.setFirstResult(page.getStart());// Set the first result to be retrieved.
			}
			if (page.getPagesize() > -1) {
				criteria.setMaxResults(page.getPagesize());// Set a limit upon the number of objects to be retrieved.
			}
			List<T> result = criteria.list();

			page.setTotal(total);
			page.setResult(result);
		}
		return page;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<T> findByPage(Page<T> page, String hql, Object... objects) {
		Query query = createQuery(hql, objects);

		List<T> count = query.list();

		if (null != count && count.size() > 0) {
			// 设置总条数
			page.setTotal(count.size());

			// 设置查询起始位置及一次查询总条数
			if (page.getStart() > -1) {
				query.setFirstResult(page.getStart());
			}
			if (page.getPagesize() > -1) {
				query.setMaxResults(page.getPagesize());
			}
			List<T> result = (List<T>) query.list();
			page.setResult(result);
		}
		else {
			page.setTotal(0);
		}
		return page;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByProperty(String property, Object value) {
		// property不允许为空，否则报异常: IllegalArgumentException
		Assert.hasText(property);
		List<T> result = createCriteria(Restrictions.eq(property, value)).list();
		return result;
	}

	@Override
	public List<?> find(String hql, Object... values) {
		return createQuery(hql, values).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return createCriteria().list();
	}

	@Override
	public Object findUnique(String hql, Object... values) {
		return createQuery(hql, values).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByParamMap(Map<String, Object> paramMap) {
		Criteria criteria = createCriteria();
		if (null != paramMap) {
			for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
				String field = entry.getKey();
				if (filterProperty(field)) {
					Object value = entry.getValue();
					criteria.add(Restrictions.eq(field, value));
				}
				else {
					log.error("Could not resolve property:" + field);
				}
			}
		}
		List<T> result = criteria.list();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findUniqueByProperty(String property, Object value) {
		Assert.hasText(property);
		Assert.isNull(value);
		return (T) createCriteria(Restrictions.eq(property, value)).uniqueResult();
	}

}
