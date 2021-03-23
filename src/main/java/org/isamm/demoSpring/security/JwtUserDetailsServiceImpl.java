package org.isamm.demoSpring.security;

import org.isamm.demoSpring.Repository.UserRepository;
import org.isamm.demoSpring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{

	
	@Autowired UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmailIgnoreCase(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("No user  found with username'%s'.", username));
		}
		return JwtUserFactory.create(user);
	}
	
}
