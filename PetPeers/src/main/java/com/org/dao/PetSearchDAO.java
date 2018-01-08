package com.org.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.org.model.Pet;
import com.org.model.PetSearch;
import com.org.util.HibernateUtil;

public class PetSearchDAO {

	public List<Pet> searchPets(PetSearch ps) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		/*
		 * String searchQuery =
		 * "from Pet p where p.petType like ? and p.petSize like ? and p.name like ? p.age like ? p.place like ?"
		 * ; Query query = session.createQuery(searchQuery);
		 * 
		 * @SuppressWarnings("unchecked") List<Pet> result = (List<Pet>)
		 * query.setParameter(0, ps.getPetType()+"%") .setParameter(1,
		 * ps.getPetSize()+"%").setParameter(2, ps.getName()+"%")
		 * .setParameter(3, ps.getAge()+"%").setParameter(4,
		 * ps.getPlace()+"%").list();
		 */

		String sqlq = new String("select * from pets where pet_type='"
				+ ps.getPetType() + "' and pet_size='" + ps.getPetSize()
				+ "' and pet_name='" + ps.getName() + "' and pet_age='"
				+ ps.getAge() + "' and pet_place='" + ps.getPlace() + "'");
		SQLQuery query = session.createSQLQuery(sqlq);
		query.addEntity(Pet.class);
		List<Pet> p = query.list();
		return p;
	}
}
