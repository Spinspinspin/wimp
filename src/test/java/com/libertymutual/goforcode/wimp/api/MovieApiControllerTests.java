package com.libertymutual.goforcode.wimp.api;

import static org.assertj.core.api.Assertions.*;


import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.repositories.ActorRepository;
import com.libertymutual.goforcode.wimp.repositories.MovieRepository;

public class MovieApiControllerTests {

	private MovieRepository movieRepo;
	ActorRepository actorRepo;
	private MovieApiController mController;
	private ActorApiController aController;
	
	@Before
	public void setUp() {
		movieRepo = mock(MovieRepository.class);
		actorRepo = mock(ActorRepository.class);
		mController = new MovieApiController(movieRepo, actorRepo);
		aController = new ActorApiController(actorRepo);
	}
	
	@Test
	public void test_getAll_returns_all_movies_returned_by_the_repo() {
		//Arrange
		ArrayList<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie());
		movies.add(new Movie());
		
		
		when(movieRepo.findAll()).thenReturn(movies);
		//Act
		List<Movie> actual = mController.getAll();
				
		//Asserts
		assertThat(actual.size()).isEqualTo(2);	
		assertThat(actual.get(1)).isSameAs(movies.get(1));
		verify(movieRepo).findAll();
		}

	@Test
	public void test_getOne_returns_Movie_returned_from_repo() throws StuffNotFoundException {
		// Arrange
		Movie primer = new Movie();
		when(movieRepo.findOne(7L)).thenReturn(primer);
		
		//Act
		Movie actual = mController.getOne(7L);
		
		//Assert
		assertThat(actual).isSameAs(primer);
		verify(movieRepo).findOne(7L);
	}

	@Test
	public void test_getOne_throws_StuffNotFound_when_no_Movie_returned_from_repo() {
		try {
			mController.getOne(1);
			fail("The mController did not throw the StuffNotFoundException");
			
		}catch(StuffNotFoundException snfe) {}
	}

	@Test
	public void test_delete_returns_movie_deleted_when_found() {
		//Arrange
		Movie movie= new Movie();
		when(movieRepo.findOne(7L)).thenReturn(movie);
		
		//Act
		Movie actual = mController.delete(7L);
		
		//Assert
		assertThat(movie).isSameAs(actual);
		verify(movieRepo).delete(7L);
		verify(movieRepo).findOne(7L);
	}

	@Test
	public void test_that_null_is_returned_when_findOne_throws_EmptyResultDataAccessException() throws StuffNotFoundException {
		//arrange
		when(movieRepo.findOne(7L)).thenThrow(new EmptyResultDataAccessException(0));
		
		//Act
		Movie actual = mController.delete(7L);
		
		//Assert
		assertThat(actual).isNull();
		verify(movieRepo).findOne(7L);
		
	}

	@Test
	public void test_create_returns_movie_and_updates_movieRepo() {
		//Arrange
		Movie newMovie= new Movie();
		when(movieRepo.save(newMovie)).thenReturn(newMovie);
		
		//Act
		Movie actual = mController.create(newMovie);
		
		//Assert
		assertThat(newMovie).isSameAs(actual);
		
	}

	@Test
	public void test_update_upates_movieRepo_and_returns_updated_movie() {
		//Arrange
		Movie updateMovie = new Movie();

		when(movieRepo.save(updateMovie)).thenReturn(updateMovie);
		
		//Act
		Movie actual = mController.update(updateMovie, 7L);
		
		//Assert
		assertThat(updateMovie).isSameAs(actual);
		
	}

	@Test
	public void test_getOne_returns_Movie_and_getOne_returns_Actor_and_add_adds_the_actor_to_the_movie_and_save_updates_movieRepo() throws StuffNotFoundException {
		// Arrange
		Movie primer = new Movie();
		Actor calculon = new Actor();
		calculon.setId(7L);
		when(movieRepo.findOne(8L)).thenReturn(primer);
		when(actorRepo.findOne(7L)).thenReturn(calculon);
		
		
		
		
		//Act
		Movie actualM = mController.associateAnActor(8L, calculon);
		
		//Assert
		assertThat(actualM).isSameAs(primer);
		verify(movieRepo).findOne(8L);
		verify(actorRepo).findOne(7L);
		assertThat(primer.getActors()).contains(calculon);
		verify(movieRepo).save(primer);
		
		} 












}
