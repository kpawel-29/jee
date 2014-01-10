package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Car;
import com.example.jeedemo.domain.Osoba;
import com.example.jeedemo.domain.Person;
import com.example.jeedemo.domain.Sweter;
import com.example.jeedemo.service.OsobaManager;
import com.example.jeedemo.service.PersonManager;
import com.example.jeedemo.service.SellingManager;
import com.example.jeedemo.service.SweterManager;

@SessionScoped
@Named("connectBean")
public class ConnectFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SweterManager sm;

	@Inject
	private OsobaManager om;

	private Long osobaId;
	private Long sweterId;
	
	public Long getOsobaId() {
		return osobaId;
	}

	public List<Sweter> getAvailableSweter() {
		return sm.getAvailableSweter();
	}
	
	public void setOsobaId(Long osobaId) {
		this.osobaId = osobaId;
	}

	public Long getSweterId() {
		return sweterId;
	}

	public void setSweterId(Long sweterId) {
		this.sweterId = sweterId;
	}

	public List<Osoba> getAllOsoba() {
		return om.getAllOsoba();
	}

	public List<Sweter> getAllSweter() {
		return sm.getAllSweter();
	}

	public String connect() {
		sm.connect(sweterId, osobaId);
		//return "addSwetertoOwner";
		return "connect";
	}
}
