package cn.com.objcet.api.service.impl;

import org.springframework.stereotype.Service;

import cn.com.objcet.api.service.IUserService;
import cn.com.objcet.api.service.config.User;

@Service
public class UserServiceImpl implements IUserService {

	@Override
	public User findUserById(String userId) {
		User use = new User(userId, userId, userId);
		return use;
	}

}
