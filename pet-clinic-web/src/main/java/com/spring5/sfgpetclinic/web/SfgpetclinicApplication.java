package com.spring5.sfgpetclinic.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sajjad
 * @SpringBootApplication , will tell spring to look for all the spring annoted classes
 * e.g @Controller, @Componenet , @Service etc inside the packe where this annotation is . i.e in our case
 * inside com.spring5.sfgpetclinic.web .
 * Any Controller outside this package will not be scanned and included by the Spring Boot application.
 * Let's say we have another package com.spring5.sfgpetclinic.web1 , any Controller inside it will not be picked hence if used anywhere will result in errors.
 */
@SpringBootApplication
public class SfgpetclinicApplication {
    /**
     * Comment added by sajjad
     * @param args
     */

    public static void main(String[] args) {
        SpringApplication.run(SfgpetclinicApplication.class, args);
    }

}
