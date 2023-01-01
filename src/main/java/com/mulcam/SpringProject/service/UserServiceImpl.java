package com.mulcam.SpringProject.service;


import java.util.List;

import javax.annotation.Resource;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.dao.UserDao;
import com.mulcam.SpringProject.entity.User;
import com.mulcam.SpringProject.session.UserSession;


@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserSession userSession;
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getList() {
		String isDeleted_ = "%%";
		List<User> list = userDao.getList(isDeleted_);
		return list;
	}
	
	@Override
	public List<User> getWithdrawList(String isDeleted) {
		String isDeleted_ = "%" + isDeleted + "%";
		List<User> list = userDao.getList(isDeleted_);
		return list;
	}

	@Override
	public void register(User u) {
		String cryptedPwd = BCrypt.hashpw(u.getPwd(), BCrypt.gensalt());
		u.setPwd(cryptedPwd);
		userDao.insert(u);
	}

	@Override
	public int login(String uid, String pwd) {
		try {
			User u = userDao.get(uid);
			
			if (u.getUid() != null) {	// uid가 존재
				if (BCrypt.checkpw(pwd, u.getPwd())) {		// 비밀번호 같은지 비교(암호화해서)
					// 로그인을 했을때 session에 정보 저장
					userSession.setUid(u.getUid());
					userSession.setUname(u.getUname());
					return UserService.CORRECT_LOGIN;
				}
				else {		
					// 비밀번호가 틀림, 로그인페이지로 다시이동
					return UserService.WRONG_PASSWORD;
				}
			} 	
		} catch(Exception e) {
			// uid가 없음
		}
		return UserService.UID_NOT_EXIST;
	}

	@Override
	public User getUser(String uid) {
		User user = userDao.getUser(uid);
		return user;
	}

	@Override
	public void deleteUser(String uid) {
		userDao.deleteUser(uid);
	}

	@Override
	public void updateUser(User u) {
		String cryptedPwd = BCrypt.hashpw(u.getPwd(), BCrypt.gensalt());
		u.setPwd(cryptedPwd);
		userDao.updateUser(u);
	}

	@Override
	public int withdrawConfirm(String uid, String pwd) {
		try {
			User u = userDao.get(uid);

			if (BCrypt.checkpw(pwd, u.getPwd())) {		// 비밀번호 같은지 비교(암호화해서)
				// 회원탈퇴 성공
				return UserService.CORRECT_LOGIN;
			}
			else {		
				// 회원탈퇴 실패
				return UserService.WRONG_PASSWORD;
			}
		} catch(Exception e) {
			// uid가 없음
		}
		return UserService.UID_NOT_EXIST;
	}

	@Override
	public void withdraw(String uid) {
		userDao.withdraw(uid);
	}

}
