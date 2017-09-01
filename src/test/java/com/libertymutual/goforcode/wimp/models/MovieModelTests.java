package com.libertymutual.goforcode.wimp.models;

import static org.assertj.core.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MovieModelTests {

Movie movie;
	
	@Before
	public void setUp() {
		movie = new Movie();
	}
	
	@Test
	public void test_to_set_up_constructor() {
		//Arrange
		
		
		//Act
		Movie actual = new Movie("Harry Potter and the Goblet of Fire", 2005, 150000000, "Warner Bros. Pictures");
		
		//Asserts
		
		assertThat(actual.getTitle()).isEqualTo("Harry Potter and the Goblet of Fire");
		assertThat(actual.getReleaseDate()).isEqualTo(2005);
		assertThat(actual.getBudget()).isEqualTo(150000000);
		assertThat(actual.getDistributor()).isEqualTo("Warner Bros. Pictures");
	}
	
	@Test
	public void test_to_get_and_set_Id() {
		//Arrange
		movie.setId(7L);
		
		//Act
		movie.getId();
		
		//Asserts
		
		assertThat(movie.getId()).isSameAs(7L);
	}
	
	@Test
	public void test_to_get_and_set_title() {
		//Arrange
		movie.setTitle("Cube");
		
		//Act
		movie.getTitle();
		
		//Asserts
		
		assertThat(movie.getTitle()).isSameAs("Cube");
	}
		
	@Test
	public void test_to_get_and_set_releaseDate() {
		//Arrange
		movie.setReleaseDate(1997);
		
		//Act
		movie.getReleaseDate();
		
		//Asserts
		
		assertThat(movie.getReleaseDate()).isEqualTo(1997);
	}
	
	@Test
	public void test_to_get_and_set_budget() {
		//Arrange
		movie.setBudget(350000);
		
		//Act
		movie.getBudget();
		
		//Asserts
		
		assertThat(movie.getBudget()).isEqualTo(350000);
	}

	@Test
	public void test_to_get_and_set_distributer() {
		//Arrange
		movie.setDistributor("Trimark Pictures");
		
		//Act
		movie.getDistributor();
		
		//Asserts
		
		assertThat(movie.getDistributor()).isSameAs("Trimark Pictures");
	}
	
	@Test
	public void test_to_get_and_set_movies() {
		//Arrange
		ArrayList<Actor> actors = new ArrayList<Actor>();
		movie.setActors(actors);
		
		//Act
		movie.getActors();
		
		//Asserts
		
		assertThat(movie.getActors()).containsAll(actors);
	}

}
