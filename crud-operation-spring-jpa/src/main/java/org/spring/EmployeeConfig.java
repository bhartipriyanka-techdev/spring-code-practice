package org.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Configuration
@ComponentScan("org.spring.dao")
public class EmployeeConfig {
    @Bean
    public EntityManager getEntityManager(){
        return Persistence.createEntityManagerFactory("development").createEntityManager();
    }

}
