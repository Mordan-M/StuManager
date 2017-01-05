package com.xxmodd.dao;

import com.xxmodd.entity.Admin;

/**
 * 类名: AdminDao
 * 描述: 管理员数据操作接口
 * @author xxmodd
 * @data 2016-12-30 t下午4:11:45
 */
public interface UserDao {


	public boolean stuLogin(Integer act, String psw);
	
	public boolean admLogin(Integer uname , String psw);

}
