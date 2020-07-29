package com.udacity.jwdnd.c1.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.udacity.jwdnd.c1.model.Users;

@Mapper
public interface UserMapper {
	
	@Insert("insert into users(username, salt, password, firstname, lastname)"+
			"Values(#{usernmae}, #{salt}, #{password}, #{firstname}, #{lastname})")
	@Options(useGeneratedKeys = true, keyProperty = "userid")
	int insertUser(Users user);
	
	@Select("SELECT * FROM USERS WHERE username = #{username}")
    Users getUser(String username);
}
