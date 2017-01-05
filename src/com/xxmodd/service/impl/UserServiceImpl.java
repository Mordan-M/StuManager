package com.xxmodd.service.impl;

import com.xxmodd.dao.UserDao;
import com.xxmodd.entity.Admin;
import com.xxmodd.util.MD5Util;
import com.xxxmodd.service.UserService;

/**
 * 类名: AdminServiceImpl
 * 描述: 管理员业务实现
 * @author xxmodd
 * @data 2016-12-30 t下午4:12:08
 */
public class UserServiceImpl implements UserService{
	//盐
	private final static String salt = "tFxSJAS2PW(SQUyw1i7l9C_1gr&Y~Zi#RLU*^m8M%yF6^>(kdDON$VZeoDhT)~9G";
	private UserDao userDao;

	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public boolean admLogin(Integer uname , String psw){
		if(uname==null||psw==null){
			return false;
		}
		psw = MD5Util.MD5(salt + psw);
		return userDao.admLogin(uname , psw);
	}


	@Override
	public boolean stuLogin(Integer act, String psw) {
		if(act==null||psw==null){
			return false;
		}
		psw = MD5Util.MD5(salt + psw);
		return userDao.stuLogin(act, psw);
	}

}
