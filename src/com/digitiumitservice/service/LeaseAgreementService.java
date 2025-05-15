package com.digitiumitservice.service;

import java.time.LocalDate;
import java.util.List;

import com.digitiumitservice.exception.NoAgreementListException;
import com.digitiumitservice.model.LeaseAgreement;

public interface LeaseAgreementService {
	
	void addNewLease(String towerId, String city, String ownerName, double monthlyRent, LocalDate leaseExpiryDate);
	void viewLeaseDetails();
	List<LeaseAgreement> searchByCityOrOwner(String keyword);
	List<LeaseAgreement> getAllSortedByExpiryDate();
	double calculateTotalRentByCity(String city);
	List<LeaseAgreement> getLeaseExpiringInNextThreeMonth() throws NoAgreementListException;
}
