package com.example.springbootcrudexample.service;

import com.example.springbootcrudexample.model.request.LoginRequest;
import com.example.springbootcrudexample.model.response.AuthenticationResponse;

public interface AuthService {

	AuthenticationResponse authenticate(LoginRequest request);

}
