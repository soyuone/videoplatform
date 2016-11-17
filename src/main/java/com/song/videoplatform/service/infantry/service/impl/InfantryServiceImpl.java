package com.song.videoplatform.service.infantry.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.song.videoplatform.service.infantry.dao.InfantryDao;
import com.song.videoplatform.service.infantry.service.InfantryService;

/**
 * <p>
 * Title: videoplatform_[infantry]_[Service层]
 * </p>
 * <p>
 * Description: [infantry表Service层实现类]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2016年10月23日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Service("infantryServiceImpl")
public class InfantryServiceImpl implements InfantryService {

	@Resource(name = "infantryDaoImpl")
	private InfantryDao InfantryDao;
}
