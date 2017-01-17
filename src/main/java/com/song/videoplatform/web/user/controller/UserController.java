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
	// 所有的RuntimeException类及其子类的实例被称为Runtime异常；不是RuntimeException类及其子类的异常实例则被称为Checked异常
	// 如果程序没有处理Checked异常，该程序在编译时就会发生错误，无法通过编译
	// 用throws抛出异常：当前方法不知道如何处理这种类型的异常，该异常应该由上一级调用者处理

	// 如果throw语句抛出的异常是Checked异常，则该throw语句要么处于try块里，显示捕获该异常，要么放在一个带throws声明抛出的方法中，即把该异常交给该方法的调用者处理；
	// 如果throw语句抛出的异常是Runtime异常，则该语句无须放在try块里，也无须放在带throws声明抛出的方法中；程序既可以显式使用try···catch来捕获并处理该异常，
	// 也可以完全不理会该异常，把该异常交给该方法调用者处理

	// Java把所有的非正常情况分为两种，Exception和Error
	// 进行异常捕获时不仅应该把Exception类对应的catch块放在最后，而且所有父类异常的catch块都应该排在子类异常catch块的后面，否则编译错误

	// Java的垃圾回收机制不会回收任何物理资源，垃圾回收机制只能回收堆内存中对象所占用的内存
	// 有些时候，程序在try块里打开的物理资源都必须显示回收

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

			resultInfo = userService.register(userid, username, realname, email, birthday, createtime, password, sex);
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

	/**
	 * <p>
	 * Description:[修改用户信息]
	 * </p>
	 * Created by [SOYU] [2016年12月28日] Midified by [修改人] [修改时间]
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateuserinfo", method = RequestMethod.POST)
	@ResponseBody
	public ResultInfo updateUserinfo(HttpServletRequest request) {
		ResultInfo resultInfo = new ResultInfo();
		try {
			// 获取参数
			String userid = request.getParameter("userid");
			String username = request.getParameter("username");

			resultInfo = userService.updateUserinfo(userid, username);
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultInfo = new ResultInfo(IConstant.FAILURE, "修改异常，可能是网络原因", false);
		}
		return resultInfo;
	}

}
