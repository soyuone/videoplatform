package com.song.videoplatform.web.cavalry.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.videoplatform.common.util.IConstant;
import com.song.videoplatform.common.util.ResultInfo;
import com.song.videoplatform.service.cavalry.model.po.CavalryPO;
import com.song.videoplatform.service.cavalry.service.CavalryService;
import com.song.videoplatform.web.cavalry.service.Web_CavalryService;

/**
 * <p>
 * Title: videoplatform_[cavalry]_[Web Service层]
 * </p>
 * <p>
 * Description: [cavalry视频表Web Service层实现类]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2016年10月13日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Service("web_CavalryServiceImpl")
public class Web_CavalryServiceImpl implements Web_CavalryService {

	@Autowired
	private CavalryService cavalryService;

	@Override
	public ResultInfo addCavalry(CavalryPO cavalryPO) {
		cavalryPO = cavalryService.addCavalry(cavalryPO);
		if (null != cavalryPO) {
			return new ResultInfo(IConstant.SUCCESS, "新增cavalry视频信息成功", true);
		}
		return new ResultInfo(IConstant.FAILURE, "新增cavalry视频信息失败", false);
	}

}
