package com.gabrielestudo.gerenciador.de.filmes.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gabrielestudo.gerenciador.de.filmes.entities.Actor;
import com.gabrielestudo.gerenciador.de.filmes.repositories.ActorRepository;


@Service
public class ActorService {

	@Autowired
	private ActorRepository actorRepository;
	
	public void save(Actor actor) {
		actorRepository.save(actor); //salvar ator
	}
	
	public List<Actor> findAll() {
		return actorRepository.findAll(); //retornar a lista com todos os atores
	}
	
	public void delete(Actor actor) {
		actorRepository.delete(actor); //apagar ator
	}
	
	public Actor findReferenceById(Long id) {
		return actorRepository.getReferenceById(id);
	}
	
	public Optional<Actor> findById(Long id) {
		return actorRepository.findById(id);
		
	}
	
	public List<Actor> findByName(String name) {
		return actorRepository.findByName(name);
	}
}
