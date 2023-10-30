package com.deniron.DenironCRUD;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@EnableScheduling
public class DenironCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DenironCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

	}
}
