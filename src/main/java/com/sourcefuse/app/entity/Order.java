package com.sourcefuse.app.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "order")
@JsonInclude(Include.NON_NULL)
public class Order
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id", updatable = false, nullable = false)
	private Integer id;

	@JoinTable(name = "order", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
	private Set<Product> items;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "order")
	private Set<Customer> customers;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Set<Product> getItems()
	{
		return items;
	}

	public void setItems(Set<Product> items)
	{
		this.items = items;
	}

	public Set<Customer> getCustomers()
	{
		return customers;
	}

	public void setCustomers(Set<Customer> customers)
	{
		this.customers = customers;
	}

	@Override
	public String toString()
	{
		return "Order [id=" + id + ", items=" + items + "]";
	}

}
