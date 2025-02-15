package com.ait.repository;

import org.springframework.data.repository.CrudRepository;

import com.ait.entity.DepartmentEntity;

public interface DepartmentRepository 
                     extends CrudRepository<DepartmentEntity, Integer> {

}
