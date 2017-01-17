package com.song.videoplatform.service.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.song.videoplatform.service.user.dao.UserDao;
import com.song.videoplatform.service.user.model.po.UserPO;
import com.song.videoplatform.service.user.service.TestService;

/**
 * <p>
 * Title: videoplatform_[测试类]_[测试]
 * </p>
 * <p>
 * Description: [测试hibernate框架Service层实现类]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2017年1月17日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Service("testServiceImpl")
public class TestServiceImpl implements TestService {

	@Resource(name = "userDaoImpl")
	private UserDao userDao;

	@Override
	public UserPO updateTest(Integer id) {
		// 在加载了持久化实例后，实例就处于持久化状态，对持久化实例所作的修改会保存到数据库(会在Session flush前被自动保存到数据库，无须程序调用其它方法，
		// 不需要调用update方法)
		UserPO userPO = userDao.get(id);
		userPO.setRealname("宋玉");

		return userPO;
	}

	@Override
	public UserPO getTest(Integer id) {
		return userDao.get(id);
	}

	@Override
	public void findEhcache(String regionName) {
		userDao.findEhcache(regionName);
	}

}
