package com.gabrielestudo.gerenciador.de.filmes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gabrielestudo.gerenciador.de.filmes.entities.Director;


public interface DirectorRepository extends JpaRepository<Director, Long>{
	List<Director> findByName(String name);
	Director getReferenceById(Long id);
}
