package com.codepow.shemitonline.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Accounts")
public class Account {
     
	   private static final long serialVersionUID=-2054386655979281969L;
	   
	   public static final String ROLE_MANAGER="MANAGER";
	   public static final String ROLE_EMPLOYEE="EMPLOYEE";
}
