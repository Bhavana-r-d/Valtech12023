package com.valtech.training.firstspringboot.service;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.firstspringboot.entities.User;
import com.valtech.training.firstspringboot.model.ChangePasswordModel;
import com.valtech.training.firstspringboot.model.RegisterUserModel;
import com.valtech.training.firstspringboot.repositories.UserRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AuthServiceImpl implements AuthService ,UserDetailsService{

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void populateUsers() {
		
		RegisterUserModel model=new RegisterUserModel();
		model.setUsername("root");
		model.setPassword("root");
		createUser(model);
		model.setUsername("admin");
		model.setPassword("admin123");
		User user=createUser(model);
		//upgradeUserToAdmin(user.getId);
		
		
	}
	@Override
	public User createUser(RegisterUserModel registerUserModel) {
		User user = new User(registerUserModel.getUsername(), passwordEncoder.encode(registerUserModel.getPassword()),
				Arrays.asList("ROLE_USER","ROLE_ADMIN"));
		user.setEnabled(true);
		return userRepo.save(user);
	}

	@Override
	public boolean changePassword(ChangePasswordModel passwordModel) {
		User user = userRepo.findByUsername(passwordModel.getUsername());
		if (passwordEncoder.matches(passwordModel.getOldPassword(), user.getPassword())) {
			user.setPassword(passwordEncoder.encode(passwordModel.getNewPassword()));
			userRepo.save(user);
			return true;

		}
		return false;
	}

	@Override
	public void upgradeUserToAdmin(long id) {
		User user=userRepo.getReferenceById(id);
		user.addRole("ROLE_ADMIN");
		userRepo.save(user);
	}
	
	@Override
	public void enableUser(long id) {
		userRepo.getReferenceById(id).setEnabled(true);
	}
	
	@Override
	public void disableUser(long id) {
		userRepo.getReferenceById(id).setEnabled(false);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepo.findByUsername(username);
	}
	
}
