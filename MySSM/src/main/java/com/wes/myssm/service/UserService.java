package com.wes.myssm.service;

import com.wes.myssm.bean.User;

public interface UserService {
	
	public User checkIdRole(String id, String pwd);
	public String createId(String id);
	public boolean creatAccount(User user);
}
