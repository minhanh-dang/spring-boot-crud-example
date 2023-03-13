package com.example.springbootcrudexample.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.springbootcrudexample.model.entity.User;
import com.example.springbootcrudexample.model.exception.BadRequestException;
import com.example.springbootcrudexample.repository.UserInfoRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserInfoRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optUser = repository.findByName(username);

		if (!optUser.isPresent()) {
			throw new BadRequestException("User Not Present!");
		}
		return UserPrincipal.build(optUser.get());
	}
}
