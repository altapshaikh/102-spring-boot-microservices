package com.ait.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ait.beans.User;
import com.ait.entity.UserEntity;
import com.ait.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository repo;
	
	@Cacheable(value = "users")
	public List<User>getAllUser(){
		List<User>users=new ArrayList<>();
		
		List<UserEntity> all = (List<UserEntity>) repo.findAll();
		all.forEach(user->{
			User user1=new User();
			BeanUtils.copyProperties(user, user1);
			users.add(user1);
		});
		return users;
	}
	@Cacheable(value = "user", key = "#id")
	public User getAllUserById(long id){
		User user1=new User();
		Optional<UserEntity> byId = repo.findById(id);
		UserEntity userEntity = byId.get();
		BeanUtils.copyProperties(userEntity, user1);
		return user1;
	}
	
	@CachePut(value = "user", key="#user.id")
	public User createUser(User user) {
		UserEntity entity=new UserEntity();
		BeanUtils.copyProperties(user, entity);
		UserEntity save = repo.save(entity);
		BeanUtils.copyProperties(entity, user);
		return user;
	}
	
	@CacheEvict(value = "user", key = "#id")
	public void deleteUser(long id) {
		repo.deleteById(id);
	}
	
}
