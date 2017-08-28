package com.libertymutual.goforcode.wimp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Actor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length=75)
	private String firstName;

	@Column(nullable = true, length=75)
	private String lastName;
	
	@Column (nullable = true)
	private Long activeSinceYear;
	
	@Column (nullable = true)
	private Date birthDate;
}
