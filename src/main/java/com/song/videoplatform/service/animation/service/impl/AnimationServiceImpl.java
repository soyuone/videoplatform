package com.song.videoplatform.service.animation.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.song.videoplatform.service.animation.dao.AnimationDao;
import com.song.videoplatform.service.animation.service.AnimationService;

/**
 * <p>
 * Title: videoplatform_[animation]_[Service层实现类]
 * </p>
 * <p>
 * Description: [animation对象Service层实现类]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2017年1月17日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Service("animationServiceImpl")
public class AnimationServiceImpl implements AnimationService {
	@Resource(name = "animationDaoImpl")
	private AnimationDao animationDao;

}
