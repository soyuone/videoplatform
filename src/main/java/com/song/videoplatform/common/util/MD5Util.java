package com.song.videoplatform.common.util;

import java.security.MessageDigest;

/**
 * <p>
 * Title: videoplatform_[工具类]_[MD5加密及验证]
 * </p>
 * <p>
 * Description: [MD5工具类]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2016年10月21日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
public class MD5Util {

	// 十六进制下数字到字符的映射数组
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	/**
	 * 把inputString加密
	 */
	public static String encode(String inputString) {
		return encodeByMD5(inputString);
	}

	/**
	 * 验证输入的密码是否正确
	 * 
	 * @param encodeStr 加密后的字符串
	 * @param inputString 输入的字符串
	 * @return 验证结果，true:正确 false:错误
	 */
	public static boolean validate(String encodeStr, String inputString) {
		return encodeStr.equals(encodeByMD5(inputString));
	}

	/**
	 * 对字符串进行MD5加密
	 */
	private static String encodeByMD5(String originString) {
		if (originString != null) {
			try {
				// 创建具有指定算法名称的信息摘要
				MessageDigest md = MessageDigest.getInstance("MD5");
				// 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
				byte[] results = md.digest(originString.getBytes());
				// 将得到的字节数组变成字符串返回
				String resultString = byteArrayToHexString(results);
				return resultString.toUpperCase();
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 转换字节数组为十六进制字符串
	 * 
	 * @param 字节数组
	 * @return 十六进制字符串
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	/**
	 * 将一个字节转化成十六进制形式的字符串
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
}
