package com.arpita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringJpaRevisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaRevisionApplication.class, args);
	}

}
