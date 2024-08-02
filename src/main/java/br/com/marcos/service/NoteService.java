package br.com.marcos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.model.Manga;
import br.com.marcos.model.Note;
import br.com.marcos.repository.MangaRepository;
import br.com.marcos.repository.NoteRepository;

@Service
public class NoteService {
	@Autowired
	NoteRepository noteR;
	@Autowired
	MangaRepository mangaR;
	
	public void saveNoteByManga(Long id, Note note) {
		Optional<Manga> m = mangaR.findById(id);
		Manga manga = m.get();
		note.setManga(manga);
		manga.getNotes().add(note);
		
		mangaR.save(manga);
	
	}
}
