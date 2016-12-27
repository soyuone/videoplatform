package com.song.videoplatform.service.user.service;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import com.song.videoplatform.common.util.ResultInfo;
import com.song.videoplatform.common.util.ResultObj;
import com.song.videoplatform.web.user.vo.UserVO;

/**
 * <p>
 * Title: videoplatform_[user]_[Service层]
 * </p>
 * <p>
 * Description: [user表Service层]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2016年10月21日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
public interface UserService {

	/**
	 * <p>
	 * Description:[用户注册]
	 * </p>
	 * Created by [SOYU] [2016年12月27日] Midified by [修改人] [修改时间]
	 *
	 * @param userid
	 * @param username
	 * @param realname
	 * @param email
	 * @param birthday
	 * @param createtime
	 * @param password
	 * @param sex
	 * @return
	 * @throws ParseException
	 */
	public ResultInfo register(String userid, String username, String realname, String email, String birthday,
			String createtime, String password, String sex) throws ParseException;

	/**
	 * <p>
	 * Description:[用户登录]
	 * </p>
	 * Created by [SOYU] [2016年12月27日] Midified by [修改人] [修改时间]
	 *
	 * @param username
	 * @param password
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public ResultObj<UserVO> login(String username, String password) throws IllegalAccessException,
			InvocationTargetException;

}
