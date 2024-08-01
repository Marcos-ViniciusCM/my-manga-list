package br.com.marcos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long note_id;
	
	private int rating;
	
	@ManyToOne
	@JoinColumn(name="manga_id")
	private Manga manga;

	

	public Note(Long note_id, int rating, Manga manga) {
		this.note_id = note_id;
		this.rating = rating;
		this.manga = manga;
	}
	
	

	public Long getNote_id() {
		return note_id;
	}



	public void setNote_id(Long note_id) {
		this.note_id = note_id;
	}



	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Manga getManga() {
		return manga;
	}

	public void setManga(Manga manga) {
		this.manga = manga;
	}
	
	
	
	
	
}
