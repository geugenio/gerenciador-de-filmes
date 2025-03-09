package com.gabrielestudo.gerenciador.de.filmes.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "movies")
public class Movie {
	
	public Movie(String name, int releaseYear, String genre) {
		this.name = name;
		this.releaseYear=releaseYear;
		this.genre = genre;
		this.cast = null;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "releaseYear", nullable = false)
	private int releaseYear;
	
	@Column(name = "genre", nullable = false)
	private String genre;
	
	@CreationTimestamp
	private Instant creationTimestamp;
	
	@UpdateTimestamp
	private Instant updatedTimestamp;
	
	
	@ManyToOne //um filme tem 1 diretor, 1 diretor tem varios filmes
	@JoinColumn(name = "director_id", nullable = false) //Chave estrangeira para diretor
	private Director director;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //um filme tem varios atores, um ator pode estar em varios filmes
	@JoinTable( //tabela intermediaria filme-ator, associação de ID's
			name = "movie_actor", 
			joinColumns = @JoinColumn(name = "movie_id"),
			inverseJoinColumns = @JoinColumn(name = "actor_id")
			)
	private Set<Actor> cast = new HashSet<>();
}
