package com.project.smartbuidingapp.Security;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Autowired
    private UserDetailsService userDetailsService;
    private final AuthenticationManagerBuilder authManagerBuilder;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/v2/**", "/swagger-resources/**", "/configuration/**", "/swagger*/**", "/webjars/**", "/swagger-ui/**", "/v3/api-docs/**", "/proxy/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
               http.csrf().disable();
               http.sessionManagement().sessionCreationPolicy(STATELESS);
               http.authorizeRequests().antMatchers("/v2/**", "/swagger-resources/**", "/configuration/**", "/swagger*/**", "/webjars/**", "/swagger-ui/**", "/v3/api-docs/**", "/proxy/**").permitAll();
               http.authorizeRequests().antMatchers("/login").permitAll();
               http.authorizeRequests().antMatchers(GET, "/api/v1/**").hasAnyAuthority("USER");
               http.authorizeRequests().antMatchers(POST, "/api/v1/**").hasAnyAuthority("ADMIN");
               http.authorizeRequests().antMatchers(PUT, "/api/v1/**").hasAnyAuthority("USER");
               http.authorizeRequests().antMatchers(DELETE, "/api/v1/**").hasAnyAuthority("USER");
               http.authorizeRequests().anyRequest().permitAll();
               http.addFilter(new CustomAuthenticationFilter(authManagerBuilder.getOrBuild()));
               http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
               return http.build();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }


}
