package br.com.marcos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.dto.MangaRequestDto;
import br.com.marcos.model.Genre;
import br.com.marcos.model.Manga;
import br.com.marcos.service.MangaService;

@RestController
@RequestMapping(value = "/manga")
public class MangaController {
	@Autowired
	MangaService service;
	
	@PostMapping
	public ResponseEntity<Manga> saveManga(@RequestBody MangaRequestDto mangaRequestDto){
		   Manga manga = new Manga();
		    manga.setName(mangaRequestDto.name());
		    manga.setAuthor(mangaRequestDto.author());
		    manga.setAverageNota(mangaRequestDto.averageNota());

		    // Converter List<GenreDto> para List<Genre>
		    List<Genre> genres = mangaRequestDto.genres().stream()
		        .map(genreDto -> new Genre(genreDto.name())) // Supondo que Genre tenha um construtor que aceita nome
		        .toList();
		service.saveManga(manga,genres);
		
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping
	public ResponseEntity<List<Manga>> getAllManga(){
		List<Manga> allManga = service.getAllManga();
		return ResponseEntity.ok(allManga);
	}
}
