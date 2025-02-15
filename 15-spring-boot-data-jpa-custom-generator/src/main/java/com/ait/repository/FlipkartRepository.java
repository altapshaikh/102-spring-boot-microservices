package com.ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.FlipkartEntity;

public interface FlipkartRepository 
                           extends JpaRepository<FlipkartEntity, String> {

}
