package com.xxmodd.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xxmodd.entity.Admin;
import com.xxmodd.entity.Student;
import com.xxmodd.service.UserService;

/**
 * 类名: UserAction
 * 描述: 用户action ， 处理登入以及注册
 * @author xxmodd
 * @data 2016-12-30 t下午4:14:12
 */
public class UserAction extends ActionSupport implements ModelDriven<Student>,SessionAware{
	private static final long serialVersionUID = 1L;

	private UserService userService;
	private Integer username;//用户名，学号或者管理员账号
	private String password;//密码
	private Integer userType;//用户类型，1表示普通用户（学生），2表示管理员
	private Map<String , Object> valueMap = new HashMap<String , Object>();//返回json数据
	private Student student = new Student();
	private Map<String, Object> session;
	
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public Integer getUsername() {
		return username;
	}

	public void setUsername(Integer username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Map<String, Object> getValueMap() {
		return valueMap;
	}
	public void setValueMap(Map<String, Object> valueMap) {
		this.valueMap = valueMap;
	}

	public String login(){
		Boolean bool;
		if(userType==null){
			valueMap.put("msg","error");
		}else{
			if(userType==1){
				bool = userService.stuLogin(username, password);
				if(bool){
					session.put("student", username);
					valueMap.put("userType", userType);
				}
				valueMap.put("msg", bool);
			}else if(userType==2){
				bool = userService.admLogin(username, password);
				if(bool){
					session.put("admin", username);
					valueMap.put("userType", userType);
				}
				valueMap.put("msg", bool);
			}else{
				valueMap.put("msg","error");
			}
		}
		return "valueMap";
	}
	
	public String logout(){
		session.clear();
		valueMap.put("msg", true);
		return "valueMap";
	}
	
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	@Override
	public Student getModel() {
		return student;
	}














}
