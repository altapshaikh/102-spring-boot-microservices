package com.ait.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ait.entity.UserEntity;
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
