package com.vehicleexpensetracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.vehicleexpensetracker.repository.UserRepository;
import com.vehicleexpensetracker.service.UserService;
import com.vehicleexpensetracker.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private UserRepository userRepository;


	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService());
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	@Bean
	public UserService userService() {
		return new UserServiceImpl(userRepository, passwordEncoder());
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				authorize -> authorize
	            .requestMatchers("/registration**", "/js/**", "/css/**", "/img/**").permitAll()
	            .anyRequest().authenticated()
				)
				.formLogin(form -> form.loginPage("/login").permitAll())
				.logout(logout -> logout.invalidateHttpSession(true).clearAuthentication(true)
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
						.permitAll());
		return http.build();

	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() throws Exception {
		return ((web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**"));
	}

}