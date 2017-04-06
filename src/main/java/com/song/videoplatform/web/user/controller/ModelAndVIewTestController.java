package com.song.videoplatform.web.user.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.song.videoplatform.service.user.model.po.UserPO;
import com.song.videoplatform.service.user.service.UserService;

/**
 * <p>
 * Title: videoplatform_[测试类]_[测试]
 * </p>
 * <p>
 * Description: [测试ModelAndVIew]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2017年4月6日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Controller
@RequestMapping("api/modelandvIewtest")
public class ModelAndVIewTestController {

	// http://blog.csdn.net/json20080301/article/details/12620547
	// http://www.cnblogs.com/Sunnor/p/6130380.html

	protected Logger log = Logger.getLogger(ModelAndVIewTestController.class);

	@Autowired
	private UserService userService;

	// 测试直接转向页面
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String forwardJsp() {
		return "login";
	}

	// 测试@ResponseBody注解
	@RequestMapping(value = "/userinfo", method = RequestMethod.GET)
	@ResponseBody
	public UserPO getUserInfo() {
		UserPO userPO = new UserPO(100, "1001", "Tom", "Song Yu", "soyuone@gmail.com", null, null, "admin", "男");
		return userPO;
	}

	// 测试ResponseEntity
	@RequestMapping(value = "/userinfo/noannotation", method = RequestMethod.GET)
	public ResponseEntity<UserPO> getUserInfoNoAnnotation() {
		ResponseEntity<UserPO> rs = null;
		UserPO userPO = new UserPO(100, "1001", "Tom", "Song Yu", "soyuone@gmail.com", null, null, "admin", "男");
		rs = new ResponseEntity<UserPO>(userPO, HttpStatus.OK);
		return rs;
	}

	// 测试ModelAndView
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView getModelAndView() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	// 测试ModelAndView
	@RequestMapping(value = "/mav/map", method = RequestMethod.GET)
	public ModelAndView getModelAndViewAndMap() {
		ModelAndView mav = new ModelAndView("login");

		UserPO userPO = new UserPO(100, "1001", "Tom", "Song Yu", "soyuone@gmail.com", null, null, "admin", "男");
		mav.addObject("_USER_", userPO);
		return mav;
	}
}
