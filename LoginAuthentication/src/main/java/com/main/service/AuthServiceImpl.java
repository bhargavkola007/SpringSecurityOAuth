package com.main.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.main.dto.SignUpDTO;
import com.main.entity.User;
import com.main.repository.UserRepository;

@Service

public class AuthServiceImpl implements AuthService{

	private final UserRepository repo;
	
	private final PasswordEncoder pass;
	
	@Autowired
	public AuthServiceImpl(UserRepository repo, PasswordEncoder pass) {
		super();
		this.repo = repo;
		this.pass = pass;
	}

	@Override
	public boolean createUser(SignUpDTO sign) {
	    // Check if user already exists
	    if (repo.existsByEmail(sign.getEmail())) { // Updated method name
	        return false;
	    }
	    User user = new User();
	    BeanUtils.copyProperties(sign, user);

	    // Changing password to hash
	    String hashPass = pass.encode(sign.getPassword());
	    user.setPassword(hashPass);

	    repo.save(user);
	    return true;
	}


	
}
