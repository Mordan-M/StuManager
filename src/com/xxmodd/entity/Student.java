package com.xxmodd.entity;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer stuId;
	private String stuName;
	private String stuSex;
	private Integer stuAge;
	private String stuPhone;
	private String stuAddress;
	private String className;
	private String stuPsw;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String stuName, String stuSex, Integer stuAge,
			String className) {
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
		this.className = className;
	}

	/** full constructor */
	public Student( String stuName, String stuSex, Integer stuAge,
			String stuPhone, String stuAddress, String className, String stuPsw) {
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
		this.stuPhone = stuPhone;
		this.stuAddress = stuAddress;
		this.className = className;
		this.stuPsw = stuPsw;
	}
	
	/* 包含所有参数 */
	public Student(Integer stuId, String stuName, String stuSex, Integer stuAge,
			String stuPhone, String stuAddress, String className, String stuPsw) {
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
		this.stuPhone = stuPhone;
		this.stuAddress = stuAddress;
		this.className = className;
		this.stuPsw = stuPsw;
	}
	
	
	/* 只包含主键 */
	public Student(Integer stuId) {
		super();
		this.stuId = stuId;
	}

	/* 不包含psw  */
	public Student(Integer stuId, String stuName, String stuSex, Integer stuAge,
			String stuPhone, String stuAddress, String className) {
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
		this.stuPhone = stuPhone;
		this.stuAddress = stuAddress;
		this.className = className;
	}
	

	// Property accessors

	public Integer getStuId() {
		return this.stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	

	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuSex() {
		return this.stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public Integer getStuAge() {
		return this.stuAge;
	}

	public void setStuAge(Integer stuAge) {
		this.stuAge = stuAge;
	}

	public String getStuPhone() {
		return this.stuPhone;
	}

	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}

	public String getStuAddress() {
		return this.stuAddress;
	}

	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStuPsw() {
		return this.stuPsw;
	}

	public void setStuPsw(String stuPsw) {
		this.stuPsw = stuPsw;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuSex="
				+ stuSex + ", stuAge=" + stuAge + ", stuPhone=" + stuPhone
				+ ", stuAddress=" + stuAddress + ", className=" + className
				+ "]";
	}



	
	

}