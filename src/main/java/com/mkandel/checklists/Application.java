/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@EntityScan("com.mkandel.checklists.entities")
@ConfigurationProperties(prefix = "checklists")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    public Application(DataSource dataSource) {
        runFlyway(dataSource);
    }

    @Bean
    public FlywayMigrationStrategy migrationStrategy() {
        return Flyway::validate;
    }

    private void runFlyway(DataSource datasource) {
        // Create the Flyway instance
        final Flyway flyway = new Flyway();
        flyway.setDataSource(datasource);
        flyway.setTable("FlywayMigrationHistory");
        flyway.setLocations("classpath:db/migration");
        flyway.setBaselineOnMigrate(true);
        flyway.setRepeatableSqlMigrationPrefix("R");
        flyway.setSqlMigrationPrefix("V");
        flyway.migrate();
    }
}
