package com.codepow.shemitonline.dao;

import org.hibernate.Session;
<<<<<<< HEAD
import org.hibernate.SessionFactory;
import com.codepow.shemitonline.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
@Transactional
@Repository
public class AccountDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public Account findAccount(String userName) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.find(Account.class, userName);
    }
 
=======
import org.springframework.transaction.annotation.Transactional;

import com.codepow.shemitonline.entity.Account;

@Transactional
public class AccountDAO {
  
	public Account findAccount(String userName) {
		Session session=this.sessionFactory.getCurrentSessioin();
		return session.find(Account.class,userName);
	}
>>>>>>> f667d88dd5d07c32da434eb67194b3407da3e50d
}

  