package com.mulcam.SpringProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mulcam.SpringProject.entity.Board;

@Mapper
public interface BoardDao {
	
	@Select("SELECT b.bid, b.uid, b.title, b.modtime, b.files, b.category, b.price, b.state,"
			+ " b.viewCount, b.replycount, u.uname FROM board AS b"
			+ "	JOIN users AS u"
			+ "	ON b.uid=u.uid"
			+ "	WHERE b.isDeleted=0"
			+ " AND ${field} LIKE #{query}"
			+ " AND state LIKE #{state}"
			+ " AND category LIKE #{category}"
			+ "	ORDER BY bid DESC"
			+ "	LIMIT 10"
			+ "	OFFSET #{offset}")
	List<Board> getlist(String field, String query, String state, String category, int offset);

	@Insert("insert into board values(default, #{uid}, #{title}, #{content}, default, default, default, default, #{files}, #{category}, #{price}, #{state}, default)")
	void write(Board b);

	@Update("UPDATE board SET viewCount=viewCount+1 where bid=#{bid}")
	void increaseViewCount(int bid);
	
	@Select("SELECT b.bid, b.uid, b.title, b.content, b.modtime, b.category, b.price, b.state,"
			+ "b.viewCount, b.replycount, b.likeCount,b.files, u.uname FROM board AS b"
			+ "	JOIN users AS u"
			+ "	ON b.uid=u.uid"
			+ "	WHERE b.bid=#{bid}")
	Board getBoardDetail(int bid);
	
	@Select("SELECT COUNT(bid) FROM board AS b JOIN users as u ON b.uid=u.uid"
			+ "	WHERE b.isDeleted=0 AND ${field} LIKE #{query}")
	int getBoardCount(String field, String query);
	
	

}
