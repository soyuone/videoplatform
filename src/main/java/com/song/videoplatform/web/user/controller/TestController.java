package com.song.videoplatform.web.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.videoplatform.common.util.IConstant;
import com.song.videoplatform.common.util.ResultInfo;
import com.song.videoplatform.common.util.ResultObj;
import com.song.videoplatform.service.user.model.po.UserPO;
import com.song.videoplatform.service.user.service.TestService;
import com.song.videoplatform.web.user.vo.TestVO;

/**
 * <p>
 * Title: videoplatform_[测试类]_[测试]
 * </p>
 * <p>
 * Description: [测试hibernate框架]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2017年1月17日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Controller
@RequestMapping("api/test")
public class TestController {

	protected Logger log = Logger.getLogger(TestController.class);

	@Autowired
	private TestService testService;

	/**
	 * <p>
	 * Description:[测试方法-update]
	 * </p>
	 * Created by [SOYU] [2017年1月17日] Midified by [修改人] [修改时间]
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updatetest", method = RequestMethod.POST)
	@ResponseBody
	public ResultInfo updateTest(HttpServletRequest request) {
		ResultInfo resultInfo = new ResultInfo();
		try {
			// 根据主键id加载对象
			String id = request.getParameter("id");

			testService.updateTest(Integer.parseInt(id));
			resultInfo = new ResultInfo(IConstant.SUCCESS, "TEST-成功", true);
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultInfo = new ResultInfo(IConstant.FAILURE, "TEST-异常", false);
		}
		return resultInfo;
	}

	/**
	 * <p>
	 * Description:[测试二级缓存]
	 * </p>
	 * Created by [SOYU] [2017年1月17日] Midified by [修改人] [修改时间]
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/cachetest", method = RequestMethod.GET)
	@ResponseBody
	public ResultObj<UserPO> chcheTest(HttpServletRequest request) {
		ResultObj<UserPO> resultObj = new ResultObj<UserPO>();
		try {
			// 根据主键id加载对象
			String id = request.getParameter("id");

			UserPO userPO = testService.getTest(Integer.parseInt(id));
			resultObj = new ResultObj<UserPO>(IConstant.SUCCESS, "TEST-成功", true);
			resultObj.setResult(userPO);

			// 二级缓存统计功能
			String regionName = "com.song.videoplatform.service.user.model.po.UserPO";
			testService.findEhcache(regionName);
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultObj = new ResultObj<UserPO>(IConstant.FAILURE, "TEST-异常", false);
		}
		return resultObj;
	}

	/**
	 * <p>
	 * Description:[测试join]
	 * </p>
	 * Created by [SOYU] [2017年1月17日] Midified by [修改人] [修改时间]
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/jointest", method = RequestMethod.GET)
	@ResponseBody
	public ResultObj<List<TestVO>> joinTest(HttpServletRequest request) {
		ResultObj<List<TestVO>> resultObj = new ResultObj<List<TestVO>>();
		try {

		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultObj = new ResultObj<List<TestVO>>(IConstant.FAILURE, "TEST-异常", false);
		}
		return resultObj;
	}

}
