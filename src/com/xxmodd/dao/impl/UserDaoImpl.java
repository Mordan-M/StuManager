package com.xxmodd.dao.impl;

import org.hibernate.SessionFactory;

import com.xxmodd.dao.UserDao;
import com.xxmodd.util.HibernateDBUtil;

/**
 * 类名: AdminDaoImpl
 * 描述: 用户操作实现类
 * @author xxmodd
 * @data 2016-12-30 t下午3:46:57
 */
public class UserDaoImpl implements UserDao{
	private SessionFactory sessionFactory;
	
	//set方法注入
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/*
	 * 管理员登入
	 */
	@Override
	public boolean admLogin(Integer uname , String psw){
		String sql = "SELECT * FROM `admin` WHERE `adm_id` = ? and `adm_psw` = ?";
		HibernateDBUtil op = new HibernateDBUtil(sessionFactory);
		return op.sqlObjectQuery(sql, uname, psw).size()!=0;
	}
	
	/*
	 * 学生登入
	 */
	@Override
	public boolean stuLogin(Integer act , String psw){
		String sql = "SELECT * FROM `student` WHERE `stu_id` = ? and `stu_psw` = ?";
		HibernateDBUtil op = new HibernateDBUtil(sessionFactory);
		return op.sqlObjectQuery(sql, act, psw).size()!=0;
	}
	
/*	
	 * 学生注册
	 
	public boolean stuRegister(Student stu){
		String sql = "SELECT * FROM `student` WHERE `stu_id` = ? and `stu_psw` = ?";
		Operation op = new Operation(getSession());
		return op.sqlObjectQuery(sql, act, psw).size()!=0;
	}*/
	
}
