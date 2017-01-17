package com.song.videoplatform.service.infantry.service;

import com.song.videoplatform.service.infantry.model.po.InfantryPO;

/**
 * <p>
 * Title: videoplatform_[infantry]_[Service层]
 * </p>
 * <p>
 * Description: [infantry对象Service层]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2016年10月23日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
public interface InfantryService {

	/**
	 * <p>
	 * Description:[新增infantry对象]
	 * </p>
	 * Created by [SOYU] [2016年11月24日] Midified by [修改人] [修改时间]
	 *
	 * @param infantryPO
	 * @return
	 */
	public InfantryPO addInfantry(InfantryPO infantryPO);

	/**
	 * <p>
	 * Description:[修改infantry对象]
	 * </p>
	 * Created by [SOYU] [2016年11月24日] Midified by [修改人] [修改时间]
	 *
	 * @param infantryPO
	 * @return
	 */
	public InfantryPO updateInfantry(InfantryPO infantryPO);

}
