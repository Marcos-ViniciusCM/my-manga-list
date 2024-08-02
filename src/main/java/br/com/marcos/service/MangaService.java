package br.com.marcos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.model.Genre;
import br.com.marcos.model.Manga;
import br.com.marcos.repository.MangaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MangaService {
	
	@Autowired
	MangaRepository mangaR;
	
	public void saveManga(Manga m, List<Genre> genres) {
		 m.setGenreManga(genres);
		 mangaR.save(m);  
	}
	@Transactional(readOnly = true)
	public List<Manga> getAllManga() {
		return mangaR.findAll();
	}
	
	public Manga updateManga(List<Genre> genres , Manga m) {
		var entity = mangaR.findById(m.getId());
		if(entity.isPresent()) {
			Manga manga = entity.get();
			manga.setAuthor(m.getAuthor());
			manga.setName(m.getName());
			return mangaR.save(manga);
		}
		return null;
	}
	
	public void deleteManga(Long id) {
		
		mangaR.deleteById(id);
	}
	
	public Optional<Manga> getById(Long id) {
		return mangaR.findById(id);
	}
	
	public List<Manga>findMangaByGenre(String genreName){
		return mangaR.findBygenreMangaNameContainingIgnoreCase(genreName);
	}
	
	public List<Manga>findAllMangaByAverageNotaDesc(){
		return mangaR.findAllByOrderByAverageNotaDesc();
	}

}
