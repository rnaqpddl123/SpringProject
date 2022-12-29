package com.mulcam.SpringProject.service;

import java.util.List;

import com.mulcam.SpringProject.entity.Board;

public interface BoardService {
	
	List<Board> getList(String field, String query, String state, String category, int offset);

	void write(Board b);

	void increaseViewCount(int bid);

	Board getBoardDetail(int bid);

	int getBoardCount(String field, String query);

	List<Board> getLikeList(String uid, int offset);

	int getLikeCount(String uid);

	int getLikeExist(int bid, String uid);

	void likeCountChange(int bid, int love);

	void addLikeBoard(String uid, int bid);

	void removeLikeBoard(String uid, int bid);

}
