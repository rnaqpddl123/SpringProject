package com.mulcam.SpringProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
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
			+ " AND b.uid LIKE #{uid}"
			+ "	ORDER BY bid DESC"
			+ "	LIMIT 10"
			+ "	OFFSET #{offset}")
	List<Board> getlist(String uid, String field, String query, String state, String category, int offset);
	
	@Select("SELECT b.bid, b.uid, b.title, b.modtime, b.files, b.category, b.price, b.state,"
			+ "	b.viewCount, b.replycount, b.likeCount, u.uname"
			+ " FROM likeproduct AS l"
			+ "	JOIN board AS b"
			+ "	ON b.bid=l.bid"
			+ "	JOIN users AS u"
			+ "	ON u.uid=b.uid"
			+ "	WHERE l.uid = #{uid}"
			+ "	LIMIT 10"
			+ "	OFFSET #{offset};")
	List<Board> getLikeList(String uid, int offset);
	
	@Insert("insert into board values(default, #{uid}, #{title}, #{content}, default, default, default, default, #{files}, #{category}, #{price}, #{state}, default)")
	void write(Board b);
	
	@Select("SELECT b.bid, b.uid, b.title, b.content, b.modtime, b.category, b.price, b.state,"
			+ "b.viewCount, b.replycount, b.likeCount,b.files, u.uname FROM board AS b"
			+ "	JOIN users AS u"
			+ "	ON b.uid=u.uid"
			+ "	WHERE b.bid=#{bid}")
	Board getBoardDetail(int bid);
	
	@Select("SELECT COUNT(bid) FROM board AS b JOIN users as u ON b.uid=u.uid"
			+ "	WHERE b.isDeleted=0 AND ${field} LIKE #{query}")
	int getBoardCount(String field, String query);
	
	@Select("SELECT COUNT(b.bid) FROM likeproduct AS l "
			+ " JOIN board AS b ON b.bid=l.bid "
			+ " JOIN users AS u ON u.uid=l.uid"
			+ "	WHERE l.uid = #{uid}")
	int getLikeCount(String uid);
	
	@Select("SELECT COUNT(*) FROM likeproduct WHERE bid=#{bid} AND uid=#{uid}") 
	int getLikeExist(int bid, String uid);

	@Insert("INSERT INTO likeproduct VALUES (#{uid}, #{bid})")
	void addLikeBoard(String uid, int bid);

	@Delete("DELETE FROM likeproduct WHERE uid=#{uid} AND bid=#{bid};")
	void removeLikeBoard(String uid, int bid);
	
	@Update("UPDATE board SET ${field}=${field}+#{count} where bid=#{bid}")
	void increaseCount(int bid, int count, String field);

	@Update("UPDATE board set isDeleted=1 where bid=#{bid}")
	void deleteBoard(int bid);
	
	@Update("UPDATE board set title=#{title}, content=#{content}, category=#{category}, price=#{price}, state=#{state} where bid=#{bid}")
	void updateBoard(Board b);

	
	
	
	

}
