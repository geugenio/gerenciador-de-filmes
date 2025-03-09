package com.gabrielestudo.gerenciador.de.filmes.controllers.movie;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielestudo.gerenciador.de.filmes.entities.Actor;
import com.gabrielestudo.gerenciador.de.filmes.entities.Director;
import com.gabrielestudo.gerenciador.de.filmes.entities.Movie;
import com.gabrielestudo.gerenciador.de.filmes.repositories.ActorRepository;
import com.gabrielestudo.gerenciador.de.filmes.services.DirectorService;
import com.gabrielestudo.gerenciador.de.filmes.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@Autowired
	ActorRepository actorRepository;
	
	@Autowired
	DirectorService directorService;
	
	@PostMapping("/")
	public ResponseEntity<String> registerMovie(@RequestBody createMovieDTO data){
        Director director = directorService.findById(data.directorId())
                .orElseThrow(() -> new RuntimeException("Diretor não encontrado!"));
		Set<Actor> cast = new HashSet<>();
		if(data.actorsId() !=null && !data.actorsId().isEmpty()) {
			cast = new HashSet<>(actorRepository.findAllById(data.actorsId()));
			if(cast.size()!=data.actorsId().size()) {
				return ResponseEntity.badRequest().body("Error! An actor not found");
			}
		}
		
		Movie movie = new Movie();
		movie.setName(data.name());
		movie.setReleaseYear(data.releaseYear());
		movie.setGenre(data.genre());
		movie.setDirector(director);
		movie.setCast(cast);
		movieService.save(movie);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovies(){
		return ResponseEntity.ok(movieService.findAll());
	}
	
    
    @GetMapping("/all")
    public ResponseEntity getAllActors() {
    	List<Movie> allMov = movieService.findAll();
    	return ResponseEntity.ok(allMov);
    }
    
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
    	movieService.delete(movieService.findReferenceById(id));
    	return ResponseEntity.ok().build();
    }
    
	
}
