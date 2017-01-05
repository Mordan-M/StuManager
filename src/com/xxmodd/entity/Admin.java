package com.xxmodd.entity;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Integer admId;
	private String admPsw;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(String admPsw) {
		this.admPsw = admPsw;
	}
	
	//含所有参数，包含主键

	// Property accessors

	public Integer getAdmId() {
		return this.admId;
	}

	public Admin(Integer admId, String admPsw) {
		super();
		this.admId = admId;
		this.admPsw = admPsw;
	}

	public void setAdmId(Integer admId) {
		this.admId = admId;
	}

	public String getAdmPsw() {
		return this.admPsw;
	}

	public void setAdmPsw(String admPsw) {
		this.admPsw = admPsw;
	}

}