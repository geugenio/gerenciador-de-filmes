package com.gabrielestudo.gerenciador.de.filmes.controllers.director;

import com.gabrielestudo.gerenciador.de.filmes.entities.Director;

public record UpdateDirectorDTO(String name, int age) {
	public UpdateDirectorDTO(Director dir) {
		this(dir.getName(), dir.getAge());
	}
}
