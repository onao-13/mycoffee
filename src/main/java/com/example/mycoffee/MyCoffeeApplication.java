package com.example.mycoffee;

import com.example.mycoffee.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({RsaKeyProperties.class})
@SpringBootApplication
public class MyCoffeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCoffeeApplication.class, args);
	}

}
