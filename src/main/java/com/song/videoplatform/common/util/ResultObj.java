package com.song.videoplatform.common.util;

/**
 * <p>
 * Title: videoplatform_[工具类]_[ResultObj]
 * </p>
 * <p>
 * Description: [ResultObj工具类]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2016年10月21日
 * @author (lastest modification by $Author$)
 * @since 20100901
 * @param <T>
 */
public class ResultObj<T> extends ResultInfo {
	public static final int RECODE_OK = 200;

	public static final int RECODE_FAIL = 404;

	public static final int NO_LOGIN = -2;

	public static final String SUCCESS = "success";

	public static final String ERROR = "error";

	public static final String LOGIN = "您还没有登录，请登录！";

	private T result;// 输出

	public ResultObj() {
		super();
	}

	public ResultObj(int code, String msg) {
		super(code, msg);
	}

	public ResultObj(int code, String msg, boolean success) {
		super(code, msg, success);
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public ResultObj<T> successMsg() {
		this.code = RECODE_OK;
		this.msg = SUCCESS;
		return this;
	}

	public ResultObj<T> successMsg(String successMsg) {
		this.code = RECODE_OK;
		this.msg = successMsg;
		return this;
	}

	public ResultObj<T> errorMsg() {
		this.code = RECODE_FAIL;
		this.msg = ERROR;
		return this;
	}

	public ResultObj<T> errorMsg(String errorMsg) {
		this.code = RECODE_FAIL;
		this.msg = errorMsg;
		return this;
	}

	public ResultObj<T> loginMsg() {
		this.code = NO_LOGIN;
		this.msg = LOGIN;
		return this;
	}

	@Override
	public String toString() {
		return JsonUtils.getJsonData(this);
	}
}
