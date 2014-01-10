package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
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
@Named("connectAddonBean")
public class ConnectAddonFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SweterManager sm;

	@Inject
	private AddonManager om;

	private Long addonId;
	private Long sweterId;
	
	public Long getAddonId() {
		return addonId;
	}
	
	public void setAddonId(Long addonId) {
		this.addonId = addonId;
	}

	public Long getSweterId() {
		return sweterId;
	}

	public void setSweterId(Long sweterId) {
		this.sweterId = sweterId;
	}

	public List<Addon> getAllAddon() {
		return sm.getAllAddon();
	}

	public List<Sweter> getAllSweter() {
		return sm.getAllSweter();
	}

	public String connectAddon() {
		om.connectAddon(sweterId, addonId);
		//return "addSwetertoAddon";
		return "connect";
	}
}
