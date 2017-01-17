package com.song.videoplatform.service.user.service;

import com.song.videoplatform.service.user.model.po.UserPO;

/**
 * <p>
 * Title: videoplatform_[测试类]_[测试]
 * </p>
 * <p>
 * Description: [测试hibernate框架Service层]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2017年1月17日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
public interface TestService {

	/**
	 * <p>
	 * Description:[测试方法-update]
	 * </p>
	 * Created by [SOYU] [2017年1月17日] Midified by [修改人] [修改时间]
	 *
	 * @return
	 */
	public UserPO updateTest(Integer id);

	/**
	 * <p>
	 * Description:[测试方法-get]
	 * </p>
	 * Created by [SOYU] [2017年1月17日] Midified by [修改人] [修改时间]
	 *
	 * @return
	 */
	public UserPO getTest(Integer id);

	/**
	 * <p>
	 * Description:[方法功能中文描述]
	 * </p>
	 * Created by [SOYU] [2017年1月17日] Midified by [修改人] [修改时间]
	 */
	public void findEhcache(String regionName);

}
