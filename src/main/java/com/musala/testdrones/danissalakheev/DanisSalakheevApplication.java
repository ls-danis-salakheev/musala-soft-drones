package com.musala.testdrones.danissalakheev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DanisSalakheevApplication {

    public static void main(String[] args) {
        SpringApplication.run(DanisSalakheevApplication.class, args);
    }

}
