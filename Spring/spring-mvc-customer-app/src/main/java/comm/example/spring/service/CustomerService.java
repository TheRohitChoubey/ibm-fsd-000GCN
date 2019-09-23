package comm.example.spring.service;

import java.util.List;

import comm.example.spring.entity.Customer;

public interface CustomerService {
	
	public void createCustomer(Customer theCustomer);
	public List<Customer> getCustomers();
	public boolean deleteCustomerByEmail(String email);
	public Customer editCustomerByEmail(Customer theCustomer);
	public Customer getCustomerById(String id);
}
