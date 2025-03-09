package com.gabrielestudo.gerenciador.de.filmes.controllers.movie;

import java.util.Set;

public record createMovieDTO(String name, int releaseYear, String genre, Long directorId, Set<Long> actorsId) {
}
