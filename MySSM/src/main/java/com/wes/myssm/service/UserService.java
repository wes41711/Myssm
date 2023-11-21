package com.wes.myssm.service;

import com.wes.myssm.bean.User;

public interface UserService {
	
	Object checkId(String id, String pwd);
	
	String createId(String id);
	
	boolean creatAccount(User user);
}
