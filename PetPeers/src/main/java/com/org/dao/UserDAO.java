package com.org.dao;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.org.model.User;
import com.org.util.HibernateUtil;

public class UserDAO {

	public boolean checkUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		boolean flag = true;
		@SuppressWarnings("unchecked")
		List<User> petlist = session.createQuery("from User u").list();
		Iterator<User> it = petlist.iterator();
		while (it.hasNext()) {
			if (user.getLoginName().equals(it.next().getLoginName())) {
				flag = false;
			}
		}
		return flag;
	}

	public void saveUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

	}

	public List validateLogin(String userName, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String flag = "false";
		long id=0;
		List result =new ArrayList<String>();
		String uname="";
		@SuppressWarnings("unchecked")
		List<User> petlist = session.createQuery("from User u").list();
		Iterator<User> it = petlist.iterator();
		while (it.hasNext()) {
			User u = it.next();
			if (userName.equalsIgnoreCase(u.getLoginName())
					&& password.equalsIgnoreCase(u.getLoginpwd())) {
				uname=u.getUserName();
				flag = "true";
				id=u.getUserId();
			}
		}
		result.add(flag);
		result.add(uname);
		result.add(id);
		return result;
	}

}
