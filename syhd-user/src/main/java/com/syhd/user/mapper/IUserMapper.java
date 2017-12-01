package com.syhd.user.mapper;

import com.syhd.user.dto.UserDto;
import com.syhd.user.exception.DataException;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public interface IUserMapper {

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            传入userEbo对象
	 * @throws DataException
	 */
	//public void addUser(UserEbo user) throws DataException;

	/**
	 * 
	 * @param id
	 *            t_user表用戶id
	 * @return
	 * @throws DataException
	 */
	public UserDto getUserById(@Param("id") String id) throws DataException;
}
