package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Addon;
import com.example.jeedemo.domain.Osoba;
import com.example.jeedemo.domain.Osoba;
import com.example.jeedemo.domain.Person;
import com.example.jeedemo.domain.Sweter;
import com.example.jeedemo.service.OsobaManager;
import com.example.jeedemo.service.SweterManager;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@SessionScoped
@Named("osobaBean")
public class OsobaFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Osoba osoba = new Osoba();
	private ListDataModel<Osoba> osoby = new ListDataModel<Osoba>();
	
	private Osoba osobaToShow = new Osoba();
	private ListDataModel<Sweter> ownedSweter = new ListDataModel<Sweter>();

	private Osoba osobaToEdit;

	@Inject
	private OsobaManager om;
	
	@Inject
	private SweterManager sm;

	
	public Osoba getOsobaToEdit() {
		return osobaToEdit;
	}
	public void setOsobaToEdit(Osoba osobaToEdit) {
		this.osobaToEdit = osobaToEdit;
	}
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
		//return "showOsoba";		
		return null;
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
	
	public String editOsoba(){
		osobaToEdit = osoby.getRowData();
		return "editOsoba";
	}
	
	public String editOsobaZatwierdz(){
		om.editOsoba(osobaToEdit);
		return "editOsoba";
	}
	
	
	// Validators

			// Business logic validation
			public void uniqueEmail(FacesContext context, UIComponent component,
					Object value) {

				String email = (String) value;
				
				for (Osoba osoba : om.getAllOsoba()){
					if (osoba.getEmail().equalsIgnoreCase(email)) {
						FacesMessage message = new FacesMessage("email zajęty");
						message.setSeverity(FacesMessage.SEVERITY_ERROR);
						throw new ValidatorException(message);
					}
				}
			}
			
	
}
