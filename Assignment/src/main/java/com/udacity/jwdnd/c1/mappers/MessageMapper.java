package com.udacity.jwdnd.c1.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.udacity.jwdnd.c1.model.ChatMessage;

public interface MessageMapper {

	@Insert("insert into users(username, messagetext)" + "Values(#{messageid}, #{username}, #{messagetext})")
	@Options(useGeneratedKeys = true, keyProperty = "messageid")
	int insertMessage(ChatMessage message);
	
	@Select("select * from messages where messageid = #{messageid}")
	ChatMessage getMessage(int messageid);
	
}
