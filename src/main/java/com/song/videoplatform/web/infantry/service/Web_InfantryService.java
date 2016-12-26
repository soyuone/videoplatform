package com.song.videoplatform.web.infantry.service;

import com.song.videoplatform.common.util.ResultInfo;
import com.song.videoplatform.service.infantry.model.po.InfantryPO;

/**
 * <p>
 * Title: videoplatform_[infantry]_[Web Service层]
 * </p>
 * <p>
 * Description: [infantry表Web Service层]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2016年10月23日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
public interface Web_InfantryService {

	/**
	 * '
	 * <p>
	 * Description:[新增infantry信息]
	 * </p>
	 * Created by [SOYU] [2016年11月24日] Midified by [修改人] [修改时间]
	 *
	 * @param infantryPO
	 * @return
	 */
	public ResultInfo addInfantry(InfantryPO infantryPO);

	/**
	 * <p>
	 * Description:[修改infantry信息]
	 * </p>
	 * Created by [SOYU] [2016年11月24日] Midified by [修改人] [修改时间]
	 *
	 * @param infantryPO
	 * @return
	 */
	public ResultInfo updateInfantry(InfantryPO infantryPO);

}
