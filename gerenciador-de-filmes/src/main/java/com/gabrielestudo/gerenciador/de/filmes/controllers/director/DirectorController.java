package com.gabrielestudo.gerenciador.de.filmes.controllers.director;


import org.springframework.web.bind.annotation.RestController;
import com.gabrielestudo.gerenciador.de.filmes.entities.Director;
import com.gabrielestudo.gerenciador.de.filmes.services.DirectorService;
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
@RequestMapping("/directors")
public class DirectorController {
	
	@Autowired
	private DirectorService directorService;
	
    @PostMapping("/")
    public ResponseEntity registerActor(@RequestBody RequestDirectorDTO data){
    	Director newDir = new Director(data);
    	directorService.save(newDir);
    	return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping("/all")
    public ResponseEntity getAllActors() {
    	List<Director> allActors = directorService.findAll();
    	return ResponseEntity.ok(allActors);
    }
    
    @GetMapping("/search")
    public ResponseEntity getActorByName(@RequestParam String name) {
    	List<Director> allActorsByName = directorService.findByName(name);
    	return ResponseEntity.ok(allActorsByName);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getActorById(@PathVariable Long id) {
    	Optional<Director> actor = directorService.findById(id);
    	
    	
    	if(actor.isPresent()){
    		return ResponseEntity.ok(actor.get());
    	} else {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Actor with ID " + id + " not found");
    	}	
    }
    
    @PutMapping("/{id}")
    public ResponseEntity updateActor(@PathVariable Long id, @RequestBody UpdateDirectorDTO data) {
    	Director director = directorService.findReferenceById(id);
    	director.setName(data.name());
    	director.setAge(data.age());
    	directorService.save(director);
    	return ResponseEntity.ok(new UpdateDirectorDTO(director));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteActor(@PathVariable Long id) {
    	directorService.delete(directorService.findReferenceById(id));
    	return ResponseEntity.ok().build();
    }
    
    
}
