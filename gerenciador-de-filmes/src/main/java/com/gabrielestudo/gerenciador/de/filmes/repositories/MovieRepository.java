package com.gabrielestudo.gerenciador.de.filmes.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielestudo.gerenciador.de.filmes.entities.Actor;
import com.gabrielestudo.gerenciador.de.filmes.entities.Director;
import com.gabrielestudo.gerenciador.de.filmes.entities.Movie;


public interface MovieRepository extends JpaRepository<Movie, Long>{
	List<Director> findByName(String name);
	Movie getReferenceById(Long id);
	List<Movie> findByDirector(Director dir);
	List<Movie> findByCast(Actor actor);
}
