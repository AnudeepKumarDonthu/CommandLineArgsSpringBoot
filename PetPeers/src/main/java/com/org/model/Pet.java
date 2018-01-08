package com.org.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pets")
public class Pet implements Serializable {

	private static final long serialVersionUID = 1L;
	long id;
	String name;
	int age;
	String place;
	String petType;
	int avlQty;
	String petSex;
	String petSize;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "pet_name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pet_age", nullable = false)
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(name = "pet_place", nullable = false)
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Column(name = "pet_type", nullable = false)
	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	@Column(name = "avl_qty", nullable = false)
	public int getAvlQty() {
		return avlQty;
	}

	public void setAvlQty(int avlQty) {
		this.avlQty = avlQty;
	}

	@Column(name = "pet_sex", nullable = false)
	public String getPetSex() {
		return petSex;
	}

	public void setPetSex(String petSex) {
		this.petSex = petSex;
	}
	
	@Column(name = "pet_size", nullable = false)
	public String getPetSize() {
		return petSize;
	}

	public void setPetSize(String petSize) {
		this.petSize = petSize;
	}

}
