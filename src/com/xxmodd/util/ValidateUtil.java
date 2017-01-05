package com.xxmodd.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 类名: ValidateUtil
 * 描述: 表单校验类
 * @author xxmodd
 * @data 2017-1-2 t下午2:01:19
 */
public class ValidateUtil {
	
	/**
	 * 学号验证
	 */
	public static boolean isValidStuId(String str) {
		boolean flag = false;
		Pattern p = Pattern.compile("^\\d{9}$");
		if (str != null) {
			Matcher match = p.matcher(str);
			flag = match.matches();
		}
		System.out.println("StuId " + flag);
		return flag;
	}
	
	/**
	 * 密码验证
	 */
	public static boolean isValidPass(String str) {
		boolean flag = false;
		// 只要是非空白字符就行
		Pattern p = Pattern.compile("[^\\s]{1,}");
		if (str != null) {
			Matcher match = p.matcher(str);
			flag = match.matches();
		}
		System.out.println("pass " + flag);
		return flag;
	}
	
	/**
	 * 姓名验证
	 */
	public static boolean isValidName(String str) {
		boolean flag = false;
		Pattern p = Pattern.compile("^[\u4E00-\u9FA5]{2,5}$");
		if (str != null) {
			Matcher match = p.matcher(str);
			flag = match.matches();
		}
		return flag;
	}
	
	/**
	 * 手机验证
	 */
	public static boolean isValidPhone(String str) {
		boolean flag = false;
		Pattern p = Pattern.compile("^1[35478]\\d{9}$");
		if (str != null) {
			Matcher match = p.matcher(str);
			flag = match.matches();
		}
		System.out.println("phone " + flag);
		return flag;
	}
	
	/**
	 * QQ验证
	 */
	public static boolean isValidQQ(String str) {
		boolean flag = false;
		Pattern p = Pattern.compile("^[1-9][0-9]{4,14}$");
		if (str != null) {
			Matcher match = p.matcher(str);
			flag = match.matches();
		}
		return flag;
	}
	
	/**
	 * 微信号验证
	 */
	public static boolean isValidWeChat(String str) {
		boolean flag = false;
		Pattern p = Pattern.compile("^[\\w\\W]{1,20}$");
		if (str != null) {
			Matcher match = p.matcher(str);
			flag = match.matches();
		}
		return flag;
	}
	
	/**
	 * 内容验证
	 */
	public static boolean isValidDetail(String str) {
		boolean flag = false;
		// 匹配任意字符和换行
//		Pattern p = Pattern.compile("^[.\\n]{5,300}$");
		Pattern p = Pattern.compile("^[\\d\\D]{15,500}$");
		if (str != null) {
			Matcher match = p.matcher(str);
			flag = match.matches();
		}
		return flag;
	}
	
	/**
	 * 性别校验
	 */
	public static boolean isValidSex(String sex){
		boolean flag = false;
		if(sex.equals("男")||sex.equals("女")){
			flag = true;
		}
		System.out.println("Sex " + flag);
		return flag;
	}

	/**
	 * 验证是否是正确的邮箱格式
	 * 
	 * @param email
	 * @return true表示是正确的邮箱格式,false表示不是正确邮箱格式
	 */
	public static boolean isValidEmail(String email) {
		// 1、\\w+表示@之前至少要输入一个匹配字母或数字或下划线 \\w 单词字符：[a-zA-Z_0-9]
		// 2、(\\w+\\.)表示域名. 如新浪邮箱域名是sina.com.cn
		// {1,3}表示可以出现一次或两次或者三次.
		String reg = "\\w+@(\\w+\\.){1,3}\\w+";
		Pattern pattern = Pattern.compile(reg);
		boolean flag = false;
		if (email != null) {
			Matcher matcher = pattern.matcher(email);
			flag = matcher.matches();
		}
		return flag;
	}
	
	public static void main(String[] args) {
		System.out.println(isValidPass("123456"));
		
	}

}