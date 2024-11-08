// AuthentificationServiceApplication.java
package org.ms.authentificationservice;

import java.util.HashSet;

import org.ms.authentificationservice.entities.AppRole;
import org.ms.authentificationservice.entities.AppUser;
import org.ms.authentificationservice.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthentificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthentificationServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.addRole(new AppRole(null, "USER"));
            userService.addRole(new AppRole(null, "ADMIN"));

            userService.addUser(new AppUser(null, "user1", "123", new HashSet<>()));
            userService.addUser(new AppUser(null, "user2", "456", new HashSet<>()));

            userService.addRoleToUser("user1", "USER");
            userService.addRoleToUser("user2", "USER");
            userService.addRoleToUser("user2", "ADMIN");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
