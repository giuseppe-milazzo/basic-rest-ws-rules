package com.mdev.restws.br.config;

import com.mdev.restws.br.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CredentialRepository credentialRepository;

    @Bean
    @SuppressWarnings("deprecation")
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // altrimenti la richiesta di autenticazione non avviene ad ogni richiesta!
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .csrf().disable()
                .authorizeRequests().anyRequest().hasRole("ADMIN")
                .and()
                .httpBasic();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
                return credentialRepository
                        .findByUsername(s)
                        .map(c -> new UserDetails() {
                            @Override public Collection<? extends GrantedAuthority> getAuthorities() { return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + c.getRole())); }
                            @Override public String getPassword() { return c.getPassword(); }
                            @Override public String getUsername() { return c.getUsername(); }
                            @Override public boolean isAccountNonExpired() { return true; }
                            @Override public boolean isAccountNonLocked() { return true; }
                            @Override public boolean isCredentialsNonExpired() { return true; }
                            @Override public boolean isEnabled() { return true; }
                        })
                        .orElseThrow(() -> new UsernameNotFoundException(String.format("no credential with [%s]", s)));
            }
        });
    }
}