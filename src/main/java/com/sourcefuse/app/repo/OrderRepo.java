package com.sourcefuse.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourcefuse.app.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>
{

}
