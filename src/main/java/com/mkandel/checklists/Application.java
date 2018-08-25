/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists;

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("com.mkandel.checklists.entities")
@ConfigurationProperties
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FlywayMigrationStrategy migrationStrategy() {
        return Flyway::validate;
    }

    @Autowired
    DataSource dataSource;

    private void runFlyway(DataSource datasource) {
        // Create the Flyway instance
        Flyway flyway = new Flyway();
        flyway.setDataSource(datasource);
        flyway.migrate();
    }
}