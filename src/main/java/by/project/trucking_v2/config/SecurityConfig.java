package by.project.trucking_v2.config;

import by.project.trucking_v2.model.Role;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * ЭТО РАБОТАЕТ
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login", "/registration").permitAll()
                .antMatchers(HttpMethod.GET, "/users").hasAnyRole(Role.ADMINISTRATOR.name())
                .antMatchers(HttpMethod.GET, "/orders").hasAnyRole(Role.CLIENT.name())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/").permitAll()
                .and()
                .logout().permitAll()
                .logoutSuccessUrl("/");
    }
    /**************************************************/





    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("a")
                        .password(passwordEncoder().encode("a"))
                        .roles(Role.ADMINISTRATOR.name())
                        .build(),
                User.builder()
                        .username("c")
                        .password(passwordEncoder().encode("c"))
                        .roles(Role.CLIENT.name())
                        .build()
        );
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}
//https://www.youtube.com/watch?v=7uxROJ1nduk&ab_channel=EugeneSuleimanov