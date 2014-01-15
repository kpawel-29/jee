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
import com.example.jeedemo.domain.Sweter;

@Stateless
public class AddonManager {

	@PersistenceContext
	EntityManager sm;
	public void connectAddon(Long sweterId, Long[] addonIdTab) {
		
		Sweter sweter = sm.find(Sweter.class, sweterId);
		
		for (Long l : addonIdTab){
			Addon addon = sm.find(Addon.class, l);
			sweter.getAddons().add(addon);
			addon.getSwetry().add(sweter);
		}
	}
	
	public List<Addon> getSweterAddons(Sweter sweter) {
		sweter = sm.find(Sweter.class, sweter.getId());
		// lazy loading here - try this code without this (shallow) copying
		List<Addon> addons = new ArrayList<Addon>(sweter.getAddons());
		return addons;
	}
	
	public List<Sweter> getAddonSweters(Addon addon) {
		addon = sm.find(Addon.class, addon.getId());
		List<Sweter> sweters = new ArrayList<Sweter>(addon.getSwetry());
		return sweters;
	}
	
	public void disposeAddon(Sweter sweter,Addon addon) {

		addon = sm.find(Addon.class, addon.getId());
		sweter = sm.find(Sweter.class, sweter.getId());

		Sweter toRemove = null;
		for (Sweter aSweter : addon.getSwetry())
			if (aSweter.getId().compareTo(sweter.getId()) == 0) {
				toRemove = aSweter;
				break;
			}

		if (toRemove != null)
			addon.getSwetry().remove(toRemove);
			toRemove.getAddons().remove(addon);
	}

}
/*	public List<Sweter> getSweterAddon(Addon addon) {
addon = om.find(Addon.class, addon.getId());
// lazy loading here - try this code without this (shallow) copying
List<Sweter> sweters = new ArrayList<Sweter>(addon.getSwetry());
return sweters;
}*/

