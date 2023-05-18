package com.sourcefuse.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcefuse.app.entity.Product;
import com.sourcefuse.app.repo.ProductRepo;

@Service
public class ProductService
{
	@Autowired
	private ProductRepo productRepo;

	public Product create(Product product)
	{
		return productRepo.save(product);
	}

	public Product update(Product product)
	{
		return productRepo.save(product);

	}

	public void delete(Product product)
	{
		productRepo.delete(product);

	}

	public void delete(Integer id)
	{
		productRepo.deleteById(id);

	}

}
