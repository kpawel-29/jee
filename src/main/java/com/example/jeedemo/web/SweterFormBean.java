package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Addon;
import com.example.jeedemo.domain.Car;
import com.example.jeedemo.domain.Osoba;
import com.example.jeedemo.domain.Sweter;
import com.example.jeedemo.service.SweterManager;

@SessionScoped
@Named("sweterBean")
public class SweterFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Sweter sweter = new Sweter();
	//private Osoba osoba = new Osoba();
	//private Addon addon = new Addon();
	private ListDataModel<Sweter> sweters = new ListDataModel<Sweter>();
	
	private ListDataModel<Osoba> sweterOwner = new ListDataModel<Osoba>();
	
	private Sweter sweterToShow;

	@Inject
	private SweterManager sm;
	
	

	
	public Sweter getSweter() {
		return sweter;
	}

	public void setSweter(Sweter sweter) {
		this.sweter = sweter;
	}
	
	public ListDataModel<Osoba> getsweterOwner() {
		sweterOwner.setWrappedData(sm.getOwnedSweter(sweterToShow));
		return sweterOwner;
	}
	
	public ListDataModel<Sweter> getAllSweter() {
		sweters.setWrappedData(sm.getAllSweter());
		return sweters;
	}
	
	public String showDetails() {
		sweterToShow = sweters.getRowData();
		return "details";
	}

	// Actions
	public String addSweter() {
		
		sm.addSweter(sweter);

		return "showSweter";
		// return null;
	}

	public String deleteSweter() {
		Sweter sweterToDelete = sweters.getRowData();
		sm.deleteSweter(sweterToDelete);
		return null;
	}
}
