package com.IBM.fsd.second_maven_demo.Dao;

public interface PetDao {
	public void DeletePet(int id);
	public void UpdatePet(int id,String fn, String ln, String em);
	public void getAllPets();
}