package comm.example.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comm.example.spring.entity.Customer;
import comm.example.spring.service.CustomerService;

@Controller
//@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerService service;

	@GetMapping("/")
	public String showForm(Model theModel) {
		Customer customer = new Customer();
		theModel.addAttribute("customer", customer);
		return "customer-home";
	}

	@GetMapping("/showList")
	public String showList(Model theModel) {
		List<Customer> customerList;
		customerList = service.getCustomers();
		theModel.addAttribute("customerList", customerList);
		return "customer-list";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute("customer") Customer theCustomer, Model theModel) {
		service.createCustomer(theCustomer);
		return "redirect:/";
	}
	
	@GetMapping(value="/deleteByEmail")
	public String deleteByEmail(@RequestParam String email,Model theModel) {
		service.deleteCustomerByEmail(email);
		return "customer-list";
	}
	
	@GetMapping(value="/editById")
	public String editByEmail(@RequestParam String id,Model theModel) {
		Customer customer = service.getCustomerById(id);
		theModel.addAttribute("customer", customer);
		return "customer-edit";
	}
	
	@PostMapping(value="/editSaveDetails")
	public String editSaveDetails(@ModelAttribute("customer") Customer theCustomer,Model theModel) {
		Customer cust = new Customer();
		service.editCustomerByEmail(theCustomer);
		//System.out.println(cust.toString());
		List<Customer> customerList;
		customerList = service.getCustomers();
		theModel.addAttribute("customerList", customerList);
		return "customer-list";
	}
}
