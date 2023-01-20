package by.project.trucking_v2.security;


import by.project.trucking_v2.model.Role;
import by.project.trucking_v2.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.sql.DataSource;

@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
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
                .authorizeRequests()
//                .cors().disable()
//                .csrf().disable()

                .antMatchers("/").permitAll()

                .antMatchers(HttpMethod.GET, "/users").hasRole("ADMINISTRATOR")
                .antMatchers(HttpMethod.POST, "/users/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/users/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/users/**").hasAnyRole("ADMINISTRATOR", "CLIENT", "CARRIER")

                .antMatchers(HttpMethod.GET,"/orders").permitAll()
                .antMatchers(HttpMethod.POST,"/orders/**").hasRole("CLIENT")
                .antMatchers(HttpMethod.PUT,"/orders/**").hasAnyRole("CLIENT", "ADMINISTRATOR")
                .antMatchers(HttpMethod.DELETE, "/orders/**").hasAnyRole("CLIENT", "ADMINISTRATOR")

                .antMatchers(HttpMethod.GET,"/drivers").permitAll()
                .antMatchers(HttpMethod.POST,"/drivers/**").hasRole("CARRIER")
                .antMatchers(HttpMethod.PUT,"/drivers/**").hasAnyRole("CARRIER", "ADMINISTRATOR")
                .antMatchers(HttpMethod.DELETE, "/drivers/**").hasAnyRole("CARRIER", "ADMINISTRATOR")

                .antMatchers(HttpMethod.GET,"/transport").permitAll()
                .antMatchers(HttpMethod.POST,"/transport/**").hasRole("CARRIER")
                .antMatchers(HttpMethod.PUT,"/transport/**").hasAnyRole("CARRIER", "ADMINISTRATOR")
                .antMatchers(HttpMethod.DELETE, "/transport/**").hasAnyRole("CARRIER", "ADMINISTRATOR")

                .antMatchers(HttpMethod.GET,"/completed_orders").permitAll()
                .antMatchers(HttpMethod.POST,"/completed_orders/**").hasAnyRole("ADMINISTRATOR", "CARRIER", "CLIENT")
                .antMatchers(HttpMethod.PUT,"/completed_orders/**").hasRole("ADMINISTRATOR")
                .antMatchers(HttpMethod.DELETE, "/completed_orders/**").hasRole("ADMINISTRATOR")


                .and().formLogin();

    }
}