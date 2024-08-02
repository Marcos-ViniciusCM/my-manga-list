package br.com.marcos.dto;

import java.util.List;

import br.com.marcos.model.Genre;
import br.com.marcos.model.Manga;

public record MangaRequestDto(
		String name,
	    String author,
	    Double averageNota,
	    List<GenreDto> genres
		) {

}
