package com.ventas.app.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ventas.app.model.Rol;
import com.ventas.app.repository.RolRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initRoles(RolRepository rolRepository) {
        return args -> {

            if (rolRepository.findByNombre("ADMIN").isEmpty()) {
                rolRepository.save(new Rol(null, "ADMIN"));
            }

            if (rolRepository.findByNombre("VENDEDOR").isEmpty()) {
                rolRepository.save(new Rol(null, "VENDEDOR"));
            }
        };
    }
}
