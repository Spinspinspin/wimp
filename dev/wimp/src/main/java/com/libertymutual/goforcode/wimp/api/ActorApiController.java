package com.libertymutual.goforcode.wimp.api;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.ActorWithMovies;
import com.libertymutual.goforcode.wimp.models.Award;
import com.libertymutual.goforcode.wimp.repositories.ActorRepository;
import com.libertymutual.goforcode.wimp.repositories.AwardRepository;

@RestController
@RequestMapping("/api/actors")

public class ActorApiController {

	private ActorRepository actorRepo;
	private AwardRepository awardRepo;
	
	public ActorApiController(ActorRepository actorRepo) {
		this.actorRepo = actorRepo;
		this.awardRepo = awardRepo;
		
		actorRepo.save(new Actor("Sean", "Connery", 1954, new Date(Date.parse("08/25/1930"))));
		actorRepo.save(new Actor("David", "Tennant", 1987, new Date(Date.parse("04/18/1971"))));
		actorRepo.save(new Actor("Jennifer", "Lawrence", 2006, new Date(Date.parse("08/15/1990"))));
		actorRepo.save(new Actor("Tina", "Fey", 1997, new Date(Date.parse("05/18/1970"))));
		
	}

	@GetMapping("")
	public List<Actor> getAll() {
		return actorRepo.findAll();
	}
	
	@PostMapping("{actorId}/awards")
	public Award associateAnActor(@PathVariable long awardId, @RequestBody Actor actor) {
		Award award = awardRepo.findOne(awardId);
		actor = actorRepo.findOne(actor.getId());
		award.addActor(actor);
		awardRepo.save(award);
		
		return award;
	}
	
	@GetMapping ("{id}")
	public Actor getOne(@PathVariable long id) throws StuffNotFoundException {
		Actor actor = actorRepo.findOne(id);
		if (actor == null) {
			throw new StuffNotFoundException();
		}
//			ActorWithMovies newActor = new ActorWithMovies();
//			newActor.setActiveSinceYear(actor.getActiveSinceYear());
//			newActor.setBirthDate(actor.getBirthDate());
//			newActor.setMovies(actor.getMovies());
//			newActor.setFirstName(actor.getFirstName());
//			newActor.setLastName(actor.getLastName());
//			newActor.setId(actor.getId());
//			return newActor;
		return actor;
		}
		
	
	@DeleteMapping("{id}")
	public Actor delete(@PathVariable long id) {
		try {
		Actor actor = actorRepo.findOne(id);
		actorRepo.delete(id);
		return actor;
		} catch (EmptyResultDataAccessException erdae) {
			return null;
		}
	}
	
	@PostMapping("")
	public Actor create(@RequestBody Actor actor) {
		return actorRepo.save(actor);
	}
	
	@PutMapping("{id}")
	public Actor update(@RequestBody Actor actor, @PathVariable long id) {
		actor.setId(id);
		return actorRepo.save(actor);
	}
}
