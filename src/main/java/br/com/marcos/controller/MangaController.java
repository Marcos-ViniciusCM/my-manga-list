package br.com.marcos.controller;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.model.Genre;
import br.com.marcos.model.Manga;
import br.com.marcos.record.MangaRequestDto;
import br.com.marcos.record.MangaUpdateDto;
import br.com.marcos.service.GenreService;
import br.com.marcos.service.MangaService;

@RestController
@RequestMapping(value = "/manga")
public class MangaController {
	private final MangaService mangaService;
    private final GenreService genreService;

    public MangaController(MangaService mangaService, GenreService genreService) {
        this.mangaService = mangaService;
        this.genreService = genreService;
    }

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MangaRequestDto> saveManga(@RequestBody MangaRequestDto mangaRequestDto){
		   

		    // Converter List<GenreDto> para List<Genre>
		    List<Genre> genres = mangaRequestDto.genres().stream()
		        .map(genreDto -> new Genre(genreDto.name())) // Supondo que Genre tenha um construtor que aceita nome
		        .toList();
			
		    genreService.saveGenre(genres);
		mangaService.saveMangaAndGenre(mangaRequestDto,genres);
		
		return ResponseEntity.ok(mangaRequestDto);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Manga>> getAllManga(){
		Sort sort = Sort.by("averageNota").descending().and(Sort.by("name").ascending());
		List<Manga> allManga = mangaService.getAllManga(sort);
		
		
		return ResponseEntity.ok(allManga);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateManga(@RequestBody MangaUpdateDto updateDto){
		
		mangaService.updateManga(updateDto.genres(), updateDto);
		return ResponseEntity.ok().build();
	}
	@DeleteMapping
	public ResponseEntity<?> deleteAll(){
		mangaService.deleteAll();
		return ResponseEntity.noContent().build();

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAll(@PathVariable Long id){
		mangaService.deleteMangaById(id);
		return ResponseEntity.noContent().build();
	}
}
