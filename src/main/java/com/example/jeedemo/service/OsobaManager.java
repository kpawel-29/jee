package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Addon;
import com.example.jeedemo.domain.Car;
import com.example.jeedemo.domain.Osoba;
import com.example.jeedemo.domain.Person;
import com.example.jeedemo.domain.Osoba;

@Stateless
public class OsobaManager {

	@PersistenceContext
	EntityManager om;

	public void addOsoba(Osoba osoba) {
		
		osoba.setId(null);
				
		om.persist(osoba);
	}
	

	public void deleteOsoba(Osoba osoba) {
		osoba = om.find(Osoba.class, osoba.getId());
		om.remove(osoba);
	}

	@SuppressWarnings("unchecked")
	public List<Osoba> getAllOsoba() {
		return om.createNamedQuery("osoba.all").getResultList();
	}


}
