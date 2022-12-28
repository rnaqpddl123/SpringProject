package com.mulcam.SpringProject.entity;

import java.time.LocalDate;

public class Board {
	private int bid;
	private String uid;
	private String title;
	private String content;
	private LocalDate modTime;
	private String category;
	private int price;
	private String state;
	private int viewCount;
	private int replyCount;
	private int likeCount;
	private int isDeleted;
	private String files;
	private String uname;
	
	public Board() {}
	public Board(int bid, String uid, String title, String content, LocalDate modTime, String category, int price,
			String state, int viewCount, int replyCount, int likeCount, int isDeleted, String files, String uname) {
		super();
		this.bid = bid;
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.modTime = modTime;
		this.category = category;
		this.price = price;
		this.state = state;
		this.viewCount = viewCount;
		this.replyCount = replyCount;
		this.likeCount = likeCount;
		this.isDeleted = isDeleted;
		this.files = files;
		this.uname = uname;
	}
	
	public Board(String uid, String title, String content, String category, int price, String state, String files) {
		super();
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.category = category;
		this.price = price;
		this.state = state;
		this.files = files;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDate getModTime() {
		return modTime;
	}
	public void setModTime(LocalDate modTime) {
		this.modTime = modTime;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	

}
