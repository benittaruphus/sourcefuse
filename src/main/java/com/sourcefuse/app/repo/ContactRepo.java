package com.sourcefuse.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourcefuse.app.entity.ContactInfo;

public interface ContactRepo extends JpaRepository<ContactInfo, Integer>
{

}
