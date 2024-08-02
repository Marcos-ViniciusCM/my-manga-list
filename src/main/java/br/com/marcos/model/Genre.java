package br.com.marcos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long genre_id;
	
	private String name;
	
	@ManyToOne
	private Manga manga;

	 

	
	
	

	public Genre(Long genre_id, String name, Manga manga) {
		
		this.genre_id = genre_id;
		this.name = name;
		this.manga = manga;
	}



	public Genre(String name) {
		super();
		this.name = name;
	}



	public Genre(String name, Manga manga) {
		super();
		this.name = name;
		this.manga = manga;
	}



	public Long getGenre_id() {
		return genre_id;
	}



	public void setGenre_id(Long genre_id) {
		this.genre_id = genre_id;
	}





	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Manga getManga() {
		return manga;
	}

	public void setManga(Manga manga) {
		this.manga = manga;
	}
	
	
	
	
}
