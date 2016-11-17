package com.song.videoplatform.common.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * <p>
 * Title: videoplatform_[工具类]_[QueryFunction]
 * </p>
 * <p>
 * Description: [QueryParam查询方法工具类]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2016年10月24日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
public class QueryFunction extends QueryParam {

	protected Logger log = Logger.getLogger(QueryFunction.class);

	private String unEmpty = "The parameter key cannot be empty!";

	/**
	 * <p>
	 * Description:[equal查询条件入参]
	 * </p>
	 * Created by [SO] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 * @param value
	 */
	public void putEq(String key, Object value) {
		if (StringUtils.isNotBlank(key)) {
			if (null == this.eq) {
				this.eq = new HashMap<String, Object>();
			}
			this.eq.put(key, value);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[not equal查询条件入参]
	 * </p>
	 * Created by [SO] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 * @param value
	 */
	public void putNe(String key, Object value) {
		if (StringUtils.isNotBlank(key)) {
			if (null == this.ne) {
				this.ne = new HashMap<String, Object>();
			}
			this.ne.put(key, value);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[greater than查询条件入参]
	 * </p>
	 * Created by [SO] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 * @param value
	 */
	public void putGt(String key, Object value) {
		if (StringUtils.isNotBlank(key)) {
			if (null == this.gt) {
				this.gt = new HashMap<String, Object>();
			}
			this.gt.put(key, value);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[less than查询条件入参]
	 * </p>
	 * Created by [SO] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 * @param value
	 */
	public void putLt(String key, Object value) {
		if (StringUtils.isNotBlank(key)) {
			if (null == this.lt) {
				this.lt = new HashMap<String, Object>();
			}
			this.lt.put(key, value);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[greater than or equal查询条件入参]
	 * </p>
	 * Created by [SO] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 * @param value
	 */
	public void putGe(String key, Object value) {
		if (StringUtils.isNotBlank(key)) {
			if (null == this.ge) {
				this.ge = new HashMap<String, Object>();
			}
			this.ge.put(key, value);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[less than or equal查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 * @param value
	 */
	public void putLe(String key, Object value) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.le) {
				this.le = new HashMap<String, Object>();
			}
			this.le.put(key, value);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[like,Match the pattern anywhere in the string,查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 * @param value
	 */
	public void putLike(String key, Object value) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.like) {
				this.like = new HashMap<String, Object>();
			}
			this.like.put(key, value);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[like,Match the start of the string to the pattern,查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 * @param value
	 */
	public void putSlike(String key, Object value) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.slike) {
				this.slike = new HashMap<String, Object>();
			}
			this.slike.put(key, value);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[like,Match the end of the string to the pattern,查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 * @param value
	 */
	public void putElike(String key, Object value) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.elike) {
				this.elike = new HashMap<String, Object>();
			}
			this.elike.put(key, value);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[like,case-insensitive,Match the pattern anywhere in the string,查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 * @param value
	 */
	public void putIlike(String key, Object value) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.ilike) {
				this.ilike = new HashMap<String, Object>();
			}
			this.ilike.put(key, value);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[like,case-insensitive,Match the start of the string to the pattern,查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 * @param value
	 */
	public void putSilike(String key, Object value) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.silike) {
				this.silike = new HashMap<String, Object>();
			}
			this.silike.put(key, value);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[like,case-insensitive,Match the end of the string to the pattern,查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 * @param value
	 */
	public void putEilike(String key, Object value) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.eilike) {
				this.eilike = new HashMap<String, Object>();
			}
			this.eilike.put(key, value);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[between查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 * @param value
	 */
	public void putBetween(String key, Object value[]) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.between) {
				this.between = new HashMap<String, Object[]>();
			}
			this.between.put(key, value);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[in查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 * @param value
	 */
	public void putIn(String key, Object value[]) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.in) {
				this.in = new HashMap<String, Object[]>();
			}
			this.in.put(key, value);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[not in查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 * @param value
	 */
	public void putNotIn(String key, Object value[]) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.notIn) {
				this.notIn = new HashMap<String, Object[]>();
			}
			this.notIn.put(key, value);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[is null查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 */
	public void putIsNull(String key) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.isNull) {
				this.isNull = new ArrayList<String>();
			}
			this.isNull.add(key);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[is not null查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 */
	public void putIsNotNull(String key) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.isNotNull) {
				this.isNotNull = new ArrayList<String>();
			}
			this.isNotNull.add(key);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[获取最大值查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 */
	public void putMax(String key) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.max) {
				this.max = new ArrayList<String>();
			}
			this.max.add(key);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[获取最小值查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 */
	public void putMin(String key) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.min) {
				this.min = new ArrayList<String>();
			}
			this.min.add(key);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[获取平均值查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 */
	public void putAvg(String key) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.avg) {
				this.avg = new ArrayList<String>();
			}
			this.avg.add(key);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[获取合计值查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 */
	public void putSum(String key) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.sum) {
				this.sum = new ArrayList<String>();
			}
			this.sum.add(key);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[获取个数查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 */
	public void putCount(String key) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.count) {
				this.count = new ArrayList<String>();
			}
			this.count.add(key);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[获取去重后的个数查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 */
	public void putCountD(String key) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.countD) {
				this.countD = new ArrayList<String>();
			}
			this.countD.add(key);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[分组统计查询条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 */
	public void putGroup(String key) {
		if (StringUtils.isNotBlank(key)) {
			if (null != this.group) {
				this.group = new ArrayList<String>();
			}
			this.group.add(key);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[排序条件入参]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param key
	 * @param value
	 */
	public void putOrder(String key, String value) {
		if (StringUtils.isNotBlank(key)) {
			if (null == this.order) {
				this.order = new HashMap<String, String>();
			}
			this.order.put(key, value);
		}
		else {
			log.error(unEmpty);
		}
	}

	/**
	 * <p>
	 * Description:[设置查询条件Criterion]
	 * </p>
	 * Created by [SO] [2016年10月23日] Midified by [修改人] [修改时间]
	 *
	 * @return
	 */
	private List<Criterion> setCriterionList() {
		List<Criterion> CriterionList = new ArrayList<Criterion>();

		// equal
		if (null != eq) {
			for (Map.Entry<String, Object> entry : eq.entrySet()) {
				String field = entry.getKey();
				Object value = entry.getValue();
				Criterion c = Restrictions.eq(field, value);
				CriterionList.add(c);
			}
		}

		// not equal
		if (null != ne) {
			for (Map.Entry<String, Object> entry : ne.entrySet()) {
				String field = entry.getKey();
				Object value = entry.getValue();
				Criterion c = Restrictions.ne(field, value);
				CriterionList.add(c);
			}
		}

		// greater than
		if (null != gt) {
			for (Map.Entry<String, Object> entry : gt.entrySet()) {
				String field = entry.getKey();
				Object value = entry.getValue();
				Criterion c = Restrictions.gt(field, value);
				CriterionList.add(c);
			}
		}

		// less than
		if (null != lt) {
			for (Map.Entry<String, Object> entry : lt.entrySet()) {
				String field = entry.getKey();
				Object value = entry.getValue();
				Criterion c = Restrictions.lt(field, value);
				CriterionList.add(c);
			}
		}

		// greater than or equal
		if (null != ge) {
			for (Map.Entry<String, Object> entry : ge.entrySet()) {
				String field = entry.getKey();
				Object value = entry.getValue();
				Criterion c = Restrictions.ge(field, value);
				CriterionList.add(c);
			}
		}

		// less than or equal
		if (null != le) {
			for (Map.Entry<String, Object> entry : le.entrySet()) {
				String field = entry.getKey();
				Object value = entry.getValue();
				Criterion c = Restrictions.le(field, value);
				CriterionList.add(c);
			}
		}

		// like,Match the pattern anywhere in the string
		if (null != like) {
			for (Map.Entry<String, Object> entry : like.entrySet()) {
				String field = entry.getKey();
				String value = entry.getValue().toString();
				Criterion c = Restrictions.like(field, value, MatchMode.ANYWHERE);
				CriterionList.add(c);
			}
		}

		// like,Match the start of the string to the pattern
		if (null != slike) {
			for (Map.Entry<String, Object> entry : slike.entrySet()) {
				String field = entry.getKey();
				String value = entry.getValue().toString();
				Criterion c = Restrictions.like(field, value, MatchMode.START);
				CriterionList.add(c);
			}
		}

		// like,Match the end of the string to the pattern
		if (null != elike) {
			for (Map.Entry<String, Object> entry : elike.entrySet()) {
				String field = entry.getKey();
				String value = entry.getValue().toString();
				Criterion c = Restrictions.like(field, value, MatchMode.END);
				CriterionList.add(c);
			}
		}

		// like,case-insensitive,Match the pattern anywhere in the string
		if (null != ilike) {
			for (Map.Entry<String, Object> entry : ilike.entrySet()) {
				String field = entry.getKey();
				String value = entry.getValue().toString();
				Criterion c = Restrictions.ilike(field, value, MatchMode.ANYWHERE);
				CriterionList.add(c);
			}
		}

		// like,case-insensitive,Match the start of the string to the pattern
		if (null != silike) {
			for (Map.Entry<String, Object> entry : silike.entrySet()) {
				String field = entry.getKey();
				String value = entry.getValue().toString();
				Criterion c = Restrictions.ilike(field, value, MatchMode.START);
				CriterionList.add(c);
			}
		}

		// like,case-insensitive,Match the end of the string to the pattern
		if (null != eilike) {
			for (Map.Entry<String, Object> entry : eilike.entrySet()) {
				String field = entry.getKey();
				String value = entry.getValue().toString();
				Criterion c = Restrictions.ilike(field, value, MatchMode.END);
				CriterionList.add(c);
			}
		}

		// between
		if (null != between) {
			for (Map.Entry<String, Object[]> entry : between.entrySet()) {
				String field = entry.getKey();
				Object[] values = entry.getValue();
				Criterion c = Restrictions.between(field, values[0], values[1]);
				CriterionList.add(c);
			}
		}

		// in
		if (null != in) {
			for (Map.Entry<String, Object[]> entry : in.entrySet()) {
				String field = entry.getKey();
				Object[] values = entry.getValue();
				Criterion c = Restrictions.in(field, values);
				CriterionList.add(c);
			}
		}

		// not in
		if (null != notIn) {
			for (Map.Entry<String, Object[]> entry : notIn.entrySet()) {
				String field = entry.getKey();
				Object[] values = entry.getValue();
				Criterion c = Restrictions.not(Restrictions.in(field, values));
				CriterionList.add(c);
			}
		}

		// is null
		if (null != isNull && isNull.size() > 0) {
			for (int i = 0; i < isNull.size(); i++) {
				Criterion c = Restrictions.isNull(isNull.get(i));
				CriterionList.add(c);
			}
		}

		// is not null
		if (null != isNotNull && isNotNull.size() > 0) {
			for (int i = 0; i < isNotNull.size(); i++) {
				Criterion c = Restrictions.isNotNull(isNotNull.get(i));
				CriterionList.add(c);
			}
		}

		return CriterionList;
	}

	/**
	 * <p>
	 * Description:[将Criterions设置为and查询]
	 * </p>
	 * Created by [SO] [2016年10月23日] Midified by [修改人] [修改时间]
	 *
	 * @param criteria
	 * @return
	 */
	public Criteria andCriteria(Criteria criteria) {
		// 设置查询条件Criterion
		List<Criterion> CriterionList = setCriterionList();

		if (null != CriterionList && CriterionList.size() > 0) {
			for (int i = 0; i < CriterionList.size(); i++) {
				criteria.add(CriterionList.get(i));
			}
		}

		// order
		if (null != order) {
			for (Map.Entry<String, String> entry : order.entrySet()) {
				String field = entry.getKey();
				String value = entry.getValue();
				if ("desc".equalsIgnoreCase(value)) {
					criteria.addOrder(Order.desc(field));
				}
				else {
					criteria.addOrder(Order.asc(field));
				}
			}
		}

		return criteria;
	}

	/**
	 * <p>
	 * Description:[将Criterions设置为or查询]
	 * </p>
	 * Created by [SO] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param criteria
	 * @return
	 */
	public Criteria orCriteria(Criteria criteria) {
		// 设置查询条件Criterion
		List<Criterion> CriterionList = setCriterionList();

		if (null != CriterionList && CriterionList.size() > 0) {
			if (CriterionList.size() < 2) {
				criteria.add(Restrictions.or(CriterionList.get(0)));
			}
			else {
				LogicalExpression logicalExpression = Restrictions.or(CriterionList.get(0), CriterionList.get(1));
				for (int i = 2; i < CriterionList.size(); i++) {
					logicalExpression = Restrictions.or(logicalExpression, CriterionList.get(i));
				}
				criteria.add(logicalExpression);
			}
		}

		// order
		if (null != order) {
			for (Map.Entry<String, String> entry : order.entrySet()) {
				String field = entry.getKey();
				String value = entry.getValue();
				if ("desc".equalsIgnoreCase(value)) {
					criteria.addOrder(Order.desc(field));
				}
				else {
					criteria.addOrder(Order.asc(field));
				}
			}
		}

		return criteria;
	}

	/**
	 * <p>
	 * Description:[投影运算]
	 * </p>
	 * Created by [SO] [2016年10月23日] Midified by [修改人] [修改时间]
	 *
	 * @return
	 */
	public ProjectionList setProjections() {
		ProjectionList proList = Projections.projectionList();

		// maximum value projection
		if (null != max && max.size() > 0) {
			for (int i = 0; i < max.size(); i++) {
				// The property for which to find the max
				proList.add(Projections.max(max.get(i)));
			}
		}

		// minimum value projection
		if (null != min && min.size() > 0) {
			for (int i = 0; i < min.size(); i++) {
				// The property for which to find the min
				proList.add(Projections.min(min.get(i)));
			}
		}

		// average value projection
		if (null != avg && avg.size() > 0) {
			for (int i = 0; i < avg.size(); i++) {
				// The property over which to find the average
				proList.add(Projections.avg(avg.get(i)));
			}
		}

		// value sum projection
		if (null != sum && sum.size() > 0) {
			for (int i = 0; i < sum.size(); i++) {
				// The property over which to sum
				proList.add(Projections.sum(sum.get(i)));
			}
		}

		// value count projection
		if (null != count && count.size() > 0) {
			for (int i = 0; i < count.size(); i++) {
				// The name of the property to count over
				proList.add(Projections.count(count.get(i)));
			}
		}

		// A distinct property value count projection
		if (null != countD && countD.size() > 0) {
			for (int i = 0; i < countD.size(); i++) {
				// The name of the property to count over
				proList.add(Projections.countDistinct(countD.get(i)));
			}
		}

		// A grouping property value projection
		if (null != group && group.size() > 0) {
			for (int i = 0; i < group.size(); i++) {
				// The name of the property to group
				proList.add(Projections.groupProperty(group.get(i)));
			}
		}

		return proList;
	}
}
