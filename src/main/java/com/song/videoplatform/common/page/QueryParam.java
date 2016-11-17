package com.song.videoplatform.common.page;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title: videoplatform_[工具类]_[QueryParam POJO]
 * </p>
 * <p>
 * Description: [QueryParam查询参数POJO]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2016年10月23日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
public class QueryParam {

	protected Map<String, Object> eq; // equal查询条件 <属性名,值>

	protected Map<String, Object> ne; // not equal查询条件 <属性名,值>

	protected Map<String, Object> gt; // greater than查询条件 <属性名,值>

	protected Map<String, Object> lt; // less than查询条件 <属性名,值>

	protected Map<String, Object> ge; // greater than or equal查询条件 <属性名,值>

	protected Map<String, Object> le; // less than or equal查询条件 <属性名,值>

	protected Map<String, Object> like; // like,Match the pattern anywhere in the string

	protected Map<String, Object> slike; // like,Match the start of the string to the pattern

	protected Map<String, Object> elike; // like,Match the end of the string to the pattern

	protected Map<String, Object> ilike; // like,case-insensitive,Match the pattern anywhere in the string

	protected Map<String, Object> silike; // like,case-insensitive,Match the start of the string to the pattern

	protected Map<String, Object> eilike; // like,case-insensitive,Match the end of the string to the pattern

	protected Map<String, Object[]> between; // between查询条件 <属性名,[小值，大值]>

	protected Map<String, Object[]> in; // in查询条件 <属性名,in值[...]>

	protected Map<String, Object[]> notIn; // not in查询条件 <属性名,not in值[...]>

	protected List<String> isNull; // is null查询条件 [属性名...]

	protected List<String> isNotNull; // is not null查询条件 [属性名,...]

	protected List<String> max; // 获取最大值[属性名...]

	protected List<String> min; // 获取最小值[属性名...]

	protected List<String> avg; // 获取平均值[属性名...]

	protected List<String> sum; // 获取合计值[属性名...]

	protected List<String> count; // 获取个数[属性名...]

	protected List<String> countD; // 获取去重后的个数[属性名...]

	protected List<String> group; // 分组统计[属性名...]

	protected Map<String, String> order; // 排序条件 <属性名,排序方式>

	public Map<String, Object> getEq() {
		return eq;
	}

	public void setEq(Map<String, Object> eq) {
		this.eq = eq;
	}

	public Map<String, Object> getNe() {
		return ne;
	}

	public void setNe(Map<String, Object> ne) {
		this.ne = ne;
	}

	public Map<String, Object> getGt() {
		return gt;
	}

	public void setGt(Map<String, Object> gt) {
		this.gt = gt;
	}

	public Map<String, Object> getLt() {
		return lt;
	}

	public void setLt(Map<String, Object> lt) {
		this.lt = lt;
	}

	public Map<String, Object> getGe() {
		return ge;
	}

	public void setGe(Map<String, Object> ge) {
		this.ge = ge;
	}

	public Map<String, Object> getLe() {
		return le;
	}

	public void setLe(Map<String, Object> le) {
		this.le = le;
	}

	public Map<String, Object> getLike() {
		return like;
	}

	public void setLike(Map<String, Object> like) {
		this.like = like;
	}

	public Map<String, Object> getSlike() {
		return slike;
	}

	public void setSlike(Map<String, Object> slike) {
		this.slike = slike;
	}

	public Map<String, Object> getElike() {
		return elike;
	}

	public void setElike(Map<String, Object> elike) {
		this.elike = elike;
	}

	public Map<String, Object> getIlike() {
		return ilike;
	}

	public void setIlike(Map<String, Object> ilike) {
		this.ilike = ilike;
	}

	public Map<String, Object> getSilike() {
		return silike;
	}

	public void setSilike(Map<String, Object> silike) {
		this.silike = silike;
	}

	public Map<String, Object> getEilike() {
		return eilike;
	}

	public void setEilike(Map<String, Object> eilike) {
		this.eilike = eilike;
	}

	public Map<String, Object[]> getBetween() {
		return between;
	}

	public void setBetween(Map<String, Object[]> between) {
		this.between = between;
	}

	public Map<String, Object[]> getIn() {
		return in;
	}

	public void setIn(Map<String, Object[]> in) {
		this.in = in;
	}

	public Map<String, Object[]> getNotIn() {
		return notIn;
	}

	public void setNotIn(Map<String, Object[]> notIn) {
		this.notIn = notIn;
	}

	public List<String> getIsNull() {
		return isNull;
	}

	public void setIsNull(List<String> isNull) {
		this.isNull = isNull;
	}

	public List<String> getIsNotNull() {
		return isNotNull;
	}

	public void setIsNotNull(List<String> isNotNull) {
		this.isNotNull = isNotNull;
	}

	public List<String> getMax() {
		return max;
	}

	public void setMax(List<String> max) {
		this.max = max;
	}

	public List<String> getMin() {
		return min;
	}

	public void setMin(List<String> min) {
		this.min = min;
	}

	public List<String> getAvg() {
		return avg;
	}

	public void setAvg(List<String> avg) {
		this.avg = avg;
	}

	public List<String> getSum() {
		return sum;
	}

	public void setSum(List<String> sum) {
		this.sum = sum;
	}

	public List<String> getCount() {
		return count;
	}

	public void setCount(List<String> count) {
		this.count = count;
	}

	public List<String> getCountD() {
		return countD;
	}

	public void setCountD(List<String> countD) {
		this.countD = countD;
	}

	public List<String> getGroup() {
		return group;
	}

	public void setGroup(List<String> group) {
		this.group = group;
	}

	public Map<String, String> getOrder() {
		return order;
	}

	public void setOrder(Map<String, String> order) {
		this.order = order;
	}

}
