package com.song.videoplatform.service.cavalry.service;

import com.song.videoplatform.service.cavalry.model.po.CavalryPO;

/**
 * <p>
 * Title: videoplatform_[cavalry]_[Service层]
 * </p>
 * <p>
 * Description: [cavalry视频表Service层]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2016年10月13日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
public interface CavalryService {

	/**
	 * <p>
	 * Description:[新增cavalry视频信息]
	 * </p>
	 * Created by [SOYU] [2016年10月13日] Midified by [修改人] [修改时间]
	 *
	 * @param cavalryPO
	 * @return
	 */
	public CavalryPO addCavalry(CavalryPO cavalryPO);

}
