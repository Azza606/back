package org.isamm.demoSpring.controller;

import java.util.List;


import org.isamm.demoSpring.model.User;
import org.isamm.demoSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired private UserService userService;
	
	@GetMapping(value="/users")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<User>>getAllusers(){
		List<User> users =userService.findAll();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
}
