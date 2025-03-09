package com.gabrielestudo.gerenciador.de.filmes.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gabrielestudo.gerenciador.de.filmes.entities.Director;
import com.gabrielestudo.gerenciador.de.filmes.repositories.DirectorRepository;

@Service
public class DirectorService {
	@Autowired
	private DirectorRepository directorRepository;
	
	public void save(Director director) {
		directorRepository.save(director);
	}
	
	public List<Director> findAll() {
		return directorRepository.findAll();
	}
	
	public void delete(Director director) {
		directorRepository.delete(director);
	}
	
	public Director findReferenceById(Long id) {
		return directorRepository.getReferenceById(id);
	}
	
	public Optional<Director> findById(Long id) {
		return directorRepository.findById(id);
		
	}
	
	public List<Director> findByName(String name) {
		return directorRepository.findByName(name);
	}
}
