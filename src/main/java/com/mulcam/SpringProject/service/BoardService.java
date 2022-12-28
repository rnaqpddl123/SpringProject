package com.mulcam.SpringProject.service;

import java.util.List;

import com.mulcam.SpringProject.entity.Board;

public interface BoardService {
	
	List<Board> getList();

	void write(Board b);

}
