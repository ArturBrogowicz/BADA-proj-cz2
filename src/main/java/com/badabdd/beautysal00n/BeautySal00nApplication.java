package com.badabdd.beautysal00n;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.badabdd.beautysal00n.repositories")
public class BeautySal00nApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeautySal00nApplication.class, args);
    }

}
