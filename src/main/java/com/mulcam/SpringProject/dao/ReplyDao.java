package com.mulcam.SpringProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mulcam.SpringProject.entity.Reply;

@Mapper
public interface ReplyDao {

	@Select("SELECT r.rid, r.content, r.regDate, r.isMine, r.uid, r.bid, u.uname "
			+ " from reply as r"
			+ "	join users as u"
			+ "	on r.uid=u.uid"
			+ "	where r.bid=#{bid}")
	List<Reply> replyList(int bid);
	
	@Insert("INSERT INTO reply VALUES (default, #{content}, default, #{isMine}, #{uid}, #{bid})")
	void insertReply(Reply reply);

}
