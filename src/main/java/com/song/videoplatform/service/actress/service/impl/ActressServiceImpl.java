package com.song.videoplatform.service.actress.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.song.videoplatform.service.actress.dao.ActressDao;
import com.song.videoplatform.service.actress.service.ActressService;

/**
 * <p>
 * Title: videoplatform_[actress]_[Service层实现类]
 * </p>
 * <p>
 * Description: [actress对象Service层实现类]
 * </p>
 * 
 * @author SO
 * @version $Revision$ 2017年1月17日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
@Service("actressServiceImpl")
public class ActressServiceImpl implements ActressService {

	@Resource(name = "actressDaoImpl")
	private ActressDao actressDao;

}
