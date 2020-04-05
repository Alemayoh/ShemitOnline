package com.codepow.shemitonline.dao;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import com.codepow.shemitonline.entity.Account;

@Transactional
public class AccountDAO {
  
	public Account findAccount(String userName) {
		Session session=this.sessionFactory.getCurrentSessioin();
		return session.find(Account.class,userName);
	}
}
  