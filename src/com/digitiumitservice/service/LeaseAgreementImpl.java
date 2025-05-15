package com.digitiumitservice.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.digitiumitservice.exception.NoAgreementListException;
import com.digitiumitservice.model.LeaseAgreement;

public class LeaseAgreementImpl implements LeaseAgreementService{
	
	private List<LeaseAgreement> leaseagrement=new ArrayList<>();

	@Override
	public void addNewLease(String towerId, String city, String ownerName, double monthlyRent, LocalDate leaseExpiryDate) {
	    LeaseAgreement lease = new LeaseAgreement(towerId, city, ownerName, monthlyRent, leaseExpiryDate);
	    leaseagrement.add(lease);
	}

	@Override
	public void viewLeaseDetails() {
	    for (LeaseAgreement lease : leaseagrement) {
	        System.out.println(lease);
	    }
	}

	@Override
	public List<LeaseAgreement> searchByCityOrOwner(String keyword) {

			return leaseagrement.stream()
					.filter(lease ->lease.getCity().equalsIgnoreCase(keyword) || lease.getOwnerName()
					.equalsIgnoreCase(keyword))
					.collect(Collectors.toList());
				
		}

	@Override
	public List<LeaseAgreement> getAllSortedByExpiryDate() {
	    return leaseagrement.stream()
	        .sorted(Comparator.comparing(LeaseAgreement::getLeaseExpiryDate))
	        .collect(Collectors.toList()); 
	}

	@Override
	public double calculateTotalRentByCity(String city) {
		    return leaseagrement.stream()
		            .filter(lease -> lease.getCity().equalsIgnoreCase(city))  
		            .mapToDouble(LeaseAgreement::getMonthlyRent)               
		            .sum();                                                   
		
	}

	@Override
	public List<LeaseAgreement> getLeaseExpiringInNextThreeMonth() throws NoAgreementListException {
		if (leaseagrement.isEmpty())
			throw new NoAgreementListException("agreement list is empty");
		
		LocalDate currentDate = LocalDate.now();
		List<LeaseAgreement> filteredLeaseList = leaseagrement.stream()
		        .filter(lease -> {
		            LocalDate expiry = lease.getLeaseExpiryDate();
		            Period period = Period.between(currentDate, expiry);
		            return !expiry.isBefore(currentDate) && period.getMonths() <= 3 && period.getYears() == 0;
		        })
		        .collect(Collectors.toList());
		return filteredLeaseList;
	}

}

		


	






