package net.andydvorak;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Andrew C. Dvorak
 * @since 3/2/13
 */
@Configuration
//@ImportResource( { "classpath*:/rest_config.xml" } )
//@ComponentScan( basePackages = "net.andydvorak" )
@ComponentScan("net.andydvorak")
//@PropertySource({ "classpath:rest.properties", "classpath:web.properties" })
@EnableWebMvc
public class AppConfig{
    @Bean
    public PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}