package br.com.marcos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marcos.model.Genre;
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

}
