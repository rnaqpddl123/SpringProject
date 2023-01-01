package com.mulcam.SpringProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mulcam.SpringProject.entity.User;

@Mapper
public interface UserDao {
	
	@Insert("insert into users values(#{uid}, #{pwd}, #{uname}, #{email}, #{addr}, #{phoneNum},default, default, default)")
	void insert(User u);
	
	@Select("select * from users where uid=#{uid}")
	User get(String uid);

 	@Select("select * from users where isDeleted LIKE #{isDeleted}")
	List<User> getList(String isDeleted);
 	
 	@Select("select * from users where uid=#{uid}")
	User getUser(String uid);
 	
 	@Update("update users set isDeleted=1 where uid=#{uid}")
 	void withdraw(String uid);
 	
 	
 	@Delete("delete FROM users WHERE uid=#{uid} and isDeleted=1")
	void deleteUser(String uid);

 	@Update("update users set pwd=#{pwd}, uname=#{uname}, email=#{email}, addr=#{addr}, phoneNum=#{phoneNum} where uid=#{uid}")
	void updateUser(User u);

}
