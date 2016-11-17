package com.song.videoplatform.web.user.service;

import com.song.videoplatform.common.util.ResultInfo;
import com.song.videoplatform.common.util.ResultObj;
import com.song.videoplatform.web.user.vo.UserVO;

/**
 * <p>
 * Title: videoplatform_[user]_[Web Service层]
 * </p>
 * <p>
 * Description: [user表Web Service层]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2016年10月21日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
public interface Web_UserService {

	/**
	 * <p>
	 * Description:[用户注册]
	 * </p>
	 * Created by [SO] [2016年10月21日] Midified by [修改人] [修改时间]
	 *
	 * @return
	 */
	public ResultInfo register(String userid, String username, String realname, String email, String birthday,
			String createtime, String password, String sex);

	/**
	 * <p>
	 * Description:[用户登录]
	 * </p>
	 * Created by [SOYU] [2016年10月21日] Midified by [修改人] [修改时间]
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	public ResultObj<UserVO> login(String username, String password);
}
