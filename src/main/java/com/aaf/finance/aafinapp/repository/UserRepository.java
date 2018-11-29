package com.aaf.finance.aafinapp.repository;

import com.aaf.finance.aafinapp.model.UserModel;

public interface UserRepository {
	UserModel getUserByUserName(String userName);
}
