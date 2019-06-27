package com.kshrd.configuration;

import ch.qos.logback.core.db.DriverManagerConnectionSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import javax.validation.Valid;

@Configuration
public class DatabaseConfiguration {

    @Bean
    @Profile("localDB")
    DataSource localDatabase(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/ams");
        dataSource.setUsername("postgres");
        dataSource.setPassword("12345678");
        return dataSource;
    }

    @Bean
    @Profile("memory")
    DataSource h2(){
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2);
        embeddedDatabaseBuilder.addScripts("classpath:static/sql/table.sql","classpath:static/sql/record.sql");
        return embeddedDatabaseBuilder.build();
    }
}
