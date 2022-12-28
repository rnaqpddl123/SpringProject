package com.mulcam.SpringProject.entity;

import java.time.LocalDate;

public class User {
	private String uid;
	private String pwd;
	private String uname;
	private String email;
	private String addr;
	private String phoneNum;
	private int isDeleted;
	private LocalDate regDate;
	private LocalDate delDate;
	
	public User() {}
	public User(String uid, String pwd, String uname, String email, String addr, String phoneNum, int isDeleted,
			LocalDate regDate, LocalDate delDate) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.email = email;
		this.addr = addr;
		this.phoneNum = phoneNum;
		this.isDeleted = isDeleted;
		this.regDate = regDate;
		this.delDate = delDate;
	}
	public User(String uid, String pwd, String uname, String email, String addr, String phoneNum) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.email = email;
		this.addr = addr;
		this.phoneNum = phoneNum;
	}
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public LocalDate getDelDate() {
		return delDate;
	}

	public void setDelDate(LocalDate delDate) {
		this.delDate = delDate;
	}
	
	
	
	

}
