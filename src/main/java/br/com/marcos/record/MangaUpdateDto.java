package br.com.marcos.record;

import java.util.List;

import br.com.marcos.model.Genre;

public record MangaUpdateDto(Long id,String name, String author,List<Genre> genres) {

}
