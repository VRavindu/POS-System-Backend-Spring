package lk.ijse.gdse.possystembackendspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse.gdse.possystembackendspring")
@EnableWebMvc
public class WebAppConfig {
}
