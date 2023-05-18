package com.sourcefuse.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sourcefuse.app.entity.Order;
import com.sourcefuse.app.service.OrderService;

@RestController
@RequestMapping(value = "/source")
public class OrderController
{
	@Autowired
	private OrderService orderService;

	@PostMapping(value = "/order")
	public Order create(@RequestBody Order order)
	{
		orderService.create(order);
		return order;
	}

	@PatchMapping(value = "/order")
	public Order update(@RequestBody Order order)
	{
		orderService.update(order);
		return order;
	}

	@DeleteMapping(value = "/order")
	public void delete(@RequestBody Order order)
	{
		orderService.delete(order);
	}

	@DeleteMapping(value = "/order")
	public void deleteById(@RequestParam Integer id)
	{
		orderService.delete(id);
	}
}
