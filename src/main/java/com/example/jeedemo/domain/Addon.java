package com.example.jeedemo.domain;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Addon {

	private Long id;
	private String addonName;
	
	private List<Sweter> swetry = new ArrayList<Sweter>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddonName() {
		return addonName;
	}

	public void setAddonName(String addonName) {
		this.addonName = addonName;
	}

	@OneToMany(cascade = CascadeType.ALL)
	public List<Sweter> getSwetry() {
		return swetry;
	}

	public void setSwetry(List<Sweter> swetry) {
		this.swetry = swetry;
	}
	
	
	
}
