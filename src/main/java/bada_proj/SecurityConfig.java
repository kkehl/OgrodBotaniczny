package bada_proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled FROM USERS WHERE username=?")
                .authoritiesByUsernameQuery("SELECT username, role FROM USERS WHERE username=?");
    }

    @Override
    protected  void configure(HttpSecurity http)  throws Exception {
        http.authorizeRequests()

                .antMatchers("/new/pracownik", "/edit/pracownik/**", "/update/pracownik", "/save/pracownik", "/delete/pracownik/**").hasRole("ADMIN")
                .antMatchers("/list/rosliny", "/", "/error", "/errors/**", "list/sekcje").hasAnyRole("ADMIN", "USER", "EMPLOYEE")
                .antMatchers("/list/pracownicy").hasAnyRole("ADMIN", "USER")
                .antMatchers("/new/sekcja", "/edit/sekcja/**", "/update/sekcja", "/save/sekcja", "/delete/sekcja/**", "/new/roslina", "/edit/roslina/**", "/update/roslina", "/save/roslina", "/delete/roslina/**").hasAnyRole("ADMIN", "EMPLOYEE")
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }



    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "admin";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println(encodedPassword);
    }

}
