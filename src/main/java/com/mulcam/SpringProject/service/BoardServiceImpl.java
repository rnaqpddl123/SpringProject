package com.mulcam.SpringProject.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.dao.BoardDao;
import com.mulcam.SpringProject.entity.Board;
import com.mulcam.SpringProject.session.UserSession;

@Service
public class BoardServiceImpl implements BoardService {
	@Resource
	private UserSession userSession;
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> getList() {
		List<Board> list = boardDao.getlist();
		return list;
	}

	@Override
	public void write(Board b) {
		boardDao.write(b);
	}
	
}
