package com.libertymutual.goforcode.wimp.models;

import static org.assertj.core.api.Assertions.*;


import java.sql.Date;
import java.util.ArrayList;


import org.junit.Before;
import org.junit.Test;

public class ActorModelTests {

	Actor actor;
	
	@Before
	public void setUp() {
		actor = new Actor();
	}

	@Test
	public void test_to_set_up_constructor() {
		//Arrange
		
		
		//Act
		Actor actual = new Actor("David", "Tennant", 1987, new Date(Date.parse("04/18/1971")));
		
		//Asserts
		
		assertThat(actual.getFirstName()).isEqualTo("David");
		assertThat(actual.getLastName()).isEqualTo("Tennant");
		assertThat(actual.getActiveSinceYear()).isEqualTo(1987);
		assertThat(actual.getBirthDate()).isEqualTo(new Date(Date.parse("04/18/1971")));
	}	
	
	@Test
	public void test_to_get_and_set_Id() {
		//Arrange
		actor.setId(7L);
		
		//Act
		actor.getId();
		
		//Asserts
		
		assertThat(actor.getId()).isSameAs(7L);
	}
	
	@Test
	public void test_to_get_and_set_firstName() {
		//Arrange
		actor.setFirstName("Dan");
		
		//Act
		actor.getFirstName();
		
		//Asserts
		
		assertThat(actor.getFirstName()).isSameAs("Dan");
	}
	
	@Test
	public void test_to_get_and_set_lastName() {
		//Arrange
		actor.setLastName("Spin");
		
		//Act
		actor.getLastName();
		
		//Asserts
		
		assertThat(actor.getLastName()).isSameAs("Spin");
	}
	
	@Test
	public void test_to_get_and_set_activeSinceYear() {
		//Arrange
		actor.setActiveSinceYear(1980);
		
		//Act
		actor.getActiveSinceYear();
		
		//Asserts
		
		assertThat(actor.getActiveSinceYear()).isEqualTo(1980);
	}
	
	@Test
	public void test_to_get_and_set_birthDate() {
		//Arrange
		actor.setBirthDate(new Date(Date.parse("03/16/1980")));
		
		//Act
		actor.getBirthDate();
		
		//Asserts
		
		assertThat(actor.getBirthDate()).isEqualTo(new Date(Date.parse("03/16/1980")));
	}
	
	@Test
	public void test_to_get_and_set_movies() {
		//Arrange
		ArrayList<Movie> movies = new ArrayList<Movie>();
		actor.setMovies(movies);
		
		//Act
		actor.getMovies();
		
		//Asserts
		
		assertThat(actor.getMovies()).containsAll(movies);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
