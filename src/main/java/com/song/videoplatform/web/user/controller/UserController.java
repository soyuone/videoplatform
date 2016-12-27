package com.song.videoplatform.web.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.videoplatform.common.util.CommonUtils;
import com.song.videoplatform.common.util.IConstant;
import com.song.videoplatform.common.util.ResultInfo;
import com.song.videoplatform.common.util.ResultObj;
import com.song.videoplatform.service.user.service.UserService;
import com.song.videoplatform.web.user.vo.UserVO;

/**
 * <p>
 * Title: videoplatform_[user]_[Controller层]
 * </p>
 * <p>
 * Description: [user表Controller层]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2016年10月21日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Controller
@RequestMapping("api/user")
public class UserController {

	protected Logger log = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	// Java异常机制主要依赖于try,catch,finally,throw,throws五个关键字
	// throws关键字主要用在方法签名中，用于声明该方法可抛出的异常
	// throw用于抛出一个实际的异常 
	// Java将异常分为两类：Checked异常，Runtime异常
	// Java认为Checked异常都是可以在编译阶段被处理的异常，所以它强制程序处理所有的Checked异常，而Runtime异常则无须处理

	/**
	 * <p>
	 * Description:[用户注册]
	 * </p>
	 * Created by [SOYU] [2016年12月27日] Midified by [修改人] [修改时间]
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ResultInfo register(HttpServletRequest request) {
		ResultInfo resultInfo = new ResultInfo();
		try {
			// 获取参数
			String userid = CommonUtils.generateId();
			String username = request.getParameter("username");
			String realname = request.getParameter("realname");
			String email = request.getParameter("email");
			String birthday = request.getParameter("birthday");
			String createtime = CommonUtils.getCurrentDateTime();
			String password = request.getParameter("password");
			String sex = request.getParameter("sex");

			//注册
			resultInfo =
					userService.register(userid, username, realname, email, birthday, createtime, password, sex);
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultInfo = new ResultInfo(IConstant.FAILURE, "注册失败，可能是网络异常", false);
		}
		return resultInfo;
	}

	/**
	 * <p>
	 * Description:[用户登录]
	 * </p>
	 * Created by [SOYU] [2016年10月21日] Midified by [修改人] [修改时间]
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResultObj<UserVO> login(HttpServletRequest request) {
		ResultObj<UserVO> resultObj = new ResultObj<UserVO>();
		try {
			// 获取参数
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			//登录
			resultObj = userService.login(username, password);

			// 如果登录成功则把用户信息保存到HttpSession
			if (resultObj.getCode() == IConstant.SUCCESS) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("USER", resultObj.getResult());
				// 设置HttpSession有效期
				httpSession.setMaxInactiveInterval(1800);
			}
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultObj = new ResultObj<UserVO>(IConstant.FAILURE, "登录失败，网络异常", false);
		}
		return resultObj;
	}

}
