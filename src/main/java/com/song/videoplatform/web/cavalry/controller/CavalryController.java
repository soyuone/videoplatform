package com.song.videoplatform.web.cavalry.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.videoplatform.common.util.CommonUtils;
import com.song.videoplatform.common.util.IConstant;
import com.song.videoplatform.common.util.ResultInfo;
import com.song.videoplatform.service.cavalry.model.po.CavalryPO;
import com.song.videoplatform.service.cavalry.service.CavalryService;

/**
 * <p>
 * Title: videoplatform_[cavalry]_[Controller层]
 * </p>
 * <p>
 * Description: [cavalry对象Controller层]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2016年10月13日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Controller
@RequestMapping("api/cavalry")
public class CavalryController {

	protected Logger log = Logger.getLogger(CavalryController.class);

	@Autowired
	private CavalryService cavalryService;

	/**
	 * <p>
	 * Description:[新增cavalry对象]
	 * </p>
	 * Created by [SOYU] [2016年10月13日] Midified by [修改人] [修改时间]
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addcavalry", method = RequestMethod.POST)
	@ResponseBody
	public ResultInfo addCavalry(HttpServletRequest request) {
		ResultInfo resultInfo = new ResultInfo();
		try {
			// 获取参数
			String actress = request.getParameter("actress");
			String series = request.getParameter("series");
			String designation = request.getParameter("designation");
			String company = request.getParameter("company");
			String size = request.getParameter("size");
			String format = request.getParameter("format");
			String addtime = CommonUtils.getCurrentDateTime(CommonUtils.DEFAULT_DATE_FORMAT);
			// String image = request.getParameter("image");

			// 空值校验
			if (StringUtils.isNotBlank(actress)) {
				return new ResultInfo(IConstant.FAILED_DATA_NOINPUT, "请选择参演者", false);
			}
			if (StringUtils.isNotBlank(size)) {
				return new ResultInfo(IConstant.FAILED_DATA_NOINPUT, "请录入视频大小", false);
			}

			CavalryPO cavalryPO =
					new CavalryPO(null, Integer.parseInt(actress), series, designation, company,
							Double.parseDouble(size), format, Timestamp.valueOf(addtime), null);
			// 添加
			cavalryService.addCavalry(cavalryPO);
			resultInfo = new ResultInfo(IConstant.SUCCESS, "新增cavalry对象成功", true);
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultInfo = new ResultInfo(IConstant.FAILURE, "新增cavalry对象异常，可能是网络原因", false);
		}
		return resultInfo;
	}
}
