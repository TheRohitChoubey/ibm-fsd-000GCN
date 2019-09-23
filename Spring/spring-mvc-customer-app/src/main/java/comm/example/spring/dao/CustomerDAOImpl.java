package comm.example.spring.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import comm.example.spring.entity.Customer;

@Repository

public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	public CustomerDAOImpl() {
		super();
	}

	@PostConstruct
	public void createSession() {
		session = sessionFactory.openSession();
	}

	public CustomerDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void createCustomer(Customer theCustomer) {

		session.saveOrUpdate(theCustomer);
	}

	@Transactional
	public List<Customer> getCustomers() {
		Query<Customer> queryResult = session.createQuery("from Customer");
		List<Customer> allCustomers;
		allCustomers = queryResult.list();
		return allCustomers;
	}

	@Transactional
	public boolean deleteCustomerByEmail(String email) {
		Query<Customer> queryResult = session.createQuery("from Customer");
		List<Customer> allCustomers;
		allCustomers = queryResult.list();
		Customer cust = new Customer();
		for (int i = 0; i < allCustomers.size(); i++) {
			cust = (Customer) allCustomers.get(i);
			if (cust.getEmail().equals(email)) {
				break;
			}
		}
		cust = session.get(Customer.class, email);
		session.getTransaction().begin();
		session.delete(cust);
		session.getTransaction().commit();
		System.out.println("Done");
		return true;
	}

	@Transactional
	public Customer editCustomerByEmail(Customer theCustomer) {
		System.out.println(theCustomer.getId());
		session.getTransaction().begin();
		theCustomer = (Customer)session.merge(theCustomer);
		session.getTransaction().commit();
		return theCustomer;
	}

	@Transactional
	public Customer getCustomerById(String id) {
		Customer cust = new Customer();

		int custid = Integer.parseInt(id);
		Query<Customer> queryResult = session.createQuery("from Customer where id = " + custid);

		cust = queryResult.getSingleResult();
		return cust;
	}
}
