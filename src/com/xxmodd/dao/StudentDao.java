package com.xxmodd.dao;

import java.util.List;

import com.xxmodd.entity.CountForInfo;
import com.xxmodd.entity.Student;

/**
 * 类名: StudentDao
 * 描述: 学生数据操作接口
 * @author xxmodd
 * @data 2016-12-26 t下午4:28:56
 */
public interface StudentDao {
	
	
	public List<Student> getAllStuInfos();

	public Student getStuByAct(int stuId);

	public boolean updateStuByStuId(Student stu);

	public boolean addStu(Student stu);

	public boolean deleteStu(Student stu);

	public List<Object[]> getStuCntForClass();

	public List<Object[]> getStuCntForSexGroupByClass();

	public List<Object[]> getStuAgeGroupByAge();

	public List<Object[]> getStuCntGroupBySex();

	public boolean updatePswByStuId(String stuPsw, Integer stuId);
}
