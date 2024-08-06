package br.com.marcos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marcos.model.Manga;
@Repository
public interface MangaRepository extends JpaRepository<Manga, Long>{
	
}
