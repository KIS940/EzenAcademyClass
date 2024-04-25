package com.teamproject.gaxga;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GaxgaApplication {
	public static void main(String[] args) {

		SpringApplication.run(GaxgaApplication.class, args);
	}

}
