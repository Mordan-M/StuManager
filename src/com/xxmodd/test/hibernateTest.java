package com.xxmodd.test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xxmodd.dao.impl.UserDaoImpl;
import com.xxmodd.dao.impl.StudentDaoImpl;
import com.xxmodd.entity.Admin;
import com.xxmodd.entity.CountForInfo;
import com.xxmodd.entity.Student;


/**
 * 类名: hibernateTest
 * 描述: 数据库操作测试
 * @author xxmodd
 * @data 2016-12-26 t下午3:48:51
 */
public class hibernateTest {
	
	private static ApplicationContext context = null;
	private static StudentDaoImpl sdi = null;
	private static UserDaoImpl adi = null;
	
	static{
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		sdi = context.getBean(StudentDaoImpl.class);
		adi = context.getBean(UserDaoImpl.class);
	}
	
	/*
	 * 获取所有学生信息
	 */
	@Test
	public void getAllStuInfosTest(){
		List<Student> stuList = sdi.getAllStuInfos();
		for(Student s : stuList){
			System.out.println(s.toString());
		}
	}
	
	/*
	 * 根据学号查询基本信息
	 */
	@Test
	public void getStuByActTest() {
		System.out.println(sdi.getStuByAct(1));
	}
	
	/* 
	 * 根据学号更新学生信息
	 */
	@Test
	public void updateStuByStuIdTest(){ 
		Student s = new Student(1, "莫丹", "男", 20, "1511028907", "无", "即可");
		System.out.println(sdi.updateStuByStuId(s));
	}
	
	/*
	 * 添加学生信息
	 */
	@Test
	public void addStuTest(){
		Student s = new Student(3, "zzliux", "女", 25, "1111111111", "wu", "jk", "zz123");
		System.out.println(sdi.addStu(s));
	}
	
	/*
	 * 删除学生信息
	 */
	@Test
	public void deleteStuTest(){
		System.out.println(sdi.deleteStu(new Student(3)));
	}
	
	/*
	 * 统计各班人数
	 */
	@Test
	public void getStuCntForClassTest(){
		List<Object[]> list = sdi.getStuCntForClass();
		System.out.println(Arrays.toString(list.get(0)));
//		System.out.println(list.size());
	}
	
	/*
	 * 根据班级统计不同性别人数
	 */
	@Test
	public void getStuCntForSexByClassTest(){
		List<Object[]> list = sdi.getStuCntForSexGroupByClass();
		System.out.println(Arrays.toString(list.get(0)));
	}
	
	
	
	/*
	 * 统计不同年龄人数
	 */
	@Test
	public void getStuAgeGroupByAgeTest(){
		List<Object[]> list = sdi.getStuAgeGroupByAge();
		System.out.println(Arrays.toString(list.get(0)));
	}
	
	/*
	 * 统计所有学生各性别人数
	 */
	@Test
	public void getStuCntGroupBySexTest(){
		List<Object[]> list = sdi.getStuCntGroupBySex();
		System.out.println(Arrays.toString(list.get(0)));
	}
	
	/*
	 * 学生修改自己的密码
	 */
	@Test
	public void updatePswByStuIdTest(){
		System.out.println(sdi.updatePswByStuId("123456", 190920001));
	}
	
	
	/*
	 * 生成若干数据
	 */
	@Test
	public void getData(){
		//计科软件班级号 1901-1903  人数 没班30个
		int stuId = 190920001;
		String  phone = "15111589634";
		int index = 1;
		Random r = new Random();
		String[] sex = {"男","女"};
		for(int j=0;j<3;j++){
			for(int i = 0;i < 25+r.nextInt(10) ;i++){
				Student s = new Student(stuId++, "AI-" + index++ +"号", sex[r.nextInt(2)],
						18 + r.nextInt(4), phone , "无", "计科" + 1901+ j, "123");
//				System.out.println(s);
				sdi.addStu(s);
			}
		}
		
		for(int j=0;j<3;j++){
			for(int i = 0;i <  25+r.nextInt(10) ;i++){
				Student s = new Student(stuId++, "AI-" + index++ +"号", sex[r.nextInt(2)],
						18 + r.nextInt(4), phone , "无", "软件" + 1901+ j, "123");
//				System.out.println(s);
				sdi.addStu(s);
			}
		}
		
		
	}
	
	
	/*---------------华丽的分割线，以下是关于所有用户的操作---------------------*/
	@Test
	public void adminLoginTest(){
		System.out.println(adi.admLogin(1909, "admin123"));
	}
	
	@Test
	public void stuLoginTest(){
		System.out.println(adi.stuLogin(190920001, "123"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
