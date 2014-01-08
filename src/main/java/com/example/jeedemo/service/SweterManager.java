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
		sm.persist(sweter);
	}
	

	public void deleteSweter(Sweter sweter) {
		sweter = sm.find(Sweter.class, sweter.getId());
		sm.remove(sweter);
	}

	@SuppressWarnings("unchecked")
	public List<Sweter> getAllSweter() {
		return sm.createNamedQuery("sweter.all").getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Sweter> getAvailableSweter() {
		return sm.createNamedQuery("sweter.free").getResultList();
	}

	
	
	public void connect(Long sweterId, Long osobaId) {

		Sweter sweter = sm.find(Sweter.class, sweterId);
		Osoba osoba = sm.find(Osoba.class, osobaId);
		sweter.setGotOwner(true);
		osoba.getSwetry().add(sweter);
		sweter.setOwner(osoba);
	}

}
