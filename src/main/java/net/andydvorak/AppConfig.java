package net.andydvorak;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Andrew C. Dvorak
 * @since 3/2/13
 */
@Configuration
@ComponentScan("net.andydvorak")
@EnableWebMvc
public class AppConfig{
    @Bean
    public PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
