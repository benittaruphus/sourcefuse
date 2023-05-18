package com.sourcefuse.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sourcefuse.app.entity.ContactInfo;
import com.sourcefuse.app.entity.Customer;
import com.sourcefuse.app.service.CustomerService;

@RestController
@RequestMapping(value = "/source")
public class CustomerController
{
	@Autowired
	private CustomerService custService;

	@PostMapping(value = "/customer")
	public Customer create(@RequestBody Customer customer)
	{
		return custService.create(customer);
	}

	@PatchMapping(value = "/customer")
	public Customer update(@RequestBody Customer customer)
	{
		return custService.update(customer);
	}

	@PatchMapping(value = "/customer/contact")
	public ContactInfo update(@RequestBody ContactInfo contact)
	{

		return custService.updateContact(contact);
	}

	@DeleteMapping(value = "/customer")
	public String delete(@RequestBody Customer customer)
	{
		custService.delete(customer);
		return "OK";
	}

	@DeleteMapping(value = "/customer")
	public String deleteById(@RequestParam Integer id)
	{
		custService.delete(id);
		return "OK";
	}
}
