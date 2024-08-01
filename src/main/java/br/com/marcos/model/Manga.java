package br.com.marcos.model;

import java.util.List;

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
	
	
	@OneToMany(mappedBy = "genre_id")
	private List<Genre> genreManga;
	
	
    private Double averageNota;
	
	private int Qtdnotes;
	
	@OneToMany(mappedBy = "note_id")
	private List<Note> notes;

	public Manga(Long id, @NotBlank(message = "cannot be blank") String name,
			@NotBlank(message = "cannot be blank") String author, List<Genre> genreManga, int qtdnotes,
			List<Note> notes) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.genreManga = genreManga;
		Qtdnotes = qtdnotes;
		this.notes = notes;
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

	public int getQtdnotes() {
		return Qtdnotes;
	}

	public void setQtdnotes(int qtdnotes) {
		Qtdnotes = qtdnotes;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Double getAverageNota() {
		return averageNota;
	}

	public void setAverageNota(Double averageNota) {
		this.averageNota = averageNota;
	}
	
	
	
}
