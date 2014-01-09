package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Addon;
import com.example.jeedemo.domain.Osoba;
import com.example.jeedemo.domain.Osoba;
import com.example.jeedemo.domain.Sweter;
import com.example.jeedemo.service.OsobaManager;
import com.example.jeedemo.service.SweterManager;

@SessionScoped
@Named("osobaBean")
public class OsobaFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Osoba osoba = new Osoba();
	private ListDataModel<Osoba> osoby = new ListDataModel<Osoba>();
	
	private Osoba osobaToShow = new Osoba();
	private ListDataModel<Sweter> ownedSweter = new ListDataModel<Sweter>();


	@Inject
	private OsobaManager om;
	
	@Inject
	private SweterManager sm;

	public Osoba getOsoba() {
		return osoba;
	}
	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}
	
	public ListDataModel<Osoba> getAllOsoba() {
		osoby.setWrappedData(om.getAllOsoba());
		return osoby;
	}
	
	// Actions
	public String addOsoba() {
		om.addOsoba(osoba);
		return "showOsoba";		
	}

	public String deleteOsoba() {
		Osoba osobaToDelete = osoby.getRowData();
		om.deleteOsoba(osobaToDelete);
		return null;
	}
	
	public String showDetails() {
		osobaToShow = osoby.getRowData();
		return "details";
	}
	public ListDataModel<Sweter> getOwnedSweter() {
		ownedSweter.setWrappedData(om.getOwnedSweter(osobaToShow));
		return ownedSweter;
	}
	
	public String disposeSweter(){
		Sweter sweterToDispose = ownedSweter.getRowData();
		om.disposeSweter(osobaToShow, sweterToDispose);
		return null;
	}
	
	
	
	
	/*private Osoba osoba = new Osoba();
	private ListDataModel<Osoba> osoby = new ListDataModel<Osoba>();

	@Inject
	private OsobaManager om;

	
	public Osoba getOsoba() {
		return osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

	public ListDataModel<Osoba> getAllOsoba() {
		osoby.setWrappedData(om.getAllOsoba());
		return osoby;
	}

	// Actions
	public String addOsoba() {
		
		om.addOsoba(osoba);

		return "showOsoba";
		// return null;
	}

	public String deleteOsoba() {
		Osoba osobaToDelete = osoby.getRowData();
		om.deleteOsoba(osobaToDelete);
		return null;
	}*/
}
