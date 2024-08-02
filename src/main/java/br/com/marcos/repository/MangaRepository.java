package br.com.marcos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.marcos.model.Genre;
import br.com.marcos.model.Manga;
@Repository
public interface MangaRepository extends JpaRepository<Manga, Long>{
		
	List<Manga> findBygenreMangaNameContainingIgnoreCase(String genreName);
	 //@Query("SELECT m FROM Manga m JOIN m.notas n GROUP BY m ORDER BY AVG(n.value) DESC")
	 List<Manga> findAllByOrderByAverageNotaDesc();
}
