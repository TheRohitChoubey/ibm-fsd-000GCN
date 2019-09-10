package comm.example.spring.rest.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import comm.example.spring.rest.entity.Customer;

@Repository
public class CustomerDAOIMPL implements CustomerDAO {
	private EntityManager entityManager;
	private Session session;

	@Autowired
	public CustomerDAOIMPL(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	

	@SuppressWarnings("unchecked")

	public List<Customer> getAllCustomer() {
		Session session = getEntityManager().unwrap(Session.class);
		try {
			Query query = session.createQuery("from Customer", Customer.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Customer getCustomer(String id) {
		Session session = getEntityManager().unwrap(Session.class);
		Customer customer = session.find(Customer.class, id);
		return customer;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Customer> updateCustomer(Customer theCustomer) {
		Session session = getEntityManager().unwrap(Session.class);
		session.getTransaction().begin();
		session.merge(theCustomer);
		session.getTransaction().commit();
		Query query = session.createQuery("from CUSTOMER", Customer.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Customer> createCustomer(Customer theCustomer) {
		Session session = getEntityManager().unwrap(Session.class);
		Customer customer = new Customer(theCustomer.getId(), theCustomer.getFirstName(), theCustomer.getLastName(),
				theCustomer.getEmail());
		session.getTransaction().begin();
		session.saveOrUpdate(customer);
		session.getTransaction().commit();
		Query query = session.createQuery("from CUSTOMER", Customer.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Customer> deleteCustomer(String id) {
		Session session = getEntityManager().unwrap(Session.class);
		Customer customer = this.getCustomer(id);
		session.getTransaction().begin();
		session.delete(customer);
		session.getTransaction().commit();
		Query query = session.createQuery("from CUSTOMER", Customer.class);
		return query.getResultList();
	}

}
