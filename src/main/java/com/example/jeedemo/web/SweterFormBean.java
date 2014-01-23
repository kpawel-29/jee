package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Addon;
import com.example.jeedemo.domain.Car;
import com.example.jeedemo.domain.Osoba;
import com.example.jeedemo.domain.Person;
import com.example.jeedemo.domain.Sweter;
import com.example.jeedemo.service.AddonManager;
import com.example.jeedemo.service.OsobaManager;
import com.example.jeedemo.service.PersonManager;
import com.example.jeedemo.service.SellingManager;
import com.example.jeedemo.service.SweterManager;

@SessionScoped
@Named("sweterBean")
public class SweterFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	


	private Sweter sweter = new Sweter();
	private ListDataModel<Sweter> sweters = new ListDataModel<Sweter>();
	
	private ListDataModel<Osoba> sweterOwner = new ListDataModel<Osoba>();
	private ListDataModel<Addon> sweterAddons = new ListDataModel<Addon>();
	
	private Sweter sweterToShow;
	private int sweterSize;
	
	@Inject
	private SweterManager sm;	
	@Inject
	private AddonManager am;
	
	/////////////////////////////////////////////////////
	
	
	public Sweter getSweter() {
		return sweter;
	}
	public int getSweterSize() {
		return sweterSize;
	}
	public void setSweterSize(int sweterSize) {
		this.sweterSize = sweterSize;
	}
	public void setSweter(Sweter sweter) {
		this.sweter = sweter;
	}
	
	public ListDataModel<Sweter> getAllSweter() {
		sweters.setWrappedData(sm.getAllSweter());
		return sweters;
	}
	
	public String showDetails() {
		sweterToShow = sweters.getRowData();
		return "details";
		//return null;
	}
	public String addSweter() {
		sm.addSweter(sweter);
		//return "showSweter";
		return null;
	}

	public String deleteSweter() {
		Sweter sweterToDelete = sweters.getRowData();
		sm.deleteSweter(sweterToDelete);
		return null;
	}
	/////////////////////////////////////////////////////////
	public ListDataModel<Addon> getSweterAddons() {
		sweterAddons.setWrappedData(am.getSweterAddons(sweterToShow));
		return sweterAddons;
	}
	
	public String disposeAddon(){
		Addon addonToDispose = sweterAddons.getRowData();
		am.disposeAddon(sweterToShow, addonToDispose);
		return null;
	}
	
	public String showAddonDetails() {
		sweterToShow = sweters.getRowData();
		return "detailsAddon";
	}
	/////////////////////////////////////////////////////////
	
	public String getSweterWithSizeClick(){
		sm.getSweterWithSize(sweter.getSize());
		return "showSweterWithSize";
	}
	
	public ListDataModel<Sweter> getSweterWithSize() {
		sweters.setWrappedData(sm.getSweterWithSize(sweter.getSize()));
		return sweters;
	}
	
}
