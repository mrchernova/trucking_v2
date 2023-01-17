//package by.project.trucking_v2.config;
//
//import by.project.trucking_v2.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//
//import javax.sql.DataSource;
//
//import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private UserService userService;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
////                .requestMatchers(toH2Console()).permitAll()
//                .antMatchers("/", "/login", "/registration").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/")//Перенарпавление на главную страницу после успешного входа
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .logoutSuccessUrl("/");
//    }
//
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService(){
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("1")
//                        .password("1")
//                        .roles("ADMINISTRATOR")
//                        .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.jdbcAuthentication()
////                .dataSource(dataSource)
////                .passwordEncoder(NoOpPasswordEncoder.getInstance())
////                .usersByUsernameQuery("SELECT login, password FROM users WHERE login=?")
////                .authoritiesByUsernameQuery("SELECT login, role FROM users WHERE login=?");
////    }
//
//
//
//}
//
