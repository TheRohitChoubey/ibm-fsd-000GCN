package comm.example.spring.rest.dao;

import java.util.List;

import comm.example.spring.rest.entity.Customer;

public interface CustomerDAO {

	List<Customer> getAllCustomer();
	Customer getCustomer(String id);
	List<Customer> updateCustomer(Customer theCustomer);
	List<Customer> createCustomer(Customer theCustomer);
	List<Customer> deleteCustomer(String id);
}
