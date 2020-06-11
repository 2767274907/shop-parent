package com.t248.member.mapper;

import com.t248.member.mapper.entity.UserDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	@Insert("INSERT INTO `meite_user` VALUES (null,#{mobile}, #{email}, #{password}, #{userName}, null, null, null, '1', null, null, null);")
	int register(UserDo userDo);

	@Select("SELECT * FROM meite_user WHERE MOBILE=#{mobile};")
	UserDo existMobile(@Param("mobile") String mobile);
}
