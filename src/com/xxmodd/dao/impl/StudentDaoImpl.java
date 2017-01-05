package com.xxmodd.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xxmodd.dao.StudentDao;
import com.xxmodd.entity.Student;
import com.xxmodd.util.HibernateDBUtil;

/**
 * 类名: StudentDaoImpl
 * 描述: 学生信息数据操作实现类
 * @author xxmodd
 * @data 2016-12-26 t下午4:20:19
 */
public class StudentDaoImpl implements StudentDao{
	
	private SessionFactory sessionFactory;
	//set方法注入
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession(){
//		Session s = sessionFactory.getCurrentSession();
		
//		return (s==null || !s.isOpen()) ? sessionFactory.openSession()  : s;
		return sessionFactory.openSession();
	}
	
	/*
	 * 获取所有学生信息
	 */
	@Override
	public List<Student> getAllStuInfos(){
		String hql = "from Student ";
		HibernateDBUtil op = new HibernateDBUtil(getSession());
		@SuppressWarnings("unchecked")
		List<Student> stuList = op.hqlQuery(hql);
		return stuList;
	}
	
	/*
	 * 根据学号查询基本信息
	 */
	@Override
	public Student getStuByAct(int stuId){
		String sql = "SELECT * FROM `student` WHERE stu_id = ? ";
		HibernateDBUtil op = new HibernateDBUtil(getSession());
		@SuppressWarnings("unchecked")
		List<Student> list = (List<Student>)op.sqlHbEntityQuery(sql,Student.class, stuId);
		return list.size()>0?list.get(0):null;
	}
	
	/*
	 * 根据学号更新学生信息
	 */
	@Override
	public boolean updateStuByStuId(Student stu) {
		String sql = "UPDATE `student` SET  `stu_name`=?, `stu_sex`=?, `stu_age`=?, `stu_phone`=?, `stu_address`=?, `class_name`=? WHERE (`stu_id`=?)";
		HibernateDBUtil op = new HibernateDBUtil(getSession());
		return op.sqlExecute(sql, stu.getStuName(),stu.getStuSex(),stu.getStuAge(),stu.getStuPhone(),stu.getStuAddress(),stu.getClassName(),stu.getStuId());
	}
	
	/*
	 * 添加学生信息
	 */
	@Override
	public boolean addStu(Student stu) {
		String sql = "INSERT INTO `student` (`stu_id`, `stu_name`, `stu_sex`, `stu_age`, `stu_phone`, `stu_address`, `class_name`, `stu_psw`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		HibernateDBUtil op = new HibernateDBUtil(getSession());
		return op.sqlExecute(sql, stu.getStuId(),stu.getStuName(),stu.getStuSex(),stu.getStuAge(),stu.getStuPhone(),stu.getStuAddress(),stu.getClassName(),stu.getStuPsw());
	}
	
	/*
	 * 删除学生信息
	 */
	@Override
	public boolean deleteStu(Student stu){
//		String sql = "DELETE FROM `student` WHERE (`stu_id`=?)";
		HibernateDBUtil op = new HibernateDBUtil(getSession());
//		return op.sqlExecute(sql, stuId);
		return op.delete(stu);
	}
	
	/*
	 * 统计各班人数
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getStuCntForClass(){
		String sql = "SELECT `class_name` as 'className' ,COUNT(`stu_id`) as 'stuCnt'  FROM `student` GROUP BY `class_name`";
		HibernateDBUtil op = new HibernateDBUtil(getSession());
		/*
			@SuppressWarnings("unchecked")
			List<CountForInfo> list = (List<CountForInfo>)op.sqlEntityQuery(sql, CountForInfo.class);
			return list;
		*/
//		System.out.println(Arrays.deepToString(op.sqlObjectQuery(sql)));
		
		return (List<Object[]>)op.sqlObjectQuery(sql);
	}
	
	/*
	 * 统计每班不同性别人数
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> getStuCntForSexGroupByClass(){
		String sql = "SELECT `class_name` AS className,`stu_sex` as 'stuSex' ,COUNT(`stu_id`) as 'stuCnt'  FROM `student`  GROUP BY `stu_sex` DESC,`class_name`";
		HibernateDBUtil op = new HibernateDBUtil(getSession());
		return (List<Object[]>)op.sqlObjectQuery(sql);
	}
	
	/*
	 * 统计所有学生各年龄人数
	 */
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> getStuAgeGroupByAge(){
		String sql = "SELECT `stu_age` , COUNT(stu_id) FROM student GROUP BY `stu_age` ";
		HibernateDBUtil op = new HibernateDBUtil(getSession());
		return (List<Object[]>)op.sqlObjectQuery(sql);
	}
	
	/*
	 * 统计所有学生各性别人数
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> getStuCntGroupBySex(){
		String sql = "SELECT `stu_sex` , COUNT(stu_id) FROM student GROUP BY `stu_sex` ";
		HibernateDBUtil op = new HibernateDBUtil(getSession());
		return (List<Object[]>)op.sqlObjectQuery(sql);
	}
	
	
	/*
	 * 学生修改自己的密码
	 */
	@Override
	public boolean updatePswByStuId(String stuPsw , Integer stuId){
		String sql = "UPDATE `student` SET `stu_psw`= ? WHERE `stu_id`= ?";
		HibernateDBUtil op = new HibernateDBUtil(getSession());
		return op.sqlExecute(sql, stuPsw , stuId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
