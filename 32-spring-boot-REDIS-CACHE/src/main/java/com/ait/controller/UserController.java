package com.ait.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ait.beans.User;
import com.ait.service.UserService;

@RestController

public class UserController {
	@Autowired
	private UserService service;

	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUser = service.getAllUser();
		return ResponseEntity.ok(allUser);
	}

	@GetMapping(value = "/user/{id}")
	public ResponseEntity<User> getUsers(@PathVariable("id") long id) {
		User user = service.getAllUserById(id);
		return ResponseEntity.ok(user);
	}
	@PostMapping(value = "/user")
	public ResponseEntity<User>createUser(@RequestBody User user){
		User user2 = service.createUser(user);
		return ResponseEntity.ok(user2);
	}
	@DeleteMapping(value = "/user/{id}")
	public void deleteUserById(@PathVariable("id")long id) {
	service.deleteUser(id);
	}

}
