package com.song.videoplatform.web.infantry.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.song.videoplatform.service.infantry.service.InfantryService;
import com.song.videoplatform.web.infantry.service.Web_InfantryService;

/**
 * <p>
 * Title: videoplatform_[infantry]_[Web Service层]
 * </p>
 * <p>
 * Description: [infantry表Web Service层实现类]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2016年10月23日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Service("web_InfantryServiceImpl")
public class Web_InfantryServiceImpl implements Web_InfantryService {

	@Resource(name = "infantryServiceImpl")
	private InfantryService infantryService;

}
