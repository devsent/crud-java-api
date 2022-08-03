package dio.crud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import dio.crud.error.service.CustomExceptionService;
import dio.crud.error.service.impl.CustomExceptionServiceImpl;

/**
 * Configuration that sets up common @Beans to be used throughout the application.
 *
 * @author devsent
 */

@Configuration
public class CustomerConfig {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public CustomExceptionService exceptionService(){return new CustomExceptionServiceImpl();}
}
