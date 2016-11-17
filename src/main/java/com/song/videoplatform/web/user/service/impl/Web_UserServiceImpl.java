package com.song.videoplatform.web.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.videoplatform.common.util.DateUtil;
import com.song.videoplatform.common.util.IConstant;
import com.song.videoplatform.common.util.MD5Util;
import com.song.videoplatform.common.util.ResultInfo;
import com.song.videoplatform.common.util.ResultObj;
import com.song.videoplatform.service.user.model.po.UserPO;
import com.song.videoplatform.service.user.service.UserService;
import com.song.videoplatform.web.user.service.Web_UserService;
import com.song.videoplatform.web.user.vo.UserVO;

/**
 * <p>
 * Title: videoplatform_[user]_[Web Service层]
 * </p>
 * <p>
 * Description: [user表Web Service层实现类]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2016年10月21日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Service("web_UserServiceImpl")
public class Web_UserServiceImpl implements Web_UserService {

	protected Logger log = Logger.getLogger(Web_UserServiceImpl.class);

	@Autowired
	private UserService userService;

	@Override
	public ResultInfo register(String userid, String username, String realname, String email, String birthday,
			String createtime, String password, String sex) {
		ResultInfo resultInfo = new ResultInfo();
		try {
			// 重名校验
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("username", username);
			if (userService.duplicatecheck(null, null, map)) {
				return new ResultInfo(IConstant.FAILURE, "用户名已存在，请更换", false);
			}

			// 新增
			UserPO userPO = new UserPO();
			userPO.setUserid(userid);
			userPO.setUsername(username);
			userPO.setRealname(realname);
			userPO.setEmail(email);
			userPO.setBirthday(DateUtil.StringToDate(birthday, IConstant.SHORT_DATE_FORMAT));
			userPO.setCreatetime(DateUtil.StringToDate(createtime, null));
			userPO.setPassword(MD5Util.encode(password));
			userPO.setSex(sex);

			userPO = userService.addUser(userPO);
			if (null == userPO) {
				resultInfo = new ResultInfo(IConstant.FAILURE, "注册失败，可能是网络原因", false);
			}
			resultInfo = new ResultInfo(IConstant.SUCCESS, "注册成功，请登录", true);
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultInfo = new ResultInfo(IConstant.FAILURE, "注册失败，网络异常", false);
		}
		return resultInfo;
	}

	@Override
	public ResultObj<UserVO> login(String username, String password) {
		ResultObj<UserVO> resultObj = new ResultObj<UserVO>();
		UserVO userVO = new UserVO();
		try {
			List<UserPO> listUserPO = userService.findByProperty("username", username);
			if (listUserPO != null && listUserPO.size() > 0) {
				UserPO userPO = listUserPO.get(0);
				if (MD5Util.validate(userPO.getPassword(), password)) {
					resultObj.setCode(IConstant.SUCCESS);
					resultObj.setMsg("登录成功");
					resultObj.setSuccess(true);
					BeanUtils.copyProperties(userVO, userPO);

					resultObj.setResult(userVO);
				}
				else {
					resultObj = new ResultObj<UserVO>(IConstant.FAILURE, "用户名和密码不匹配，请检查", false);
				}
			}
			else {
				resultObj = new ResultObj<UserVO>(IConstant.FAILURE, "用户名不存在，请先注册", false);
			}
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultObj = new ResultObj<UserVO>(IConstant.FAILURE, "登录失败，网络异常", false);
		}
		return resultObj;
	}
}
