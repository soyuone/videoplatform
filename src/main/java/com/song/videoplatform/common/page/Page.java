package com.song.videoplatform.common.page;

import java.util.List;

/**
 * <p>
 * Title: videoplatform_[工具类]_[Page]
 * </p>
 * <p>
 * Description: [分页查询Page POJO类]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2016年10月24日
 * @author (lastest modification by $Author$)
 * @since 20100901
 * @param <T>
 */
public class Page<T> {

	private int pagesize = -1;// 每页多少条,-1表示不分页

	private int start = -1;// 从第几条开始,-1表示不分页

	private int page = -1;// 起始页,-1表示不分页

	private int total;// 总条数

	private List<T> result;// 查询结果列表

	private QueryFunction queryFunction;// 查询条件

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public QueryFunction getQueryFunction() {
		return queryFunction;
	}

	public void setQueryFunction(QueryFunction queryFunction) {
		this.queryFunction = queryFunction;
	}

}
