/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FlywayMigrationStrategy redirectorMigrationStrategy() {
        return Flyway::validate;
    }
}
