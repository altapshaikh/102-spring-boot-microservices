package com.ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.SalaryEntity;

public interface SalaryRepository extends JpaRepository<SalaryEntity, Integer> {

}
