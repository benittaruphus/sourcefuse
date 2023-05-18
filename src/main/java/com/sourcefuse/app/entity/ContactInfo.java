package com.sourcefuse.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact")
@JsonInclude(Include.NON_NULL)
public class ContactInfo
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contact_id", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "address")
	private String addressLine1;

	@Column(name = "city")
	private String city;

	@OneToOne(mappedBy = "customer")
	@JsonIgnore
	private Customer customer;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getAddressLine1()
	{
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	@Override
	public String toString()
	{
		return "ContactInfo [addressLine1=" + addressLine1 + ", city=" + city + "]";
	}
}
