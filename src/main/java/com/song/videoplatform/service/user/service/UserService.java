package com.song.videoplatform.service.user.service;

import java.util.List;
import java.util.Map;

import com.song.videoplatform.service.user.model.po.UserPO;

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
	 * Created by [SOYU] [2016年10月21日] Midified by [修改人] [修改时间]
	 *
	 * @param userPO
	 * @return
	 */
	public UserPO addUser(UserPO userPO);

	/**
	 * <p>
	 * Description:[重名校验]
	 * </p>
	 * Created by [SOYU] [2016年10月21日] Midified by [修改人] [修改时间]
	 *
	 * @param idProperty
	 * @param id
	 * @param map
	 * @return
	 */
	public boolean duplicatecheck(String idProperty, Object id, Map<String, Object> map);

	/**
	 * <p>
	 * Description:[按属性查找对象列表]
	 * </p>
	 * Created by [SOYU] [2016年10月21日] Midified by [修改人] [修改时间]
	 *
	 * @param property
	 * @param value
	 * @return
	 */
	public List<UserPO> findByProperty(String property, Object value);
}
