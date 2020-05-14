package com.example.ZuulAPIGateway.configuration;

import static com.example.ZuulAPIGateway.configuration.Constants.Roles.ADMIN;
import static com.example.ZuulAPIGateway.configuration.Constants.Roles.USER;

import com.example.ZuulAPIGateway.filter.RequestFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Autowired
    private RequestFilter requestFilter;

    @Override
    public void configure(WebSecurity web) throws Exception {
        // Allow eureka client to be accessed without authentication
        web.ignoring()
                .antMatchers("/eureka/**")//
                .antMatchers(HttpMethod.OPTIONS, "/**"); // Request type options should be allowed.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable().csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()

                .antMatchers(HttpMethod.POST, "/login", "/users", "/signup").permitAll()

                .antMatchers(HttpMethod.GET, "/",
                        "/celebs/**", "/jobs/**", "/celebjobs/**", "/moviecelebs/**",
                        "/movies/**", "/genreMovies/**", "/genres/**",
                        "/comments/**", "/reviews/**", "/watchlists/**", "/recensions/**").permitAll()
                .antMatchers(HttpMethod.GET, "/users/protected/**").hasAnyRole(ADMIN, USER)
                .antMatchers(HttpMethod.GET,  "/notifications/**").hasAnyRole(ADMIN, USER)
                .antMatchers(HttpMethod.GET, "/subscriptions/**").hasAnyRole(ADMIN, USER)
                .antMatchers(HttpMethod.GET, "/user/**").hasAnyRole(ADMIN, USER)
                .antMatchers(HttpMethod.POST, "/users/**").hasAnyRole(ADMIN, USER)
                .antMatchers("/comments/**", "/reviews/**", "/watchlists/**", "/recensions/**").hasAnyRole(ADMIN, USER)
                .antMatchers("/**").hasRole(ADMIN)

                .anyRequest().authenticated();


        http.addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}