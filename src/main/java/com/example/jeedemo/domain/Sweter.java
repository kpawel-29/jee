package com.example.jeedemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "sweter.all", query = "Select s from Sweter s"),
	@NamedQuery(name = "sweter.free", query = "Select s from Sweter s where s.gotOwner = false")
})
public class Sweter {

	private Long id;
	private String name = "kolorowy";
	private int size = 20;
	private String color = "blue";
	private boolean gotOwner = false;
	
	private Osoba owner;
	
	
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
	
	
	public boolean isGotOwner() {
		return gotOwner;
	}
	public void setGotOwner(boolean gotOwner) {
		this.gotOwner = gotOwner;
	}
	
	@ManyToOne
	public Osoba getOwner() {
		return owner;
	}
	public void setOwner(Osoba owner) {
		this.owner = owner;
	}
		
}
