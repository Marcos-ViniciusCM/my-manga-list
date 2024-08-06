package br.com.marcos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.model.Genre;
import br.com.marcos.repository.GenreRepository;
@Service
public class GenreService {
	
	 @Autowired
	 GenreRepository repository;

    
	public void saveGenre(List<Genre> genres) {
		repository.saveAll(genres);
	}
}
