package br.com.marcos.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.marcos.dto.MangaRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Manga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "cannot be blank")
	private String name;
	
	@NotBlank(message = "cannot be blank")
	private String author;
	
	@JsonIgnore 
	@OneToMany(mappedBy = "genre_id")
	private List<Genre> genreManga;
	
	
    private Double averageNota;
	
	
	@OneToMany(mappedBy = "note_id")
	private List<Note> notes;


	

	public Manga(Long id, @NotBlank(message = "cannot be blank") String name,
			@NotBlank(message = "cannot be blank") String author, List<Genre> genreManga, Double averageNota,
			List<Note> notes) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.genreManga = genreManga;
		this.averageNota = averageNota;
		this.notes = notes;
	}
	
	



	public Manga(@NotBlank(message = "cannot be blank") String name,
			@NotBlank(message = "cannot be blank") String author, List<Genre> genreManga, Double averageNota,
			List<Note> notes) {
		super();
		this.name = name;
		this.author = author;
		this.genreManga = genreManga;
		this.averageNota = averageNota;
		this.notes = notes;
	}





	public Manga() {
			
		}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getAuthor() {
		return author;
	}





	public void setAuthor(String author) {
		this.author = author;
	}





	public List<Genre> getGenreManga() {
		return genreManga;
	}





	public void setGenreManga(List<Genre> genreManga) {
		this.genreManga = genreManga;
	}





	public Double getAverageNota() {
		return averageNota;
	}





	public void setAverageNota(Double averageNota) {
		this.averageNota = averageNota;
	}





	public List<Note> getNotes() {
		return notes;
	}





	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}



//	public Manga(MangaRequestDto request) {
//		this.name = request.name();
//		this.author = request.Author();
//		this.genreManga = request.genres();
//		this.averageNota = request.rating();
//	}

	
	
}
