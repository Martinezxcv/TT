package com.example.shopSpring.config;

import com.example.shopSpring.data.employees.model.Employee;
import com.example.shopSpring.data.employees.model.EmployeeDto;
import com.example.shopSpring.data.employees.service.EmployeeService;
import com.example.shopSpring.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {

    @Autowired
    private  EmployeeService employeeService;

    @Bean
    public UserDetailsService userDetailsService() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        List<UserDetails> userDetailsList = new ArrayList<>();

        for (EmployeeDto employee : employees) {
            employee.getLoginId().setLogin(employee.getLoginId().getLogin());
            employee.getLoginId().setPassword(new BCryptPasswordEncoder().encode(employee.getLoginId().getPassword()));
            userDetailsList.add(new CustomUserDetails(employee));
        }
        return new InMemoryUserDetailsManager(userDetailsList);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests(authorize -> {
                    authorize
                            .requestMatchers(HttpMethod.GET).hasAnyRole("admin","user","Employee")
                            .requestMatchers("/role/**").hasAnyRole("admin","Employee")
                            .anyRequest().permitAll();
                })
                .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.permitAll())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
