package com.example.sec;

import com.example.sec.entity.Roles;
import com.example.sec.entity.UserEntity;
import com.example.sec.repository.RolesRepository;
import com.example.sec.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SecApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, RolesRepository rolesRepository, PasswordEncoder encoder){
        return args -> {
            Roles userRole = rolesRepository.save(new Roles("ROLE_USER"));
            Roles adminRole = rolesRepository.save(new Roles("ROLE_ADMIN"));
            userRepository.save(new UserEntity("user", encoder.encode("password"), Set.of(userRole)));
            userRepository.save(new UserEntity("admin", encoder.encode("password"), Set.of(adminRole)));
        };
        // блять я спочатку робив без звязку таблиць і називав стрінг "ADMIN" без роле_ і все працювадо
    }
}
