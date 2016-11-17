package com.song.videoplatform.service.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.song.videoplatform.service.user.dao.UserDao;
import com.song.videoplatform.service.user.model.po.UserPO;
import com.song.videoplatform.service.user.service.UserService;

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

	@Resource(name = "userDaoImpl")
	private UserDao userDao;

	@Override
	public UserPO addUser(UserPO userPO) {
		return userDao.save(userPO);
	}

	@Override
	public boolean duplicatecheck(String idProperty, Object id, Map<String, Object> map) {
		return userDao.duplicatecheck(idProperty, id, map);
	}

	@Override
	public List<UserPO> findByProperty(String property, Object value) {
		return userDao.findByProperty(property, value);
	}
}
