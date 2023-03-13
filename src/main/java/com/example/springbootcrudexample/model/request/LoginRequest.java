package com.example.springbootcrudexample.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

	private String name;
	private String password;
}
