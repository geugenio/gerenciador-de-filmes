package com.gabrielestudo.gerenciador.de.filmes.controllers.actor;

import com.gabrielestudo.gerenciador.de.filmes.entities.Actor;

public record UpdateActorDTO(String name, int age) {
	public UpdateActorDTO(Actor actor) {
		this(actor.getName(), actor.getAge());
	}
}
