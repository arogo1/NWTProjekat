package com.example.auth.security;

import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.microserviceuser.models.ApplUser;
import com.example.microserviceuser.repository.UserRepository;
import com.google.common.net.HttpHeaders;
import com.google.common.net.MediaType;
import com.netflix.ribbon.proxy.annotation.Http.HttpMethod;

@Service   
public class UserDetailsServiceImpl implements UserDetailsService  {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
    private RestTemplate restTemplate;
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Eh sada: ");
		//final String uri = "http://localhost:8081/user-microservice/users";
	     
	    //RestTemplate restTemplate = new RestTemplate();
	    //List<ApplUser> users1 = restTemplate.getForObject(uri, List.class);
		
	    
	    // hard coding the users
		final List<ApplUser> users = Arrays.asList(
			new ApplUser(1, "omar", encoder.encode("12345"), "USER"),
			new ApplUser(2, "admin", encoder.encode("12345"), "ADMIN")
		);
		
		//final List<ApplUser> users = restTemplate.getForObject("Http://ZuulAPIGateway//user-microservice/users", List.class);
		

		for(ApplUser appUser: users) {
			if(appUser.getUsername().equals(username)) {
				//appUser.setRole("ADMIN");
				
				List<GrantedAuthority> grantedAuthorities = AuthorityUtils
		                	.commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRole());
				
				
				return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities); 
			}
		}
		
		
		throw new UsernameNotFoundException("Username: " + username + " not found");
	}
	
}