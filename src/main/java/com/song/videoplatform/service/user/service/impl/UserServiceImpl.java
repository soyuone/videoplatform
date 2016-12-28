package com.song.videoplatform.service.user.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.song.videoplatform.common.util.DateUtil;
import com.song.videoplatform.common.util.IConstant;
import com.song.videoplatform.common.util.MD5Util;
import com.song.videoplatform.common.util.ResultInfo;
import com.song.videoplatform.common.util.ResultObj;
import com.song.videoplatform.service.user.dao.UserDao;
import com.song.videoplatform.service.user.model.po.UserPO;
import com.song.videoplatform.service.user.service.UserService;
import com.song.videoplatform.web.user.vo.UserVO;

/**
 * <p>
 * Title: videoplatform_[user]_[Service层]
 * </p>
 * <p>
 * Description: [user表Service层实现类]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2016年10月21日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	
	protected Logger log = Logger.getLogger(UserServiceImpl.class);

	@Resource(name = "userDaoImpl")
	private UserDao userDao;

	@Override
	public ResultInfo register(String userid, String username, String realname, String email, String birthday,
			String createtime, String password, String sex) throws ParseException {
		ResultInfo resultInfo = new ResultInfo();
		// 重名校验
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		if (userDao.duplicatecheck(null, null, map)) {
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

		userPO = userDao.save(userPO);
		if (null == userPO) {
			resultInfo = new ResultInfo(IConstant.FAILURE, "注册失败，可能是网络原因", false);
		}
		resultInfo = new ResultInfo(IConstant.SUCCESS, "注册成功，请登录", true);
		return resultInfo;
	}

	@Override
	public ResultObj<UserVO> login(String username, String password) throws IllegalAccessException,
			InvocationTargetException {
		ResultObj<UserVO> resultObj = new ResultObj<UserVO>();
		UserVO userVO = new UserVO();
		List<UserPO> listUserPO = userDao.findByProperty("username", username);
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
		return resultObj;
	}

	@Override
	public ResultInfo updateUserinfo(String userid, String username) {
		ResultInfo resultInfo = new ResultInfo();
		int num =
				userDao.createQuery(" UPDATE UserPO SET username = :username WHERE userid = :userid ")
						.setParameter("username", username).setParameter("userid", userid).executeUpdate();
		if(num > 0){
			resultInfo = new ResultInfo(IConstant.FAILURE, "修改用户信息成功", true);
		}
		return resultInfo;
	}

}
