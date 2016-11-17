package com.song.videoplatform.web.infantry.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.song.videoplatform.web.infantry.service.Web_InfantryService;

/**
 * <p>
 * Title: videoplatform_[infantry]_[Controller层]
 * </p>
 * <p>
 * Description: [infantry表Controller层]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2016年10月23日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Controller
@RequestMapping("api/infantry")
public class InfantryController {

	protected Logger log = Logger.getLogger(InfantryController.class);

	@Autowired
	private Web_InfantryService web_InfantryService;

}
