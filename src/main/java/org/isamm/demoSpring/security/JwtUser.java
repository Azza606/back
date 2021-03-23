package org.isamm.demoSpring.security;

import java.util.Collection;

import org.isamm.demoSpring.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class JwtUser  implements UserDetails{
	private final Long id;
	private final String username;
	private final String password;
	private final User user;
	private final Collection<GrantedAuthority> authorities;
	private final boolean enabled;
	public JwtUser(Long id, String username, String password, User user, Collection<GrantedAuthority> authorities,
			boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.user = user;
		this.authorities = authorities;
		this.enabled = enabled;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@JsonIgnore
	public Long getId() {
		return id;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	
	
	public User getUser() {
		return user;
	}
	
	
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}
	
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}
	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
}
