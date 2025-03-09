package com.gabrielestudo.gerenciador.de.filmes.entities;

import java.time.Instant;
import java.util.Objects;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.gabrielestudo.gerenciador.de.filmes.controllers.actor.RequestActorDTO;

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
@Table(name = "actors")
public class Actor {	
	
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
	
	
	public Actor(RequestActorDTO requestActor){
		this.name = requestActor.name();
		this.age = requestActor.age();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Actor other = (Actor) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id,name);
	}
	
}
