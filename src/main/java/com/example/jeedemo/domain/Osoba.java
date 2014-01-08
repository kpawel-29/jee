package com.example.jeedemo.domain;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "osoba.all", query = "Select o from Osoba o")
})
public class Osoba {

	private Long id;
	private String firstName ="Bolek";
	
	private List<Sweter> swetry = new ArrayList<Sweter>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@OneToMany(cascade = CascadeType.ALL)
	public List<Sweter> getSwetry() {
		return swetry;
	}

	public void setSwetry(List<Sweter> swetry) {
		this.swetry = swetry;
	}
	
	
	
}
