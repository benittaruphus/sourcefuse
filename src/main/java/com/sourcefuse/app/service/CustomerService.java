package com.sourcefuse.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcefuse.app.entity.ContactInfo;
import com.sourcefuse.app.entity.Customer;
import com.sourcefuse.app.repo.ContactRepo;
import com.sourcefuse.app.repo.CustomerRepo;

@Service
public class CustomerService
{
	@Autowired
	private CustomerRepo custRepo;

	@Autowired
	private ContactRepo contactRepo;

	public Customer create(Customer customer)
	{
		return custRepo.save(customer);
	}

	public Customer update(Customer customer)
	{
		return custRepo.save(customer);

	}

	public void delete(Customer customer)
	{
		custRepo.delete(customer);

	}

	public void delete(Integer id)
	{
		custRepo.deleteById(id);

	}

	public ContactInfo updateContact(ContactInfo contact)
	{
		return contactRepo.save(contact);

	}

}
