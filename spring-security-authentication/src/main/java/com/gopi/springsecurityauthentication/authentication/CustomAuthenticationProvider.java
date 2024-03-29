package com.gopi.springsecurityauthentication.authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Whenever we want to override spring authentication then we should override these methods and customize it.
 */
@EnableWebSecurity
public class CustomAuthenticationProvider extends WebSecurityConfigurerAdapter {

    //This methods keeps up all the users username and passwords, and we are using in-memory here but ideally it should be from some datasource.
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("gopi").password("gopi").roles("USER").and()
                .withUser("ram").password("ram").roles("ADMIN");
    }

    //This explains which encryption is used for password. Here I took no encoder i.e plain text is suffice but we should never do that.
    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }

    public void configure(final HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/admin").hasAnyRole("ADMIN")//if it is ADMIN allow to access /admin
                .antMatchers(("/user")).hasAnyRole("USER", "ADMIN")//if it is USER/ADMIN allow to access /user
                .antMatchers("/").permitAll()
                .and().formLogin();
    }
}
