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
		custService.create(customer);
		return customer;
	}

	@PatchMapping(value = "/customer")
	public Customer update(@RequestBody Customer customer)
	{
		custService.update(customer);
		return customer;
	}

	@PatchMapping(value = "/customer/contact")
	public ContactInfo update(@RequestBody ContactInfo contact)
	{
		custService.updateContact(contact);
		return contact;
	}

	@DeleteMapping(value = "/customer")
	public void delete(@RequestBody Customer customer)
	{
		custService.delete(customer);
	}

	@DeleteMapping(value = "/customer")
	public void deleteById(@RequestParam Integer id)
	{
		custService.delete(id);
	}
}
