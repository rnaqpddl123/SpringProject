package com.mulcam.SpringProject.entity;

import java.time.LocalDateTime;

public class Reply {
	private int rid;
	private String uname;
	private String content;
	private LocalDateTime regDate;
	private int isMine;
	private String uid;
	private int bid;
	
	Reply() {}
	public Reply(int rid, String uname, String content, LocalDateTime regDate, int isMine, String uid, int bid) {
		super();
		this.rid = rid;
		this.uname = uname;
		this.content = content;
		this.regDate = regDate;
		this.isMine = isMine;
		this.uid = uid;
		this.bid = bid;
	}

	public Reply(int rid, String content) {
		super();
		this.rid = rid;
		this.content = content;
	}
	
	public Reply(String content, int isMine, String uid, int bid) {
		super();
		this.content = content;
		this.isMine = isMine;
		this.uid = uid;
		this.bid = bid;
	}
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setIsMine(int isMine) {
		this.isMine = isMine;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	public int getIsMine() {
		return isMine;
	}
	public void setInMine(int inMine) {
		this.isMine = inMine;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
}