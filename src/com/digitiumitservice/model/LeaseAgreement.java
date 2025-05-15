package com.digitiumitservice.model;

import java.time.LocalDate;

public class LeaseAgreement {

	private String towerId;
	private String city;
	private String ownerName;
	private double monthlyRent;
	private LocalDate leaseExpiryDate;
	public LeaseAgreement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LeaseAgreement(String towerId, String city, String ownerName, double monthlyRent,
			LocalDate leaseExpiryDate) {
		super();
		this.towerId = towerId;
		this.city = city;
		this.ownerName = ownerName;
		this.monthlyRent = monthlyRent;
		this.leaseExpiryDate = leaseExpiryDate;
	}
	public String getTowerId() {
		return towerId;
	}
	public void setTowerId(String towerId) {
		this.towerId = towerId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public double getMonthlyRent() {
		return monthlyRent;
	}
	public void setMonthlyRent(double monthlyRent) {
		this.monthlyRent = monthlyRent;
	}
	public LocalDate getLeaseExpiryDate() {
		return leaseExpiryDate;
	}
	public void setLeaseExpiryDate(LocalDate leaseExpiryDate) {
		this.leaseExpiryDate = leaseExpiryDate;
	}
	@Override
	public String toString() {
		return "LeaseAgreement [towerId=" + towerId + ", city=" + city + ", ownerName=" + ownerName + ", monthlyRent="
				+ monthlyRent + ", leaseExpiryDate=" + leaseExpiryDate + "]";
	}
	
	
}
