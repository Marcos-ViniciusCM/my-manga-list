package br.com.marcos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.marcos.exceptionResponse.ResourceNotFoundException;
import br.com.marcos.model.Genre;
import br.com.marcos.model.Manga;
import br.com.marcos.record.MangaRequestDto;
import br.com.marcos.record.MangaUpdateDto;
import br.com.marcos.repository.GenreRepository;
import br.com.marcos.repository.MangaRepository;

@Service
public class MangaService {
	
	@Autowired
	MangaRepository mangaRepository;
	
	@Autowired
	GenreRepository genreRepository;
	
	public void saveMangaAndGenre(MangaRequestDto mangaDto, List<Genre> genres) {
	    Manga mangaSaved = new Manga(mangaDto, genres);
	    mangaSaved.setGenreManga(genres);
	  
		mangaRepository.save(mangaSaved);  
	}
	
	
	public List<Manga> getAllManga(Sort sort) {
		
		return mangaRepository.findAll(sort);
	}
	
	public void saveManga(Manga manga) {
		mangaRepository.save(manga);
	}
	
	public Manga updateManga(List<Genre> genres , MangaUpdateDto mangaUpdate) {
		var entity = mangaRepository.findById(mangaUpdate.id()).orElseThrow(()->new ResourceNotFoundException("No manga Found for this id"));
	
		
		entity.setAuthor(mangaUpdate.author());
		entity.setName(mangaUpdate.name());
		
		  for (Genre genre : genres) {
		        if (genre.getGenre_id() == null) { // Verifique se o gênero é novo
		            genreRepository.save(genre); // Salve o novo gênero
		        }
		    }
		entity.setGenreManga(genres);
		
		
		return mangaRepository.save(entity);
	}
	
	
	public Manga getById(Long id) {
		return mangaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No manga For This id"));
	}
	
	
	public void deleteAll() {
		mangaRepository.deleteAll();
	}
	
	public void deleteMangaById(Long id) {
		mangaRepository.deleteById(id);
	}

}
