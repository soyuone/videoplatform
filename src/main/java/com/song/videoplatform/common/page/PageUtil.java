package com.song.videoplatform.common.page;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class PageUtil {

	/**
	 * <p>
	 * Description:[分页查询，分页信息设置（不排序）]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param page 分页对象
	 * @param start 从第几条开始，默认从第0条开始
	 * @param row 每页多少条，默认从每页10条
	 */
	@SuppressWarnings("rawtypes")
	public static void pageSplit(Page page, String start, String row) {
		// 从第几条开始
		if (StringUtils.isNotBlank(start)) {
			page.setStart(Integer.parseInt(start));
		}
		else {
			page.setStart(0);
		}
		// 每页多少条
		if (StringUtils.isNotBlank(row)) {
			page.setPagesize(Integer.parseInt(row));
		}
		else {
			page.setPagesize(10);
		}
	}

	/**
	 * <p>
	 * Description:[分页查询，分页信息设置（排序）]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param page 分页对象
	 * @param start 从第几条开始，默认从第0条开始
	 * @param row 每页多少条，默认从每页10条
	 * @param sortorder 排序规则，升序还是降序
	 * @param sortfield 指定的排序列
	 * @param defaultField 默认的排序列
	 */
	@SuppressWarnings("rawtypes")
	public static void pageSplit(Page page, String start, String row, String sortorder, String sortfield,
			String defaultField) {
		// 从第几条开始
		if (StringUtils.isNotBlank(start)) {
			page.setStart(Integer.parseInt(start));
		}
		else {
			page.setStart(0);
		}
		// 每页多少条
		if (StringUtils.isNotBlank(row)) {
			page.setPagesize(Integer.parseInt(row));
		}
		else {
			page.setPagesize(10);
		}

		// 排序设置
		Map<String, String> order = new HashMap<String, String>();
		QueryFunction queryFunction = new QueryFunction();
		if (page != null && page.getQueryFunction() != null) {
			queryFunction = page.getQueryFunction();
			if (page.getQueryFunction().getOrder() != null) {
				order = page.getQueryFunction().getOrder();
			}
		}

		if (StringUtils.isNotBlank(sortfield)) {
			if (StringUtils.isNotBlank(sortorder)) {
				order.put(sortfield, sortorder);
			}
			else {
				order.put(sortfield, "desc");
			}
		}
		else if (StringUtils.isNotBlank(defaultField)) {
			if (StringUtils.isNotBlank(sortorder)) {
				order.put(defaultField, sortorder);
			}
			else {
				order.put(defaultField, "desc");
			}
		}
		queryFunction.setOrder(order);
		page.setQueryFunction(queryFunction);

	}

	/**
	 * <p>
	 * Description:[将page对象的分页信息设置到PageVO中]
	 * </p>
	 * Created by [SOYU] [2016年10月24日] Midified by [修改人] [修改时间]
	 *
	 * @param page
	 * @param pageVO
	 */
	@SuppressWarnings("rawtypes")
	public static void pageVOSplit(Page page, PageVO pageVO) {
		if (page.getPagesize() > 0) {
			pageVO.setPage(page.getStart() / page.getPagesize() + 1);
			if (page.getTotal() % page.getPagesize() == 0) {
				pageVO.setTotalPages(page.getTotal() / page.getPagesize());
			}
			else {
				pageVO.setTotalPages(page.getTotal() / page.getPagesize() + 1);
			}
		}
		else {
			pageVO.setPage(1);
			pageVO.setTotalPages(1);
		}
		pageVO.setRow(page.getPagesize());
		pageVO.setTotal(page.getTotal());
	}
}
