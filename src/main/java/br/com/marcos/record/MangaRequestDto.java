package br.com.marcos.record;

import java.util.List;

public record MangaRequestDto(
		String name,
	    String author,
	    Double averageNota,
	    List<GenreDto> genres
		) {

}
