package com.song.videoplatform.common.util;

/**
 * <p>
 * Title: videoplatform_[工具类]_[ResultInfo]
 * </p>
 * <p>
 * Description: [ResultInfo工具类]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2016年10月13日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
public class ResultInfo {
	protected int code;// <成功/失败/错误等状态码>

	protected String msg;// <失败/错误时的额外信息>

	protected boolean success;//true or false

	public ResultInfo() {

	}

	public ResultInfo(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ResultInfo(int code, String msg, boolean success) {
		this.code = code;
		this.msg = msg;
		this.success = success;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return JsonUtils.getJsonData(this);
	}
}
