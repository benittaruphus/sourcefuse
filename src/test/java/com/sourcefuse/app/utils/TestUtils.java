package com.sourcefuse.app.utils;

import java.util.HashSet;
import java.util.Set;

import com.sourcefuse.app.entity.ContactInfo;
import com.sourcefuse.app.entity.Customer;
import com.sourcefuse.app.entity.Order;
import com.sourcefuse.app.entity.Product;

public class TestUtils
{

	public static Customer getCustomer()
	{
		Customer c = new Customer();
		c.setId(1);
		c.setName("John");
		c.setContactInfo(getContactInfo());
		c.setOrders(getOrders());
		return c;
	}

	public static Set<Order> getOrders()
	{
		Set<Order> s = new HashSet<>();
		s.add(getOrder(1));
		s.add(getOrder(2));

		return s;
	}

	private static Order getOrder(Integer i)
	{
		Order o = new Order();
		o.setId(i);
		o.setItems(getItems());
		return o;
	}

	private static Set<Product> getItems()
	{
		Set<Product> s = new HashSet<>();
		s.add(getProduct(1, "Pen", 10));
		s.add(getProduct(2, "Pencil", 20));
		return s;
	}

	private static Product getProduct(int id, String name, int quantity)
	{
		Product p = new Product();
		p.setId(id);
		p.setName(name);
		p.setQuantity(quantity);
		return p;
	}

	public static ContactInfo getContactInfo()
	{
		ContactInfo c = new ContactInfo();
		c.setId(1);
		c.setAddressLine1("line1");
		c.setCity("Chennai");
		return null;
	}

}
