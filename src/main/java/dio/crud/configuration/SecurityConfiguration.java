package dio.crud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration that handles all the application security.
 *
 * @author devsent
 */

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable().authorizeRequests()
                .antMatchers("/", "/customers").permitAll()
                .anyRequest().permitAll()
                .and()
                .formLogin();


        http.headers().frameOptions().sameOrigin();

        return http.build();
    }

}
