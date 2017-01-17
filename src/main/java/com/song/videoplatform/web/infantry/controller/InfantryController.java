package com.song.videoplatform.web.infantry.controller;

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
import com.song.videoplatform.service.infantry.model.po.InfantryPO;
import com.song.videoplatform.service.infantry.service.InfantryService;

/**
 * <p>
 * Title: videoplatform_[infantry]_[Controller层]
 * </p>
 * <p>
 * Description: [infantry表Controller层]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2016年10月23日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Controller
@RequestMapping("api/infantry")
public class InfantryController {

	protected Logger log = Logger.getLogger(InfantryController.class);

	@Autowired
	private InfantryService infantryService;

	/**
	 * <p>
	 * Description:[新增infantry对象]
	 * </p>
	 * Created by [SOYU] [2016年11月24日] Midified by [修改人] [修改时间]
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addinfantry", method = RequestMethod.POST)
	@ResponseBody
	public ResultInfo addInfantry(HttpServletRequest request) {
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
			if (StringUtils.isBlank(actress)) {
				return new ResultInfo(IConstant.FAILURE, "请选择参演者", false);
			}
			if (StringUtils.isBlank(size)) {
				return new ResultInfo(IConstant.FAILURE, "请录入视频大小", false);
			}

			InfantryPO infantryPO =
					new InfantryPO(null, Integer.parseInt(actress), series, designation, company,
							Double.parseDouble(size), format, Timestamp.valueOf(addtime), null);
			// 添加
			infantryService.addInfantry(infantryPO);
			resultInfo = new ResultInfo(IConstant.SUCCESS, "新增infantry对象成功", true);
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultInfo = new ResultInfo(IConstant.FAILURE, "新增infantry对象异常，可能是网络原因", false);
		}
		return resultInfo;
	}

	/**
	 * <p>
	 * Description:[修改infantry对象]
	 * </p>
	 * Created by [SOYU] [2016年11月24日] Midified by [修改人] [修改时间]
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateinfantry", method = RequestMethod.POST)
	@ResponseBody
	public ResultInfo updateInfantry(HttpServletRequest request) {
		ResultInfo resultInfo = new ResultInfo();
		try {
			// 获取参数
			String actress = request.getParameter("actress");
			String series = request.getParameter("series");
			String designation = request.getParameter("designation");
			String company = request.getParameter("company");
			String size = request.getParameter("size");
			String format = request.getParameter("format");
			String addtime = request.getParameter("addtime");
			// String image = request.getParameter("image");

			// 空值校验
			if (StringUtils.isBlank(actress)) {
				return new ResultInfo(IConstant.FAILURE, "请选择参演者", false);
			}
			if (StringUtils.isBlank(size)) {
				return new ResultInfo(IConstant.FAILURE, "请录入视频大小", false);
			}

			InfantryPO infantryPO =
					new InfantryPO(null, Integer.parseInt(actress), series, designation, company,
							Double.parseDouble(size), format, Timestamp.valueOf(addtime), null);
			// 更新
			infantryService.updateInfantry(infantryPO);
			resultInfo = new ResultInfo(IConstant.SUCCESS, "修改infantry对象成功", true);
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultInfo = new ResultInfo(IConstant.FAILURE, "修改infantry对象异常，可能是网络原因", false);
		}
		return resultInfo;
	}
}
