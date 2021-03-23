package org.isamm.demoSpring.security;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.sun.javafx.collections.MappingChange.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtTokenUtil implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 static final String CLAM_Key_USERNAME ="sub";
	 static final String CLAM_Key_AUDIENCE ="audience";
	 static final String CLAM_Key_CREATED ="created";

	 @Value("${jwt.secret}")
	 private String secret;
	 @Value("${jwt.expiration}")
	 private Long expiration;
	String username = null;
	
	public String getUsernameFromToken(String token) {

		try {
			final Claims claims = getClaimsFromToken(token);
			username=claims.getSubject();
			}catch(Exception e) {
			
		}
		
		return username;
	}

	private Claims getClaimsFromToken(String token) {
			Claims claims=null;
			try {
				Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			}catch(Exception e) {
				claims=null;
			}
		return claims;
	}

	public boolean validateToken(String token, UserDetails userDetails) {

		JwtUser user =(JwtUser)userDetails;
		final String username= getUsernameFromToken(token);
		return (username.equals(user.getUsername()) && isTokenExpired(token));
	}

	private boolean isTokenExpired(String token) {
final Date expiration =getExpirationDateFromToken(token);	
return expiration.before(new Date());
	}

	private Date getExpirationDateFromToken(String token) {
Date expiration = null;
try {
	final Claims claims = getClaimsFromToken(token);
		if(claims!=null) {
			expiration = null;
		}
}catch(Exception e) {
	expiration = null;
}
		return expiration;
	}

	public String generateToken(JwtUser userDetails) {
	java.util.Map< String, Object> clamis = new HashMap<>() ;
	clamis.put(CLAM_Key_USERNAME, userDetails.getUsername());
	clamis.put(CLAM_Key_CREATED, new Date());
	return generateToken(clamis);
	}

	private String generateToken(java.util.Map<String, Object> clamis) {
		return Jwts.builder().setClaims(clamis).setExpiration(generateExperationDate()).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	private Date generateExperationDate() {
		// TODO Auto-generated method stub
		return null;
	}

}
