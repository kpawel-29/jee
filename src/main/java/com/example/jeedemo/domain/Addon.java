package com.example.jeedemo.domain;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({ 
	@NamedQuery(name = "addon.all", query = "Select a from Addon a")
	})
public class Addon {

	private Long id;
	private String addonName  ="kieszenie";
	
	private List<Sweter> swetry = new ArrayList<Sweter>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
//zamienione miejscami wzgledem przykladu addon_id i sweter_id
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="SWETER_ADDON", 
				joinColumns={@JoinColumn(name="ADDON_ID")},
				inverseJoinColumns={@JoinColumn(name="SWETER_ID")})
	public List<Sweter> getSwetry() {
		return swetry;
	}

	public void setSwetry(List<Sweter> swetry) {
		this.swetry = swetry;
	}
	
	
	
}
