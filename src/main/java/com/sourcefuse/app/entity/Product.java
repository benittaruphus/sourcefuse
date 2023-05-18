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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
@JsonInclude(Include.NON_NULL)
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "quantity")
	private String quantity;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private Set<Order> orders;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getQuantity()
	{
		return quantity;
	}

	public void setQuantity(String quantity)
	{
		this.quantity = quantity;
	}

	public Set<Order> getOrders()
	{
		return orders;
	}

	public void setItems(Set<Order> order)
	{
		this.orders = order;
	}

	@Override
	public String toString()
	{
		return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", orders=" + orders + "]";
	}

}
