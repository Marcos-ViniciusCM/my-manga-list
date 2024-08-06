package br.com.marcos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.model.Manga;
import br.com.marcos.record.RatingRequestDto;
import br.com.marcos.service.MangaService;

@RestController
@RequestMapping(value = "/rating")
public class RatingController {

	
	@Autowired
	MangaService serviceManga;
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<?> ratingManga(@PathVariable Long id, @RequestBody RatingRequestDto ratingRequest) {
	   if(ratingRequest.rating() < 0 || ratingRequest.rating() > 5) {
		   return new ResponseEntity<>("vote failude", HttpStatus.BAD_REQUEST);
	   }
		Manga manga = serviceManga.getById(id);
	    int peoplesVote = manga.getPeopleVote();
	    Double rating = ratingRequest.rating();
	    Double averageNota = manga.getAverageNota();
	    
	    Double newAverageNota;
	    if (peoplesVote == 0) {
	       
	        newAverageNota = rating;
	    } else {
	        
	        newAverageNota = ((averageNota * peoplesVote) + rating) / (peoplesVote + 1);
	    }
	    manga.setPeopleVote(peoplesVote + 1);
	    manga.setAverageNota(newAverageNota);
	    serviceManga.saveManga(manga);
	    return new ResponseEntity<>("vote successful", HttpStatus.ACCEPTED);
	}

}
