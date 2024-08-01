package br.com.marcos.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marcos.model.Manga;
import br.com.marcos.model.Note;
@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{
	
	List<Note> findByManga(Manga manga);
}
