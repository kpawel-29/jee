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
	
	@Inject
	AddonManager am;

	public void addSweter(Sweter sweter) {
		sweter.setId(null);
		sm.persist(sweter);
	}

	public void deleteSweter(Sweter sweter) {
		sweter = sm.find(Sweter.class, sweter.getId());
		sm.remove(sweter);
	}
	
	public void deleteSweterFromOsoba(Sweter sweter){
		sweter = sm.find(Sweter.class, sweter.getId());
		List<Osoba> osoby = sm.createNamedQuery("osoba.all").getResultList();
		for (Osoba osoba : osoby) {
			osoba = sm.find(Osoba.class, osoba.getId());
			osoba.getSwetry().remove(sweter);
		}
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
/////////////////////////////////////////////////////////////////////	
	//ok
		public void addAddon(Addon addon) {
			addon.setId(null);
			sm.persist(addon);
		}
	//usun addony ze swetra zanim usuniesz addon
		public void deleteAddon(Addon addon) {
			addon = sm.find(Addon.class, addon.getId());
			sm.remove(addon);
		}
		public void deleteAddonFromSweters(Addon addon){
			addon = sm.find(Addon.class, addon.getId());
			List<Sweter> sweters = sm.createNamedQuery("sweter.all").getResultList();
			for (Sweter sweter : sweters){
				sweter = sm.find(Sweter.class, sweter.getId());
				sweter.getAddons().remove(addon);
			}
		}
		
	//ok
		@SuppressWarnings("unchecked")
		public List<Addon> getAllAddon() {
			return sm.createNamedQuery("addon.all").getResultList();
		}
		
		@SuppressWarnings("unchecked")
		public List<Sweter> getSweterWithSize(int sweterSize){
			return sm.createNamedQuery("sweter.size").setParameter("sweterSize", sweterSize).getResultList();
		}
}
