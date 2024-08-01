package br.com.marcos.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.marcos.model.Manga;
import br.com.marcos.model.Note;
import br.com.marcos.model.repository.MangaRepository;
import br.com.marcos.model.repository.NoteRepository;

@Service
public class NoteService {
	NoteRepository noteR;
	MangaRepository mangaR;
	
	public void saveNoteByManga(Long id, Note note) {
		Optional<Manga> m = mangaR.findById(id);
		Manga manga = m.get();
		note.setManga(manga);
		manga.getNotes().add(note);
		
		mangaR.save(manga);
	
	}
}
