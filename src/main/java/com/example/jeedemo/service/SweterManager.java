package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Addon;
import com.example.jeedemo.domain.Car;
import com.example.jeedemo.domain.Osoba;
import com.example.jeedemo.domain.Person;
import com.example.jeedemo.domain.Sweter;

@Stateless
public class SweterManager {

	@PersistenceContext
	EntityManager sm;
	
	

	public void addSweter(Sweter sweter) {
		
		sweter.setId(null);
		//osoba.setId(null);
		//addon.setId(null);
		//sm.persist(addon);
		//sm.persist(osoba);
		//sweter.setOwner(osoba);
		
		sm.persist(sweter);
/*
		List<Sweter> swetry = new ArrayList<Sweter>();
		swetry.add(sweter);
		
	
		Osoba bolek = new Osoba();
		bolek.setFirstName("Bolek");
		sm.persist(bolek);
		
		Osoba lolek = new Osoba();
		lolek.setFirstName("Lolek");
		sm.persist(lolek);*/
	}
	

	public void deleteSweter(Sweter sweter) {
		sweter = sm.find(Sweter.class, sweter.getId());
		sm.remove(sweter);
	}

	@SuppressWarnings("unchecked")
	public List<Sweter> getAllSweter() {
		return sm.createNamedQuery("sweter.all").getResultList();
	}


	public List<Osoba> getOwnedSweter(Sweter sweter) {
		sweter = sm.find(Sweter.class, sweter.getId());
		// lazy loading here - try this code without this (shallow) copying
		List<Osoba> osoby = new ArrayList<Osoba>(sweter.getOwner());
		return osoby;
	}
	
	public void connect(Long sweterId, Long osobaId) {

		Sweter sweter = sm.find(Sweter.class, sweterId);
		Osoba osoba = sm.find(Osoba.class, osobaId);
		
		sweter.getOwner().add(osoba);
	}

}
