package br.com.marcos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.model.Genre;
import br.com.marcos.model.Manga;
import br.com.marcos.service.MangaService;

@RestController
@RequestMapping(value = "/manga")
public class MangaController {
	@Autowired
	MangaService service;
	
	@PostMapping
	public ResponseEntity<Manga> saveManga(Manga manga,List<Genre> genres){
		service.saveManga(manga, genres);
		
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping
	public ResponseEntity<List<Manga>> getAllManga(){
		var allManga = service.getAllManga();
		return ResponseEntity.ok(allManga);
	}
}
