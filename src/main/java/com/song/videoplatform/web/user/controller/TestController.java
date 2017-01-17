package com.song.videoplatform.web.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.videoplatform.common.util.IConstant;
import com.song.videoplatform.common.util.ResultInfo;
import com.song.videoplatform.service.user.service.TestService;

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
			testService.updateTest();
			resultInfo = new ResultInfo(IConstant.SUCCESS, "TEST-修改成功", true);
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultInfo = new ResultInfo(IConstant.FAILURE, "TEST-异常", false);
		}
		return resultInfo;
	}

}
