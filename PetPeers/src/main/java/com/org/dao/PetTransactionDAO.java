package com.org.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.org.model.Pet;
import com.org.util.HibernateUtil;

public class PetTransactionDAO {

	public List<Pet> buyPet(long primaryKey) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		String sqlq = new String("select * from pets where ID='" + primaryKey
				+ "'");
		SQLQuery query = session.createSQLQuery(sqlq);
		query.addEntity(Pet.class);
		List<Pet> p = query.list();
		return p;
	}

	public boolean saveOrder(Object tranobj, long pid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		boolean flag = false;
		List<Pet> result = buyPet(pid);
		if (result.get(0).getAvlQty() != 0) {
			session.save("buypojo", tranobj);
			updateData(pid);
			flag = true;
		}
		session.getTransaction().commit();
		session.close();
		return flag;
	}

	public void updateData(long pid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Pet p = (Pet) session.get(Pet.class, pid);
		p.setAvlQty(p.getAvlQty() - 1);
		session.update(p);
		session.getTransaction().commit();
		session.close();

	}

}
