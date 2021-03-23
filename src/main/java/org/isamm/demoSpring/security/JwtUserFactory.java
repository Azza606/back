package org.isamm.demoSpring.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.isamm.demoSpring.model.User;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserFactory {

	public static JwtUser create(User user) {
		// TODO Auto-generated method stub
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), user, maptoGrantedAuthorities(new ArrayList<String>(Arrays.asList("ROLE_"+user.getRole()))), user.isEnabled());
	}

	private static List<GrantedAuthority> maptoGrantedAuthorities(ArrayList<String> authorities) {
		// TODO Auto-generated method stub
		return authorities.stream().map(Authority -> new SimpleGrantedAuthority(Authority)).collect(Collectors.toList());
		
	}

}
