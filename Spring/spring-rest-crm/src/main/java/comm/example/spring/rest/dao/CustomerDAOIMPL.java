package comm.example.spring.rest.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import comm.example.spring.rest.Customer;

@Repository
public class CustomerDAOIMPL implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	@PostConstruct
	public void init() {
		session = sessionFactory.openSession();
	}

	@SuppressWarnings("unchecked")
	
	public List<Customer> getAllCustomer() {
		try {
			Query query=session.createQuery("from Customer",Customer.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Customer getCustomer(int id) {
		Customer customer = session.find(Customer.class, id);
		return customer;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Customer> updateCustomer(Customer theCustomer) {
		session.getTransaction().begin();
		session.merge(theCustomer);
		session.getTransaction().commit();
		Query query=session.createQuery("from CUSTOMER",Customer.class);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Customer> createCustomer(Customer theCustomer) {
		Customer customer = new Customer(theCustomer.getId(),theCustomer.getFirstName(),theCustomer.getLastName(), theCustomer.getEmail());
		session.getTransaction().begin();
		session.saveOrUpdate(customer);
		session.getTransaction().commit();
		Query query=session.createQuery("from CUSTOMER",Customer.class);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Customer> deleteCustomer(int id) {
		Customer customer = this.getCustomer(id);
		session.getTransaction().begin();
		session.delete(customer);
		session.getTransaction().commit();
		Query query=session.createQuery("from CUSTOMER",Customer.class);
		return query.getResultList();
	}

}
