package com.gabrielestudo.gerenciador.de.filmes.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielestudo.gerenciador.de.filmes.entities.Actor;

//Esse objeto vai isolar as entidades do dominio do código que acessará o banco de dados. É como se fosse o DAO

public interface ActorRepository extends JpaRepository<Actor, Long>{
	List<Actor> findByName(String name);
	Actor getReferenceById(Long id);
}
