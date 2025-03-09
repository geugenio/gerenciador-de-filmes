package com.gabrielestudo.gerenciador.de.filmes.controllers.actor;


import org.springframework.web.bind.annotation.RestController;
import com.gabrielestudo.gerenciador.de.filmes.entities.Actor;
import com.gabrielestudo.gerenciador.de.filmes.services.ActorService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
@RequestMapping("/actors")
public class ActorController {
	
	@Autowired
	private ActorService actorService;
	
    @PostMapping("/")
    public ResponseEntity registerActor(@RequestBody RequestActorDTO data){
    	Actor newActor = new Actor(data);
    	actorService.save(newActor);
    	return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping("/all")
    public ResponseEntity getAllActors() {
    	List<Actor> allActors = actorService.findAll();
    	return ResponseEntity.ok(allActors);
    }
    
    @GetMapping("/search")
    public ResponseEntity getActorByName(@RequestParam String name) {
    	List<Actor> allActorsByName = actorService.findByName(name);
    	return ResponseEntity.ok(allActorsByName);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getActorById(@PathVariable Long id) {
    	Optional<Actor> actor = actorService.findById(id);
    	
    	
    	if(actor.isPresent()){
    		return ResponseEntity.ok(actor.get());
    	} else {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Actor with ID " + id + " not found");
    	}	
    }
    
    @PutMapping("/{id}")
    public ResponseEntity updateActor(@PathVariable Long id, @RequestBody UpdateActorDTO data) {
    	Actor actor = actorService.findReferenceById(id);
    	actor.setName(data.name());
    	actor.setAge(data.age());
    	actorService.save(actor);
    	return ResponseEntity.ok(new UpdateActorDTO(actor));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteActor(@PathVariable Long id) {
    	actorService.delete(actorService.findReferenceById(id));
    	return ResponseEntity.ok().build();
    }
    
    
}
