package com.mulcam.SpringProject.service;

import java.util.List;

import com.mulcam.SpringProject.entity.Board;
import com.mulcam.SpringProject.entity.Reply;

public interface BoardService {
	
	List<Board> getList(String field, String query, String state, String category, int offset);

	void write(Board b);

	void increaseViewCount(int bid, int count);

	Board getBoardDetail(int bid);

	int getBoardCount(String field, String query);

	List<Board> getLikeList(String uid, int offset);

	int getLikeCount(String uid);

	int getLikeExist(int bid, String uid);

	void likeCountChange(int bid, int love);

	void addLikeBoard(String uid, int bid);

	void removeLikeBoard(String uid, int bid);

	void insertReply(Reply reply);

	void increaseReplyCount(int bid, int count);

	List<Reply> replyList(int bid);

	void updateReply(Reply reply);

	void deleteReply(int rid);

	void deleteBoard(int bid);

	void updateBoard(Board b);

	List<Board> getMyList(String uid, int offset);

}
