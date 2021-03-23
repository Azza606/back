package org.isamm.demoSpring.service;

import java.util.List;


import org.isamm.demoSpring.model.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	
}
