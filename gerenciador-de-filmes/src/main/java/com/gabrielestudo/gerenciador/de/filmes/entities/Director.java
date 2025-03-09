package com.gabrielestudo.gerenciador.de.filmes.entities;

import java.time.Instant;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.gabrielestudo.gerenciador.de.filmes.controllers.actor.RequestActorDTO;
import com.gabrielestudo.gerenciador.de.filmes.controllers.director.RequestDirectorDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "directors")
public class Director {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "age", nullable = false)
	private int age;
	
	@CreationTimestamp
	private Instant creationTimestamp;
	
	@UpdateTimestamp
	private Instant updatedTimestamp;
	
	
	public Director(RequestDirectorDTO requestDir){
		this.name = requestDir.name();
		this.age = requestDir.age();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Director other = (Director) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id,name);
	}
	
	
	
}
