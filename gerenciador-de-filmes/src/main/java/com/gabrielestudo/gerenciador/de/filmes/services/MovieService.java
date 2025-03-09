package com.gabrielestudo.gerenciador.de.filmes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielestudo.gerenciador.de.filmes.entities.Director;
import com.gabrielestudo.gerenciador.de.filmes.entities.Movie;
import com.gabrielestudo.gerenciador.de.filmes.repositories.MovieRepository;

@Service
public class MovieService {
	@Autowired
	MovieRepository movieRepository;
	
	public List<Movie> findAll(){
		return movieRepository.findAll();
	}
	
	public void save(Movie movie) {
		movieRepository.save(movie);
	}
	public void delete(Movie movie) {
		movieRepository.delete(movie);
	}
	
	public List<Movie> getByDirector(Director director){
		return movieRepository.findByDirector(director);
	}
	
	public Movie findReferenceById(Long id) {
		return movieRepository.getReferenceById(id);
	}
	
	public Optional<Movie> findById(Long id) {
		return movieRepository.findById(id);
	}
	
}
