package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.org.model.Pet;
import com.org.util.HibernateUtil;

/**
 * DAO class for pets table.
 * */
public class PetDAO {
	public List<Pet> fetchAll0ld() {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Pet> result = new ArrayList<Pet>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "PETPEERSDB",
					"petpeersdb");
			stmt = conn
					.prepareStatement("select id,pet_name,pet_age,pet_place from pets");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Pet p = new Pet();
				p.setId(rs.getLong(1));
				p.setName(rs.getString(2));
				p.setAge(rs.getInt(3));
				p.setPlace(rs.getString(4));
				result.add(p);
			}
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

	}

	public List<Pet> fetchAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Pet> petlist = session.createQuery("from Pet p").list();
		return petlist;
	}

	public List<Pet> findById(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Pet> petlist = session.createQuery("from Pet p where p.id=" + id)
				.list();
		return petlist;
	}

	public void savePetOld(Pet pet) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "PETPEERSDB",
					"petpeersdb");
			stmt = conn.prepareStatement("insert into PETS values(?,?,?,?)");
			stmt.setLong(1, pet.getId());
			stmt.setString(2, pet.getName());
			stmt.setInt(3, pet.getAge());
			stmt.setString(4, pet.getPlace());
			stmt.executeUpdate();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void savePet(Pet pet) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(pet);
		session.getTransaction().commit();
		session.close();
	}
}
