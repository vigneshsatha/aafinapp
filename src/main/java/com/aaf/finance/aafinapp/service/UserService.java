package com.aaf.finance.aafinapp.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.aaf.finance.aafinapp.model.UserModel;

public interface UserService extends UserDetailsService{
	UserModel getUserByUserName(String userName);
}
