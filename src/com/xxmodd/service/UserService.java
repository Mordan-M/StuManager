package com.xxmodd.service;


/**
 * 类名: AdminService
 * 描述: 管理员业务接口
 * @author xxmodd
 * @data 2016-12-30 t下午4:12:30
 */
public interface UserService {
	public boolean stuLogin(Integer act, String psw);
	
	public boolean admLogin(Integer uname , String psw);
}
