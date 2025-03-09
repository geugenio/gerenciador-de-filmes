package com.gabrielestudo.gerenciador.de.filmes.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.gabrielestudo.gerenciador.de.filmes.entities")
@EnableJpaRepositories(basePackages = "com.gabrielestudo.gerenciador.de.filmes.repositories")
public class JpaConfig {

}
