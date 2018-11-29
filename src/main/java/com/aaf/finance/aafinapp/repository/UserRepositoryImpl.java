package com.aaf.finance.aafinapp.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aaf.finance.aafinapp.model.UserModel;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

	SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public UserModel getUserByUserName(String userName) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Query<UserModel> createQuery = currentSession.createQuery("from UserModel u where u.userName=:userName");
		createQuery.setParameter("userName", userName);
		List<UserModel> list = createQuery.list();
		if(list.size()==0)
			return null;
		return list.get(0);
	}

}
