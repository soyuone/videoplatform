package com.song.videoplatform.service.infantry.dao.impl;

import org.springframework.stereotype.Repository;

import com.song.videoplatform.common.hibernate.HibernateBaseDaoImpl;
import com.song.videoplatform.service.infantry.dao.InfantryDao;
import com.song.videoplatform.service.infantry.model.po.InfantryPO;

/**
 * <p>
 * Title: videoplatform_[infantry]_[Dao层]
 * </p>
 * <p>
 * Description: [infantry对象Dao层实现类]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2016年10月23日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Repository("infantryDaoImpl")
public class InfantryDaoImpl extends HibernateBaseDaoImpl<InfantryPO, Integer> implements InfantryDao {

}
