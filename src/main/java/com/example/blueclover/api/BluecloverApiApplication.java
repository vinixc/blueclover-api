package com.example.blueclover.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.blueclover.api.config.property.BlueCloverApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(BlueCloverApiProperty.class)
public class BluecloverApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluecloverApiApplication.class, args);
	}

}
