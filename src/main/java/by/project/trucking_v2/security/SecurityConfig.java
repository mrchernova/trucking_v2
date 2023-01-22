package by.project.trucking_v2.security;


import by.project.trucking_v2.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }


    /** отвечает за аутентификацию */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }



    /** метод отвечает за авторизацию */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()     //POSTMAN
                .cors().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .and()
                .headers().frameOptions().sameOrigin()
                .and().formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/").permitAll()
                .and().logout().permitAll()
                .logoutSuccessUrl("/");

    }
}