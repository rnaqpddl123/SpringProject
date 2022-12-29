package com.mulcam.SpringProject.session;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserSession {
	private String uid;
	private String uname;
	private int currentBoardPage;
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getCurrentBoardPage() {
		return currentBoardPage;
	}
	public void setCurrentBoardPage(int currentBoardPage) {
		this.currentBoardPage = currentBoardPage;
	}
	
	@Override
	public String toString() {
		return "UserSession [uid=" + uid + ", uname=" + uname + ", currentBoardPage=" + currentBoardPage + "]";
	}
	

}
