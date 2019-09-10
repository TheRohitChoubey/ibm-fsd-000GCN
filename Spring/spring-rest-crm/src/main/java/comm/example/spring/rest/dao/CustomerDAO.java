package comm.example.spring.rest.dao;

import java.util.List;

import comm.example.spring.rest.Customer;

public interface CustomerDAO {

	List<Customer> getAllCustomer();
	Customer getCustomer(int id);
	List<Customer> updateCustomer(Customer theCustomer);
	List<Customer> createCustomer(Customer theCustomer);
	List<Customer> deleteCustomer(int id);
}
