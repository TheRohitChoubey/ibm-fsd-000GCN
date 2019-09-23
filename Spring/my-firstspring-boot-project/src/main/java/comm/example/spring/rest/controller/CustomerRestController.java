package comm.example.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comm.example.spring.rest.entity.Customer;
import comm.example.spring.rest.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService service;

	@GetMapping(value = "/customers")
	public List<Customer> getAllCustomers() {
		System.out.println("Entered in getAllCustomers");
		return service.getAllCustomer();
	}

	@GetMapping(value = "/customers/{id}")
	public Customer getCustomer(@PathVariable String id) {
		return service.getCustomer(id);
	}

	@DeleteMapping(value = "/customers/{id}")
	public List<Customer> deleteCustomer(@PathVariable String id) {
		return service.deleteCustomer(id);
	}

	@PutMapping(value = "/customers")
	public List<Customer> updateCustomer(@RequestBody Customer theCustomer) {
		return service.updateCustomer(theCustomer);
	}

	@PostMapping(value = "/customers")
	public List<Customer> createCustomer(@RequestBody Customer theCustomer) {
		return service.createCustomer(theCustomer);
	}

}
