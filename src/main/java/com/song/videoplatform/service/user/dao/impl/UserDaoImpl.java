package com.song.videoplatform.service.user.dao.impl;

import org.springframework.stereotype.Repository;

import com.song.videoplatform.common.hibernate.HibernateBaseDaoImpl;
import com.song.videoplatform.service.user.dao.UserDao;
import com.song.videoplatform.service.user.model.po.UserPO;

/**
 * <p>
 * Title: videoplatform_[user]_[Dao层]
 * </p>
 * <p>
 * Description: [user表Dao层实现类]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2016年10月21日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Repository("userDaoImpl")
public class UserDaoImpl extends HibernateBaseDaoImpl<UserPO, Integer> implements UserDao {

}
