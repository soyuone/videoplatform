package com.song.videoplatform.service.actress.dao.impl;

import org.springframework.stereotype.Repository;

import com.song.videoplatform.common.hibernate.HibernateBaseDaoImpl;
import com.song.videoplatform.service.actress.dao.ActressDao;
import com.song.videoplatform.service.actress.model.po.ActressPO;

/**
 * <p>
 * Title: videoplatform_[actress]_[Dao层实现类]
 * </p>
 * <p>
 * Description: [actress对象Dao层实现类]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2017年1月17日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Repository("actressDaoImpl")
public class ActressDaoImpl extends HibernateBaseDaoImpl<ActressPO, Integer> implements ActressDao {

}
