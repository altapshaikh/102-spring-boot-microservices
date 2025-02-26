package com.ait.beans;

import lombok.Data;

@Data
public class User {
	private Long id;
    private String name;
    private String address;
    private String email;
    private String password;
    private String role;
}
