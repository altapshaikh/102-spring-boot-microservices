package com.ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.model.CustomerEntity;

public interface CustomerRepository 
                        extends JpaRepository<CustomerEntity, Integer> {

}
