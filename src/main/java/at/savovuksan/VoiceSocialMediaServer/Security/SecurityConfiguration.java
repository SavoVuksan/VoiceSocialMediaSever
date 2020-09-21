package at.savovuksan.VoiceSocialMediaServer.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
        auth.inMemoryAuthentication().withUser("savo").password("savo").roles("USER").and().withUser("bozo")
                .password("bozo").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        // super.configure(http);
        http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").antMatchers("/user").hasAnyRole("USER", "ADMIN")
                .antMatchers("/").permitAll().and().formLogin();
        // http.authorizeRequests().antMatchers("/hello").permitAll();
        // http.authorizeRequests().antMatchers("/helloSec").hasRole("USER").and().formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        // CHANGE THIS IS NOT SECURE USE SHA-256 ENCODING WITH SALT!
        return NoOpPasswordEncoder.getInstance();
    }

}
