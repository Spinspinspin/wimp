package com.libertymutual.goforcode.wimp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//@Entity

public class Award {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
//	
//	@Column(nullable = false, length=500)
//	private String title;
//
//	@Column(nullable = true, length=200)
//	private String organization;
//	
//	@Column (nullable = true)
//	private int year;
//	
//	public Award() {}
//	
//	public Award( String title, String organization, int year) {
//		this.title = title;
//		this.organization = organization;
//		this.year = year;
//	}
//	
//	public void addActor(Actor actors) {
//		if (actors == null) {
//			actors = new Actor();
//		}
//		actors.add(actors);
//	}
//	
//	@ManyToOne
//	private Actor actors;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getOrganization() {
//		return organization;
//	}
//
//	public void setOrganization(String organization) {
//		this.organization = organization;
//	}
//
//	public int getYear() {
//		return year;
//	}
//
//	public void setYear(int year) {
//		this.year = year;
//	}
//
//	public List<Actor> getActors() {
//		return actors;
//	}
//
//	public void setActors(List<Actor> actors) {
//		this.actors = actors;
//	}
//
}
