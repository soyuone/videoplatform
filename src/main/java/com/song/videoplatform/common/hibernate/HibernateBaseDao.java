package com.song.videoplatform.common.hibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Criterion;

import com.song.videoplatform.common.page.Page;

/**
 * <p>
 * Title: videoplatform_[工具类]_[Hibernate]
 * </p>
 * <p>
 * Description: [Hibernate工具类]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2016年10月13日
 * @author (lastest modification by $Author$)
 * @since 20100901
 * @param <T>
 * @param <ID>
 */
public interface HibernateBaseDao<T, ID extends Serializable> {

	/**
	 * <p>
	 * Description:[Hibernate HQL查询]
	 * </p>
	 * Created by [SOYU] [2016年10月25日] Midified by [修改人] [修改时间]
	 *
	 * @param hql
	 * @param values
	 * @return
	 */
	public Query createQuery(String hql, Object... values);

	/**
	 * <p>
	 * Description:[Hibernate SQL查询]
	 * </p>
	 * Created by [SOYU] [2016年10月25日] Midified by [修改人] [修改时间]
	 *
	 * @param sql
	 * @param values
	 * @return
	 */
	public SQLQuery createSQLQuery(String sql, Object... values);

	/**
	 * <p>
	 * Description:[Hibernate条件查询]
	 * </p>
	 * Created by [SOYU] [2016年10月21日] Midified by [修改人] [修改时间]
	 *
	 * @param criterions
	 * @return
	 */
	public Criteria createCriteria(Criterion... criterions);

	/**
	 * <p>
	 * Description:[保存对象]
	 * </p>
	 * Created by [SOYU] [2016年10月13日] Midified by [修改人] [修改时间]
	 *
	 * @param po
	 * @return
	 */
	public T save(T po);

	/**
	 * <p>
	 * Description:[删除对象]
	 * </p>
	 * Created by [SOYU] [2016年10月25日] Midified by [修改人] [修改时间]
	 *
	 * @param obj
	 */
	public void delete(T obj);

	/**
	 * <p>
	 * Description:[通过identifier删除对象]
	 * </p>
	 * Created by [SOYU] [2016年10月25日] Midified by [修改人] [修改时间]
	 *
	 * @param id
	 */
	public void deleteById(ID id);

	/**
	 * <p>
	 * Description:[修改对象]
	 * </p>
	 * Created by [SOYU] [2016年10月25日] Midified by [修改人] [修改时间]
	 *
	 * @param po
	 * @return
	 */
	public T update(T po);

	/**
	 * <p>
	 * Description:[根据identifier查找对象]
	 * </p>
	 * Created by [SOYU] [2016年10月25日] Midified by [修改人] [修改时间]
	 *
	 * @param id
	 * @return
	 */
	public T get(ID id);

	/**
	 * <p>
	 * Description:[根据identifier查找对象]
	 * </p>
	 * Created by [SOYU] [2016年10月25日] Midified by [修改人] [修改时间]
	 *
	 * @param id
	 * @param lock
	 * @return
	 */
	public T get(ID id, boolean lock);

	/**
	 * <p>
	 * Description:[重名校验]
	 * </p>
	 * Created by [SOYU] [2016年10月21日] Midified by [修改人] [修改时间]
	 *
	 * @param idProperty
	 * @param id
	 * @param map
	 * @return
	 */
	public boolean duplicatecheck(String idProperty, Object id, Map<String, Object> map);

	/**
	 * <p>
	 * Description:[分页查询]
	 * </p>
	 * Created by [SO] [2016年10月23日] Midified by [修改人] [修改时间]
	 *
	 * @param page
	 * @return
	 */
	public Page<T> findByPage(Page<T> page);

	/**
	 * <p>
	 * Description:[分页查询]
	 * </p>
	 * Created by [SOYU] [2016年10月25日] Midified by [修改人] [修改时间]
	 *
	 * @param page
	 * @param hql
	 * @param objects
	 * @return
	 */
	public Page<T> findByPage(Page<T> page, String hql, Object... objects);

	/**
	 * <p>
	 * Description:[按属性查找对象列表]
	 * </p>
	 * Created by [SOYU] [2016年10月21日] Midified by [修改人] [修改时间]
	 *
	 * @param property
	 * @param value
	 * @return
	 */
	public List<T> findByProperty(String property, Object value);

	/**
	 * <p>
	 * Description:[Hibernate HQL查询对象列表]
	 * </p>
	 * Created by [SOYU] [2016年10月25日] Midified by [修改人] [修改时间]
	 *
	 * @param hql
	 * @param values
	 */
	public List<?> find(String hql, Object... values);

	/**
	 * <p>
	 * Description:[查询所有对象]
	 * </p>
	 * Created by [SOYU] [2016年10月25日] Midified by [修改人] [修改时间]
	 *
	 * @return
	 */
	public List<T> findAll();

	/**
	 * <p>
	 * Description:[Hibernate HQL查询唯一对象]
	 * </p>
	 * Created by [SOYU] [2016年10月25日] Midified by [修改人] [修改时间]
	 *
	 * @param hql
	 * @param values
	 * @return
	 */
	public Object findUnique(String hql, Object... values);

	/**
	 * <p>
	 * Description:[根据查询条件过滤查询对象列表]
	 * </p>
	 * Created by [SOYU] [2016年10月25日] Midified by [修改人] [修改时间]
	 *
	 * @param paramMap
	 * @return
	 */
	public List<T> findByParamMap(Map<String, Object> paramMap);

	/**
	 * <p>
	 * Description:[按属性查找唯一对象]
	 * </p>
	 * Created by [SOYU] [2016年10月25日] Midified by [修改人] [修改时间]
	 *
	 * @param property
	 * @param value
	 * @return
	 */
	public T findUniqueByProperty(String property, Object value);

	/**
	 * <p>
	 * Description:[ehcache缓存统计功能]
	 * </p>
	 * Created by [SOYU] [2017年1月17日] Midified by [修改人] [修改时间]
	 */
	public void findEhcache(String regionName);

}
