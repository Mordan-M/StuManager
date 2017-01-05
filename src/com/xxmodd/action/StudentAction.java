package com.xxmodd.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xxmodd.entity.CountForInfo;
import com.xxmodd.entity.Student;
import com.xxxmodd.service.StudentService;

/**
 * 类名: StudentAction
 * 描述: 学生action接口
 * @author xxmodd
 * @data 2016-12-30 t下午4:13:55
 */
public class StudentAction extends ActionSupport implements ModelDriven<Student>,SessionAware{

	private static final long serialVersionUID = 1L;
	private StudentService studentService;
	
	
	private Map<String , Object> valueMap = new HashMap<String , Object>();
	private Student student = new Student();
	private Map<String, Object> session;
	private String repeatStuPsw;
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	public Map<String, Object> getValueMap() {
		return valueMap;
	}

	public void setValueMap(Map<String, Object> valueMap) {
		this.valueMap = valueMap; 
	}

	public String getRepeatStuPsw() {
		return repeatStuPsw;
	}

	public void setRepeatStuPsw(String repeatStuPsw) {
		this.repeatStuPsw = repeatStuPsw;
	}

	//获取所有学生信息
	public String getAllStuInfos(){
		List<Student> stuList = studentService.getAllStuInfos();
//		System.out.println(stuList.size());
		valueMap.put("stus", stuList);
		return "valueMap";
	}
	
	//已登入的学生根据学号获取学生信息 
	public String getStuByAct(){
		Integer stuId = (Integer)session.get("student");
		Student stu = studentService.getStuByAct(stuId);
		valueMap.put("stu", stu==null?"还没有该学生的信息哦！":stu);
		return "valueMap";
	}
	
	//更新某个学生的信息(学生更新自己的信息或者管理员修改学生信息)
	public String updateStuByStuId(){
		Integer stuId = (Integer)session.get("student");
		if(stuId!=null&&!stuId.equals(student.getStuId())){
			valueMap.put("msg", "只能该自己的信息哦！");
			return "valueMap";
		}
		Boolean bool = studentService.updateStuByStuId(student);
		valueMap.put("msg", bool);
		return "valueMap";
	}
	
	//学生修改密码
	public String updatePswByStuId(){
		Integer stuId = (Integer)session.get("student");
		if (student.getStuPsw() == null || repeatStuPsw == null
				|| stuId == null || !student.getStuPsw().equals(repeatStuPsw)) {
			valueMap.put("msg", "error!");
		}else{
			Boolean bool = studentService.updatePswByStuId(student.getStuPsw(), stuId);;
			valueMap.put("msg", bool);
			
		}
		return "valueMap";
		
	}
	

	//学生注册或者管理员添加学生
	public String addStu(){
		Boolean bool = studentService.addStu(student);
		valueMap.put("msg", bool);
		return "valueMap";
	}

	//删除某位学生
	public String deleteStu(){
		Boolean bool = studentService.deleteStu(student);
		valueMap.put("msg", bool);
		return "valueMap";
	}

	//获取每班人数
	public String getStuCntForClass(){
		List<Object[]> lists = studentService.getStuCntForClass();
		valueMap.put("info", lists);
		return "valueMap";
	}

	//分班获取每个班不同性别人数
	public String getStuCntForSexByClass(){
		List<Object[]> lists = studentService.getStuCntForSexGroupByClass();
		valueMap.put("info", lists);
		return "valueMap";
	}
	
	//分年龄获取各自的人数
	public String getStuAgeGroupByAge(){
		List<Object[]> lists = studentService.getStuAgeGroupByAge();
		valueMap.put("info", lists);
		return "valueMap";
	}
	
	//分性别获取人数  unuse！
	public String getStuCntGroupBySex(){
		List<Object[]> lists = studentService.getStuCntGroupBySex();
		valueMap.put("info", lists);
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
