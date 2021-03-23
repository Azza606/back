package org.isamm.demoSpring.service;


import java.util.Date;
import java.util.List;

import org.isamm.demoSpring.Repository.UserRepository;
import org.isamm.demoSpring.model.User;
import org.isamm.demoSpring.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired UserRepository userRepository;

	@Override
	public User save(User user) {
		String password = PasswordUtil.getPasswordHash(user.getPassword());
		user.setPassword(password);
		user.setCreateDate(new Date());
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		
		return (List<User>) userRepository.findAll();
	}

}
