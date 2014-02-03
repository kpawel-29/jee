package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Addon;
import com.example.jeedemo.domain.Car;
import com.example.jeedemo.domain.Addon;
import com.example.jeedemo.domain.Person;
import com.example.jeedemo.domain.Sweter;
import com.example.jeedemo.service.AddonManager;
import com.example.jeedemo.service.OsobaManager;
import com.example.jeedemo.service.PersonManager;
import com.example.jeedemo.service.SellingManager;
import com.example.jeedemo.service.SweterManager;

@SessionScoped
@Named("addonBean")
public class AddonFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Addon addon = new Addon();
	private ListDataModel<Sweter> sweters = new ListDataModel<Sweter>();
	private ListDataModel<Addon> addons = new ListDataModel<Addon>();
	
	private ListDataModel<Addon> sweterAddons = new ListDataModel<Addon>();
	private Addon addonToEdit;
	private Sweter sweterToShow;
	private Addon addonToShow;

	@Inject
	private SweterManager sm;
	@Inject
	private AddonManager om;
		
	private Long addonIdTab[];
	
	

	
	public Long[] getAddonIdTab() {
		return addonIdTab;
	}

	public void setAddonIdTab(Long[] addonIdTab) {
		this.addonIdTab = addonIdTab;
	}


	public Addon getAddonToEdit() {
		return addonToEdit;
	}
	public void setAddonToEdit(Addon addonToEdit) {
		this.addonToEdit = addonToEdit;
	}
	public Addon getAddon() {
		return addon;
	}
	public void setAddon(Addon addon) {
		this.addon = addon;
	}
	public ListDataModel<Addon> getAllAddon() {
		sweterAddons.setWrappedData(sm.getAllAddon());
		return sweterAddons;
	}
	
	/*public ListDataModel<Addon> getSweterAddon() {
		sweterAddon.setWrappedData(om.getSweterAddon(sweterToShow));
		return sweterAddon;
	}*/
	
	public String showAddonDetails() {
		addonToShow = addons.getRowData();
		return "detailsAddon";
		//return null;
	}

	public String addAddon() {
		sm.addAddon(addon);
		//return "showAddon";
		return null;
	}
	public String deleteAddon(){	
		sm.deleteAddonFromSweters(addon);
		sm.deleteAddon(addon);
		return null;
	}
	
	public String editAddon(){
		addonToEdit=sweterAddons.getRowData();
		return "editAddon";
	}
	
	public String editAddonZatwierdz(){
		om.editAddon(addonToEdit);
		return "editAddon";
	}

}
