package com.IBM.fsd.second_maven_demo.Dao;

import java.util.List;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.*;

import com.IBM.fsd.second_maven_demo.factory.DatabaseSession;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data

public class PetServiceImpl implements PetDao {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "email")
	private String email;

	public PetServiceImpl() {
		super();
	}

	public PetServiceImpl(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	public void DeletePet(int id) {
		SessionFactory factory = DatabaseSession.SessionMethod();
		
		try {								
			
			// now get a new session and start transaction
			Session session = factory.openSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + id);
			
			PetServiceImpl myPet = session.get(PetServiceImpl.class, id);
			
			// delete the student
			 System.out.println("Deleting student: " + id);
			 session.delete(id);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
	
	public void UpdatePet(int id,String fn, String ln, String em) {
		SessionFactory factory = DatabaseSession.SessionMethod();
		try {					
			Session session = factory.openSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + id);
			
			PetServiceImpl myPet = session.get(PetServiceImpl.class,id);
			
			System.out.println("Updating pet...");
			myPet.setFirstName(fn);
			myPet.setLastName(ln);
			myPet.setEmail(em);
			session.merge(myPet);
			
			// commit the transaction
			session.getTransaction().commit();

						
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	public void getAllPets() {
		SessionFactory factory = DatabaseSession.SessionMethod();
		Session session = factory.openSession();
		session.beginTransaction();
		
		// query students
		List<PetServiceImpl> thePets = session.createQuery("from Pet").getResultList();
		
		// display the students
		displayStudents(thePets);
	}
	
	private static void displayStudents(List<PetServiceImpl> thePets) {
		for (PetServiceImpl tempPet : thePets) {
			System.out.println(tempPet);
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}