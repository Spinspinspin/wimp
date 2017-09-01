package com.libertymutual.goforcode.wimp.api;

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

import com.libertymutual.goforcode.wimp.models.Award;
import com.libertymutual.goforcode.wimp.repositories.AwardRepository;

@RestController
@RequestMapping("/api/awards")


public class AwardApiController {

//	private AwardRepository awardRepo;
//	
//	public AwardApiController(AwardRepository awardRepo) {
//		this.awardRepo = awardRepo;
//		
//		awardRepo.save(new Award("Best Actress", "AMPAS", 2012));
//		awardRepo.save(new Award("Best Supporting Actor", "AMPAS", 1987));
//		awardRepo.save(new Award("Outstanding Lead Actress in a Comedy Series Emmy", "ATAS", 2008));
//		awardRepo.save(new Award("Outstanding Performer in an Animated Program Daytime Emmy", "ATAS", 2012));
//	}
//	
//	@GetMapping("")
//	public List<Award> getAll() {
//		return awardRepo.findAll();
//	}
//	
//	@GetMapping ("{id}")
//	public Award getOne(@PathVariable long id) throws StuffNotFoundException {
//		Award award = awardRepo.findOne(id);
//		if (award == null) {
//			throw new StuffNotFoundException();
//		}
//			return award;
//		}
//		
//	
//	@DeleteMapping("{id}")
//	public Award delete(@PathVariable long id) {
//		try {
//		Award award = awardRepo.findOne(id);
//		awardRepo.delete(id);
//		return award;
//		} catch (EmptyResultDataAccessException erdae) {
//			return null;
//		}
//	}
//	
//	@PostMapping("")
//	public Award create(@RequestBody Award award) {
//		return awardRepo.save(award);
//	}
//	
//	@PutMapping("{id}")
//	public Award update(@RequestBody Award award, @PathVariable long id) {
//		award.setId(id);
//		return awardRepo.save(award);
//	}
}
