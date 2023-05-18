package com.sourcefuse.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sourcefuse.app.entity.Customer;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CustomerRepo extends JpaRepository<Customer, Integer>
{

}
