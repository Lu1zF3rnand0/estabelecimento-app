package br.edu.infnet.estabelecimentoapp.security;

import br.edu.infnet.estabelecimentoapp.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDao userDao;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDao).passwordEncoder(new BCryptPasswordEncoder());
		super.configure(auth);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/usuario/**").permitAll()
			.antMatchers("/app").permitAll()
			.antMatchers("/estabelecimentos").permitAll()
			.antMatchers("/estabelecimento/**").hasRole("ADMIN")
			.antMatchers("/funcionario/**").hasRole("ADMIN")
			.antMatchers("/funcionarios").hasRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
			.csrf().disable()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.and().exceptionHandling().accessDeniedPage("/negado");
	}
	
}
