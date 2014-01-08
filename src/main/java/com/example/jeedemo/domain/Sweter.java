package com.example.jeedemo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "sweter.all", query = "Select s from Sweter s")
})
public class Sweter {

	private Long id;
	private String name = "unknown";
	private int size = 0;
	private String color = "blue";
	
	//private Addon addon;
	
	private List<Osoba> owner;
	/*private String[] osobaList = {
             "Marek", "Janek", "Bolek", "Marysia"                        
	};*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Osoba> getOwner() {
		return owner;
	}
	public void setOwner(List<Osoba> owner) {
		this.owner = owner;
	}
		
}
