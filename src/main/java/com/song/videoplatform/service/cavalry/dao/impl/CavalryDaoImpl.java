package com.song.videoplatform.service.cavalry.dao.impl;

import org.springframework.stereotype.Repository;

import com.song.videoplatform.common.hibernate.HibernateBaseDaoImpl;
import com.song.videoplatform.service.cavalry.dao.CavalryDao;
import com.song.videoplatform.service.cavalry.model.po.CavalryPO;

/**
 * <p>
 * Title: videoplatform_[cavalry]_[Dao层]
 * </p>
 * <p>
 * Description: [cavalry对象Dao层实现类]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2016年10月13日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Repository("cavalryDaoImpl")
public class CavalryDaoImpl extends HibernateBaseDaoImpl<CavalryPO, Integer> implements CavalryDao {

}
