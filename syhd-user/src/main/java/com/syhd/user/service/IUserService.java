package com.syhd.user.service;


import com.syhd.user.dto.UserDto;
import com.syhd.user.eto.UserEto;
import com.syhd.user.exception.DataException;
import com.syhd.user.model.UserEbo;

public interface IUserService {

	// 通过uid获取用户
	public UserDto getUserById(String uid) throws DataException;

	// 用户注册
	public UserEbo regUser(UserEto user) throws DataException;
}
