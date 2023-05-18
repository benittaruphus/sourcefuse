package com.sourcefuse.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sourcefuse.app.entity.ContactInfo;
import com.sourcefuse.app.entity.Customer;
import com.sourcefuse.app.repo.ContactRepo;
import com.sourcefuse.app.repo.CustomerRepo;
import com.sourcefuse.app.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest
{

	@InjectMocks
	CustomerService custService;
	@Mock
	ContactRepo contactRepo;
	@Mock
	CustomerRepo custRepo;

	SoftAssertions softly;

	@BeforeEach
	void setUp() throws Exception
	{

	}

	@Test
	void testCreate() throws Exception
	{
		Customer customer = TestUtils.getCustomer();
		when(contactRepo.save(any())).thenReturn(TestUtils.getCustomer());
		Customer customerReturned = custService.create(customer);
		softly = new SoftAssertions();
		softly.assertThat(customerReturned).isEqualToComparingFieldByField(customer);
		verify(custRepo, times(1)).save(any());
		softly.assertAll();

	}

	@Test
	void testUpdate() throws Exception
	{
		Customer customer = TestUtils.getCustomer();
		when(contactRepo.save(any())).thenReturn(TestUtils.getCustomer());
		Customer customerReturned = custService.update(customer);
		softly = new SoftAssertions();
		softly.assertThat(customerReturned).isEqualToComparingFieldByField(customer);
		verify(custRepo, times(1)).save(any());
		softly.assertAll();
	}

	@Test
	void testDelete() throws Exception
	{
		Customer customer = TestUtils.getCustomer();
		custService.delete(customer);
		verify(custRepo, times(1)).delete(any());
	}

	@Test
	void testDeleteById() throws Exception
	{
		Customer customer = TestUtils.getCustomer();
		custService.delete(customer.getId());
		verify(custRepo, times(1)).deleteById(anyInt());
	}

	@Test
	void testUpdateContact() throws Exception
	{
		Customer customer = TestUtils.getCustomer();
		ContactInfo contact = custService.updateContact(customer.getContactInfo());
		verify(contactRepo, times(1)).save(any());
		assertThat(contact).isEqualToComparingFieldByField(customer.getContactInfo());
	}
}