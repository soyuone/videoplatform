package com.song.videoplatform.web.animation.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.song.videoplatform.service.animation.service.AnimationService;

/**
 * <p>
 * Title: videoplatform_[animation]_[Controller层]
 * </p>
 * <p>
 * Description: [animation对象Controller层]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2017年1月17日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Controller
@RequestMapping("api/animation")
public class AnimationController {

	protected Logger log = Logger.getLogger(AnimationController.class);

	@Autowired
	private AnimationService animationService;

}
