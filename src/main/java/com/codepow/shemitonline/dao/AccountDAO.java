package com.codepow.shemitonline.dao;



@Transactional
public class AccountDAO {
  
	public Account findAccount(String userName) {
		Session session=this.sessionFactory.getCurrentSessioin();
		return session.find(Account.class,userName);
	}
}
  