/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 *
 * @author fraviola
 */
@SpringBootApplication
@EnableJpaRepositories("repository.sql")
@EnableMongoRepositories("repository.document")
@EntityScan("repository")
@ComponentScan(basePackages = {"application"})
public class SpringRun {
    public static void main(String[] args) {
        SpringApplication.run(SpringRun.class, args);
    }
}
