package com.org.pets.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.org.dao.PetDAO;
import com.org.model.Pet;

/**
 * Test case for PetDAO. It uses plain jUnit framework without any supplementary
 * frameworks like spring or testNg.
 * 
 * @since Jul 2014
 * @version 0.0.1
 * */
public class PetDaoTest {

	// Declaration of PetDAO object
	private PetDAO petDao;

	/**
	 * Setup to init the object and its dependents
	 * 
	 * @Before to indicate junit on setting up all the required dependents.
	 * */
	@Before
	public void setUp() {
		// Initializing the object
		petDao = new PetDAO();
	}

	/**
	 * Test method to test findAll() of PetDAO
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 * */
	@Test
	public void testFindAll() {

		// retrieve the list of pets
		List<Pet> petList = petDao.fetchAll();

		//
		// Not null check on the list object
		//
		assertNotNull("Pet list is null", petList);

		System.out.println("The items in the list are :" + petList.size());

	}

	/**
	 * Test method to savePet() of PetDAO
	 * 
	 * */
	@Test
	public void testSavePet() {

		// Initializing the pet object
		Pet pet = new Pet();
		
		// Getting the declared fields of Pet class
		Field[] petFields = pet.getClass().getDeclaredFields();

		if(petFields != null && petFields.length <= 0){
			assertTrue(false);
		}
		
		try {
			for (Field field : petFields) {
				// If the field isn't accessible the make it one
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}

				if (field.getName().equals("age")) {
					field.set(pet, 2);
				} else if(field.getName().equals("name") || field.getName().equals("place")) {
					field.set(pet, "Test value");
				}

			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// save pet object
		petDao.savePet(pet);

	}
}
