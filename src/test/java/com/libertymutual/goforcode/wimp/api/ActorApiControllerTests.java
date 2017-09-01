package com.libertymutual.goforcode.wimp.api;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;



import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.repositories.ActorRepository;


public class ActorApiControllerTests {
	
	private ActorRepository actorRepo;
	private ActorApiController controller;
	
	@Before
	public void setUp() {
		actorRepo = mock(ActorRepository.class);
		controller = new ActorApiController(actorRepo);
	}

	@Test
	public void test_getAll_returns_all_actors_returned_by_the_repo() {
		//Arrange
		ArrayList<Actor> actors = new ArrayList<Actor>();
		actors.add(new Actor());
		actors.add(new Actor());
		
		
		when(actorRepo.findAll()).thenReturn(actors);
		
		
		
		//Act
		List<Actor> actual = controller.getAll();
		
		//Asserts
		assertThat(actual.size()).isEqualTo(2);	
		assertThat(actual.get(1)).isSameAs(actors.get(1));
		verify(actorRepo).findAll();
	}
	
	@Test
	public void test_getOne_returns_Actor_returned_from_repo() throws StuffNotFoundException {
		// Arrange
		Actor calculon = new Actor();
		when(actorRepo.findOne(7L)).thenReturn(calculon);
		
		//Act
		Actor actual = controller.getOne(7L);
		
		//Assert
		assertThat(actual).isSameAs(calculon);
		verify(actorRepo).findOne(7L);
	}
	
	@Test
	public void test_getOne_throws_StuffNotFound_when_no_Actor_returned_from_repo() {
		try {
			controller.getOne(1);
			fail("The controller did not throw the StuffNotFoundException");
			
		}catch(StuffNotFoundException snfe) {}
	}
	
	@Test
	public void test_delete_returns_actor_deleted_when_found() {
		//Arrange
		Actor actor= new Actor();
		when(actorRepo.findOne(7L)).thenReturn(actor);
		
		//Act
		Actor actual = controller.delete(7L);
		
		//Assert
		assertThat(actor).isSameAs(actual);
		verify(actorRepo).delete(7L);
		verify(actorRepo).findOne(7L);
	}
	
	@Test
	public void test_that_null_is_returned_when_findOne_throws_EmptyResultDataAccessException() throws StuffNotFoundException {
		//arrange
		when(actorRepo.findOne(7L)).thenThrow(new EmptyResultDataAccessException(0));
		
		//Act
		Actor actual = controller.delete(7L);
		
		//Assert
		assertThat(actual).isNull();
		verify(actorRepo).findOne(7L);
		
	}
	
	@Test
	public void test_create_returns_actor_and_updates_actorRepo() {
		//Arrange
		Actor newActor= new Actor();
		when(actorRepo.save(newActor)).thenReturn(newActor);
		
		//Act
		Actor actual = controller.create(newActor);
		
		//Assert
		assertThat(newActor).isSameAs(actual);
		
	}
	
	@Test
	public void test_update_upates_actorRepo_and_returns_updated_actor() {
		//Arrange
		Actor updateActor = new Actor();

		when(actorRepo.save(updateActor)).thenReturn(updateActor);
		
		//Act
		Actor actual = controller.update(updateActor, 7L);
		
		//Assert
		assertThat(updateActor).isSameAs(actual);
		
	}
	
	

}
















