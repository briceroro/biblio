package com.mairie.biblio.biblioWebApp.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Class servant a gérer la sécutité de l'application via spring sécutiry
 * 
 * @author briceroro
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * Génération du Bean pour gerer la methode UserDetailsServiceImp
	 */
  @Bean
  public UserDetailsService userDetailsService() {
    return new UserDetailsServiceImp();
  };
  
  /**
   * Génération du Bean pour gerer la methode BCryptPasswordEncode
   */
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  };
  
 /**
  * Methode servant a configurer le passwordEncoder
  */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
  }

  /**
   * Méthode servant à configurer les accès au page de l'application
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  http.
		authorizeRequests()
			.antMatchers("/loginForm").permitAll()
		    .antMatchers("/").authenticated()
		    .antMatchers("/searchBook").authenticated()
		    .antMatchers("/searchBorrowedBook").authenticated()
          .anyRequest().authenticated()
          .and()
          .formLogin()
          .loginPage("/loginForm")
			.usernameParameter("username")
			.passwordParameter("password")
	        .defaultSuccessUrl("/", true)
	        .failureUrl("/loginForm?error=true")
			.and().logout().permitAll();
			
  }
  
  /**
   * Méthode servant a configurer les exeptions de WebSecurity de l'application
   */
  @Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
}
