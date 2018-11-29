package com.aaf.finance.aafinapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aaf.finance.aafinapp.model.UserDetailsModel;
import com.aaf.finance.aafinapp.model.UserModel;
import com.aaf.finance.aafinapp.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserModel getUserByUserName(String userName) {
		return userRepository.getUserByUserName(userName);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userByUserName = this.getUserByUserName(username);
		UserDetailsModel model = new UserDetailsModel(userByUserName);
		return model;
	}

}
