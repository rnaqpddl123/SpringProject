package com.mulcam.SpringProject.service;

import java.util.List;

import com.mulcam.SpringProject.entity.Board;

public interface BoardService {
	
	List<Board> getList(String field, String query, String state, String category, int offset);

	void write(Board b);

	void increaseViewCount(int bid);

	Board getBoardDetail(int bid);

	int getBoardCount(String field, String query);

}
