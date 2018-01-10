package br.com.dpacanhella.lambdas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@Configuration
public class LambdasApplication {

	public static void main(String[] args) {
		SpringApplication.run(LambdasApplication.class, args);
	}
	
    @Bean
    public SwaggerConfig swagger() {
        return new SwaggerConfig();
    }
}
