package com.exam.onlineExam.Configuration;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.exam.onlineExam.Services.ServiceImp.UserDetailsServiceImp;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    jwtAuthenticationEntryPoint  unauthorizedHandle;
    @Autowired
    UserDetailsServiceImp userDetailsServiceImp;
    @Autowired
    JwtAuthenticaionFilter jwtAuthenticaionFilter;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    // @Bean
    // public DaoAuthenticationProvider authenticationProvider() {
    // DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
     
    // authProvider.setUserDetailsService(userDetailsServiceImp);
    // authProvider.setPasswordEncoder(passwordEncoder());
 
    //  return authProvider;  
    // }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    
    //     http.authorizeRequests().antMatchers("/user/**").hasRole("Normal").
    //     and().formLogin().loginPage("/login").and().csrf().disable();

    //     http.formLogin().defaultSuccessUrl("/user");
        
    //     return http.build();
    // }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
        auth.userDetailsService(this.userDetailsServiceImp).passwordEncoder(passwordEncoder());
        
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
       http.csrf().disable().
                            cors().disable().
                            authorizeRequests().
                            antMatchers("/generate-token","/user/test").permitAll()
                            .antMatchers(HttpMethod.OPTIONS).permitAll()
                            .anyRequest().authenticated()
                            .and()
                            .exceptionHandling().authenticationEntryPoint(unauthorizedHandle)
                            .and()
                            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

                            http.addFilterBefore(jwtAuthenticaionFilter,UsernamePasswordAuthenticationFilter.class);
    }

    
    
}
