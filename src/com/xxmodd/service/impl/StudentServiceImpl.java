package com.xxmodd.service.impl;

import java.util.List;
import org.hibernate.classic.Validatable;

import com.xxmodd.dao.StudentDao;
import com.xxmodd.entity.CountForInfo;
import com.xxmodd.entity.Student;
import com.xxmodd.service.StudentService;
import com.xxmodd.util.MD5Util;
import com.xxmodd.util.ValidateUtil;

/**
 * 类名: StudentServiceImpl
 * 描述: 学生信息业务实现
 * @author xxmodd
 * @data 2016-12-26 t下午4:29:15
 */
public class StudentServiceImpl implements StudentService {
	//盐
	private final static String salt = "tFxSJAS2PW(SQUyw1i7l9C_1gr&Y~Zi#RLU*^m8M%yF6^>(kdDON$VZeoDhT)~9G";
	
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<Student> getAllStuInfos() {
		return studentDao.getAllStuInfos();
	}

	@Override
	public Student getStuByAct(int stuId) {
		return studentDao.getStuByAct(stuId);
	}

	@Override
	public boolean updateStuByStuId(Student stu) {
		//表单校验
		if (!ValidateUtil.isValidStuId(String.valueOf(stu.getStuId()))
				|| !ValidateUtil.isValidSex(stu.getStuSex())
				|| !ValidateUtil.isValidPhone(stu.getStuPhone())) {
			return false;
		}
		// 密码MD5加盐加密
		stu.setStuPsw(MD5Util.MD5(salt + stu.getStuPsw()));
		return studentDao.updateStuByStuId(stu);
	}

	@Override
	public boolean addStu(Student stu) {
		//表单校验
		if (!ValidateUtil.isValidStuId(String.valueOf(stu.getStuId()))
				|| !ValidateUtil.isValidPass(stu.getStuPsw())
				|| !ValidateUtil.isValidSex(stu.getStuSex())
				|| !ValidateUtil.isValidPhone(stu.getStuPhone())) {
			return false;
		}
		
		//密码MD5加盐加密
		stu.setStuPsw(MD5Util.MD5(salt + stu.getStuPsw()));
		return studentDao.addStu(stu);
	}

	@Override
	public boolean deleteStu(Student stu) {
		return studentDao.deleteStu(stu);
	}

	@Override
	public List<Object[]> getStuCntForClass() {
		return studentDao.getStuCntForClass();
	}

	@Override
	public List<Object[]> getStuCntForSexGroupByClass() {
		return studentDao.getStuCntForSexGroupByClass();
	}

	@Override
	public List<Object[]> getStuAgeGroupByAge() {
		return studentDao.getStuAgeGroupByAge();
	}

	@Override
	public List<Object[]> getStuCntGroupBySex() {
		return studentDao.getStuCntGroupBySex();
	}

	@Override
	public boolean updatePswByStuId(String stuPsw, Integer stuId) {
		// 密码MD5加盐加密
		stuPsw = MD5Util.MD5(salt + stuPsw);
		return studentDao.updatePswByStuId(stuPsw, stuId);
	}

}
