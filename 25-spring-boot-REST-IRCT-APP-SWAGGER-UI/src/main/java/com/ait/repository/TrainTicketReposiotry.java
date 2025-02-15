package com.ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ait.entity.TrainTicketEntity;
@Repository
public interface TrainTicketReposiotry extends 
                        JpaRepository<TrainTicketEntity, Long> {

}
