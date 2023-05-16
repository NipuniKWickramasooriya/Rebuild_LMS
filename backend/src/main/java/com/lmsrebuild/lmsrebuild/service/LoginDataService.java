package com.lmsrebuild.lmsrebuild.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lmsrebuild.lmsrebuild.model.Logindata;

public interface LoginDataService {
	
	public Logindata SaveLogindata(Logindata logindata);
	
	public List<Logindata> getAllLogindata();

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
