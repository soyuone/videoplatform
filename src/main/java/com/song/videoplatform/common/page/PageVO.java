package com.song.videoplatform.common.page;

import java.util.List;

/**
 * <p>
 * Title: videoplatform_[工具类]_[PageVO]
 * </p>
 * <p>
 * Description: [分页查询PageVO POJO类]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2016年10月24日
 * @author (lastest modification by $Author$)
 * @since 20100901
 * @param <T>
 */
public class PageVO<T> {

	private int total; // 记录总数

	private int page; // 当前页数

	private int row; // 当前每页条数

	private int totalPages; // 总页数

	private List<T> data; // 结果列表

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
