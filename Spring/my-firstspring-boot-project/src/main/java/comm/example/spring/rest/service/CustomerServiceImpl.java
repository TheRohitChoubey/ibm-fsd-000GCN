package comm.example.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comm.example.spring.rest.dao.CustomerDAO;
import comm.example.spring.rest.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO dao;

	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return dao.getAllCustomer();
	}
	
	public Customer getCustomer(String id) {
		return dao.getCustomer(id);
	}
	
	public List<Customer> deleteCustomer(String id) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(id);
	}
	
	public List<Customer> updateCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		return dao.updateCustomer(theCustomer);
	}
	
	public List<Customer> createCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		return dao.createCustomer(theCustomer);
	}
}
