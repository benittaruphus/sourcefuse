package com.sourcefuse.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcefuse.app.entity.Order;
import com.sourcefuse.app.repo.OrderRepo;

@Service
public class OrderService
{
	@Autowired
	private OrderRepo orderRepo;

	public Order create(Order order)
	{
		return orderRepo.save(order);
	}

	public Order update(Order order)
	{
		return orderRepo.save(order);

	}

	public void delete(Order order)
	{
		orderRepo.delete(order);

	}

	public void delete(Integer id)
	{
		orderRepo.deleteById(id);

	}

}
