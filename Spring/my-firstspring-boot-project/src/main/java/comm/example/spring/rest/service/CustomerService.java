package comm.example.spring.rest.service;

import java.util.List;

import comm.example.spring.rest.entity.Customer;

public interface CustomerService {

	List<Customer> getAllCustomer();
	Customer getCustomer(String id);
	List<Customer> updateCustomer(Customer theCustomer);
	List<Customer> createCustomer(Customer theCustomer);
	List<Customer> deleteCustomer(String id);
}
