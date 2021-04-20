package ro.msg.learning.shop.configurations;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ro.msg.learning.shop.services.UserDetailsService;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
@Profile("with-form")
public class FormAuthenticationConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;

    public void configure(WebSecurity web){
        web.ignoring().antMatchers("/h2/**");
    }

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .failureUrl("/login-error")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .csrf()
                .disable();
        http.headers().frameOptions().disable();
    }

}
