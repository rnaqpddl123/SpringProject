package com.mulcam.SpringProject.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.SpringProject.dao.BoardDao;
import com.mulcam.SpringProject.dao.ReplyDao;
import com.mulcam.SpringProject.entity.Board;
import com.mulcam.SpringProject.entity.Reply;
import com.mulcam.SpringProject.session.UserSession;

@Service
public class BoardServiceImpl implements BoardService {
	@Resource
	private UserSession userSession;
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private ReplyDao replyDao;
	
	@Override
	public List<Board> getList(String field, String query, String state, String category, int offset) {
		List<Board> list = boardDao.getlist(field, query,state, category,offset);
		return list;
	}
	
	@Override
	public List<Board> getLikeList(String uid, int offset) {
		List<Board> list = boardDao.getLikeList(uid,offset);
		return list;
	}

	@Override
	public void write(Board b) {
		boardDao.write(b);
	}
	
	@Override
	public Board getBoardDetail(int bid) {
		Board board = boardDao.getBoardDetail(bid);
		return board;
	}

	@Override
	public int getBoardCount(String field, String query) {
		int count = boardDao.getBoardCount(field,query);
		return count;
	}
	
	@Override
	public int getLikeCount(String uid) {
		int count = boardDao.getLikeCount(uid);
		return count;
	}

	@Override
	public int getLikeExist(int bid, String uid) {
		int exist = boardDao.getLikeExist(bid, uid);
		return exist;
	}

	@Override
	public void addLikeBoard(String uid, int bid) {
		boardDao.addLikeBoard(uid,bid);
		
	}

	@Override
	public void removeLikeBoard(String uid, int bid) {
		boardDao.removeLikeBoard(uid,bid);
	}

	@Override
	public void insertReply(Reply reply) {
		replyDao.insertReply(reply);
	}

	@Override
	public void likeCountChange(int bid, int love) {
		String field = "likeCount";
		boardDao.increaseCount(bid, love, field);
	}
	
	@Override
	public void increaseReplyCount(int bid, int count) {
		String field = "replyCount";
		boardDao.increaseCount(bid, count, field);
	}
	
	@Override
	public void increaseViewCount(int bid, int count) {
		String field = "viewCount";
		boardDao.increaseCount(bid, count, field);
	}

	@Override
	public List<Reply> replyList(int bid) {
		List<Reply>	list = replyDao.replyList(bid);
		return list;
	}

	@Override
	public void updateReply(Reply reply) {
		replyDao.updateReply(reply);
	}

	@Override
	public void deleteReply(int rid) {
		replyDao.deleteReply(rid);
	}

}
