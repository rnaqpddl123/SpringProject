package com.mulcam.SpringProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mulcam.SpringProject.entity.Board;

@Mapper
public interface BoardDao {
	
	@Select("select * from board where isDeleted=0")
	List<Board> getlist();

	@Insert("insert into board values(default, #{uid}, #{title}, #{content}, default, default, default, default, #{files}, #{category}, #{price}, #{state}, default)")
	void write(Board b);

}
