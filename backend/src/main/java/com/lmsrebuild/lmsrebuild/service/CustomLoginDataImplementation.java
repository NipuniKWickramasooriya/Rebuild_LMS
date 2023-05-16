package com.lmsrebuild.lmsrebuild.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lmsrebuild.lmsrebuild.model.Logindata;
import com.lmsrebuild.lmsrebuild.repository.LogindataRepository;

@Service
public class CustomLoginDataImplementation implements UserDetailsService {
	
	@Autowired
	private LogindataRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//find the user object through the DB
		Logindata loginUser = repository.findByUsername(username);
		CustomLoginData userDetails = null;
		
		//check whether user is null or not
		if(loginUser ==null)
		{
			throw new UsernameNotFoundException("User not exits" + username);
		}
		
		else 
		{
			userDetails = new CustomLoginData();
			userDetails.setUser(loginUser);
		}
		
		return userDetails;
	}

}

