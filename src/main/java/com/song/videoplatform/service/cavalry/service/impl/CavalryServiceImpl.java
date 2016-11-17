package com.song.videoplatform.service.cavalry.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.song.videoplatform.service.cavalry.dao.CavalryDao;
import com.song.videoplatform.service.cavalry.model.po.CavalryPO;
import com.song.videoplatform.service.cavalry.service.CavalryService;

/**
 * <p>
 * Title: videoplatform_[cavalry]_[Service层]
 * </p>
 * <p>
 * Description: [cavalry视频表Service层实现类]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2016年10月13日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Service("cavalryServiceImpl")
public class CavalryServiceImpl implements CavalryService {

	@Resource(name = "cavalryDaoImpl")
	private CavalryDao cavalryDao;

	@Override
	public CavalryPO addCavalry(CavalryPO cavalryPO) {
		return cavalryDao.save(cavalryPO);
	}

}
