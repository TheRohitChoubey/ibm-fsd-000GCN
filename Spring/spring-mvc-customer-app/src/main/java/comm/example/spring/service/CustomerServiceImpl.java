package comm.example.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comm.example.spring.dao.CustomerDAO;
import comm.example.spring.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO dao;
	public void createCustomer(Customer theCustomer) {
		dao.createCustomer(theCustomer);
	}
	
	public List<Customer>  getCustomers() {
		return dao.getCustomers();
	}

	public boolean deleteCustomerByEmail(String email) {
		return dao.deleteCustomerByEmail(email);
	}
	
	public Customer editCustomerByEmail(Customer theCustomer) {
		return dao.editCustomerByEmail(theCustomer);
	}
	
	public Customer getCustomerById(String id) {
		return dao.getCustomerById(id);
	}
}
