package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Addon;
import com.example.jeedemo.domain.Car;
import com.example.jeedemo.domain.Osoba;
import com.example.jeedemo.domain.Person;
import com.example.jeedemo.domain.Osoba;
import com.example.jeedemo.domain.Sweter;

@Stateless
public class OsobaManager {

	@PersistenceContext
	EntityManager om;

	public void addOsoba(Osoba osoba) {
		
		osoba.setId(null);
				
		om.persist(osoba);
	}
	
	//set sweter free before delete osoba
	public void deleteOsoba(Osoba osoba) {
		osoba = om.find(Osoba.class, osoba.getId());
		List<Sweter> ownedSweter = new ArrayList<Sweter>(getOwnedSweter(osoba));
		for (Sweter s : ownedSweter){
			s.setOwner(null);
			s.setGotOwner(false);
		}
		om.remove(osoba);
	}

	@SuppressWarnings("unchecked")
	public List<Osoba> getAllOsoba() {
		return om.createNamedQuery("osoba.all").getResultList();
	}
	
	public List<Sweter> getOwnedSweter(Osoba osoba) {
		osoba = om.find(Osoba.class, osoba.getId());
		// lazy loading here - try this code without this (shallow) copying
		List<Sweter> sweters = new ArrayList<Sweter>(osoba.getSwetry());
		return sweters;
	}
	
	public void disposeSweter(Osoba osoba, Sweter sweter) {

		osoba = om.find(Osoba.class, osoba.getId());
		sweter = om.find(Sweter.class, sweter.getId());

		Sweter toRemove = null;
		// lazy loading here (person.getCars)
		for (Sweter aSweter : osoba.getSwetry())
			if (aSweter.getId().compareTo(sweter.getId()) == 0) {
				toRemove = aSweter;
				break;
			}

		if (toRemove != null)
			osoba.getSwetry().remove(toRemove);
		
		sweter.setGotOwner(false);
		sweter.setOwner(null);
	}
	
	public void editOsoba(Osoba osoba){
		om.merge(osoba);
	}
	

}
