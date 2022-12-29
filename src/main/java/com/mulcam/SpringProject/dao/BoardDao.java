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
			+ "	ORDER BY bid DESC"
			+ "	LIMIT 10"
			+ "	OFFSET #{offset}")
	List<Board> getlist(String field, String query, String state, String category, int offset);
	
	@Select("SELECT b.bid, b.uid, b.title, b.modtime, b.files, b.category, b.price, b.state,"
			+ "	b.viewCount, b.replycount, u.uname"
			+ " 	FROM likeproduct AS l"
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
	
	@Select("SELECT COUNT(b.bid) FROM likeproduct AS l "
			+ " JOIN board AS b ON b.bid=l.bid "
			+ " JOIN users AS u ON u.uid=l.uid"
			+ "	WHERE l.uid = #{uid}")
	int getLikeCount(String uid);
	
	@Select("SELECT COUNT(*) FROM likeproduct WHERE bid=#{bid} AND uid=#{uid}") 
	int getLikeExist(int bid, String uid);
	
	@Update("UPDATE board SET likeCount=likeCount+#{love} WHERE bid=#{bid};")
	void likeCountChange(int bid, int love);

	@Insert("INSERT INTO likeproduct VALUES (#{uid}, #{bid})")
	void addLikeBoard(String uid, int bid);

	@Delete("DELETE FROM likeproduct WHERE uid=#{uid} AND bid=#{bid};")
	void removeLikeBoard(String uid, int bid);

	@Update("UPDATE board SET replyCount=replyCount+1  WHERE  bid=#{bid};")
	void increaseCount(int bid, String field);

	
	
	
	

}
