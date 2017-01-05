package com.xxmodd.util;

import java.security.MessageDigest;


/**
 * 类名: MD5Util
 * 描述: MD5加密工具类
 * @author xxmodd
 * @data 2017-1-4 t下午1:55:09
 */
public class MD5Util {
	
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
/*	public static void main(String[] args) {
		System.out.println(MD5Util.MD5("tFxSJAS2PW(SQUyw1i7l9C_1gr&Y~Zi#RLU*^m8M%yF6^>(kdDON$VZeoDhT)~9G" + "admin123"));
	}
*/
}