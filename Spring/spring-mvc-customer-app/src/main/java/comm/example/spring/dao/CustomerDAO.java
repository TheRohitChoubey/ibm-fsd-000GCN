package comm.example.spring.dao;

import java.util.List;

import comm.example.spring.entity.Customer;

public interface CustomerDAO {

	public void createCustomer(Customer theCustomer);
	public List<Customer> getCustomers();
	public boolean deleteCustomerByEmail(String email);
	public Customer editCustomerByEmail(Customer theCustomer);
	public Customer getCustomerById(String id);
}
