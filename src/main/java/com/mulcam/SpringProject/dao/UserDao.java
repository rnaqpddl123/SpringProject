package com.mulcam.SpringProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mulcam.SpringProject.entity.User;

@Mapper
public interface UserDao {
	
	@Insert("insert into users values(#{uid}, #{pwd}, #{uname}, #{email}, #{addr}, #{phoneNum},default, default, default)")
	void insert(User u);
	
	@Select("select * from users where uid=#{uid}")
	User get(String uid);

 	@Select("select * from users")
	List<User> getList();
 	
 	@Select("select * from users where uid=#{uid}")
	User getUser(String uid);

}
