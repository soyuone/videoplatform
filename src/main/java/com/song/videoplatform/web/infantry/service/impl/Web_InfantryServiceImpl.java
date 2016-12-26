package com.song.videoplatform.web.infantry.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.song.videoplatform.common.util.IConstant;
import com.song.videoplatform.common.util.ResultInfo;
import com.song.videoplatform.service.infantry.model.po.InfantryPO;
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

	protected Logger log = Logger.getLogger(Web_InfantryServiceImpl.class);

	@Resource(name = "infantryServiceImpl")
	private InfantryService infantryService;

	@Override
	public ResultInfo addInfantry(InfantryPO infantryPO) {
		ResultInfo resultInfo = new ResultInfo();
		try {
			if (infantryService.addInfantry(infantryPO) != null) {
				resultInfo = new ResultInfo(IConstant.SUCCESS, "新增infantry成功", true);
			}
			else {
				resultInfo = new ResultInfo(IConstant.FAILURE, "新增infantry异常", false);
			}
			int i = 2/0;
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultInfo = new ResultInfo(IConstant.FAILURE, "新增infantry异常", false);
			throw new RuntimeException();
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return resultInfo;
	}

	@Override
	public ResultInfo updateInfantry(InfantryPO infantryPO) {
		ResultInfo resultInfo = new ResultInfo();
		try {
			if (infantryService.updateInfantry(infantryPO) != null) {
				resultInfo = new ResultInfo(IConstant.SUCCESS, "修改infantry成功", true);
			}
			else {
				resultInfo = new ResultInfo(IConstant.FAILURE, "修改infantry失败", false);
			}
		}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			resultInfo = new ResultInfo(IConstant.FAILURE, "修改infantry异常", false);
		}
		return resultInfo;
	}

}
