package com.song.videoplatform.service.animation.dao.impl;

import org.springframework.stereotype.Repository;

import com.song.videoplatform.common.hibernate.HibernateBaseDaoImpl;
import com.song.videoplatform.service.animation.dao.AnimationDao;
import com.song.videoplatform.service.animation.model.po.AnimationPO;

/**
 * <p>
 * Title: videoplatform_[animation]_[Dao层实现类]
 * </p>
 * <p>
 * Description: [animation对象Dao层实现类]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2017年1月17日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Repository("animationDaoImpl")
public class AnimationDaoImpl extends HibernateBaseDaoImpl<AnimationPO, Integer> implements AnimationDao {

}
