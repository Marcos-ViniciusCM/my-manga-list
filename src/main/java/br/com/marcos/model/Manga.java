package br.com.marcos.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import br.com.marcos.record.MangaRequestDto;
import br.com.marcos.record.MangaUpdateDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	
	@ManyToMany
    @JoinTable(
        name = "manga_genre",
        joinColumns = @JoinColumn(name = "manga_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
	private List<Genre> genreManga;
	
	 @Value("${some.key:0}")
    private Double averageNota;
	
    @Value("${some.key:0}")
	private int peopleVote;
	

	
	
	



	public Manga(Long id, @NotBlank(message = "cannot be blank") String name,
			@NotBlank(message = "cannot be blank") String author, List<Genre> genreManga, Double averageNota,
		 int peopleVote) {
		
		this.id = id;
		this.name = name;
		this.author = author;
		this.genreManga = genreManga;
		this.averageNota = averageNota;
		this.peopleVote = peopleVote;
	}





	public Manga(MangaRequestDto manga, List<Genre> genres) {
		this.name = manga.name();
		this.author = manga.author();
		this.genreManga = genres;
		this.averageNota = 0.0;
		this.peopleVote = 0;
	}

	public Manga(MangaUpdateDto manga, List<Genre> genres) {
		this.id = manga.id();
		this.name = manga.name();
		this.author = manga.author();
		this.genreManga = genres;
		this.averageNota = 0.0;
		this.peopleVote = 0;
	}



	public Manga(@NotBlank(message = "cannot be blank") String name,
			@NotBlank(message = "cannot be blank") String author, List<Genre> genreManga, Double averageNota) {
		
		this.name = name;
		this.author = author;
		this.genreManga = genreManga;
		this.averageNota = averageNota;	
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



	public int getPeopleVote() {
		return peopleVote;
	}





	public void setPeopleVote(int peopleVote) {
		this.peopleVote = peopleVote;
	}
	
	

	
	
}
