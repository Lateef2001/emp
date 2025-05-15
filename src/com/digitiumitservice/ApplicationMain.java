package com.digitiumitservice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.digitiumitservice.service.LeaseAgreementImpl;
import com.digitiumitservice.service.LeaseAgreementService;

public class ApplicationMain {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LeaseAgreementService leaseservice = new LeaseAgreementImpl(); 
     
        
        while(true) {
		        System.out.println("================");
		        System.out.println("======");
		        System.out.println("1. Add new lease agreements :");
		        System.out.println("2. Search for agreements by city or owner name :");
		        System.out.println("3. List all lease agreements sorted by expiry date :");
		        System.out.println("4. Calculate total rent for all towers in a specific city :");
		        System.out.println("5. Filter agreements expiring within the next 3 months :");
		        System.out.println("6. View Details.");
		        System.out.println("7. Exit");
		        System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                
                
                try {
                    switch (choice) {
                    	case 1:
                    		System.out.println("Enter Tower Id :");
                    		String towerId=scanner.next();
                    		System.out.println("Enter String city :");
                    		String city=scanner.next();
                    		System.out.println("Enter String ownerName :");
                    		String ownerName=scanner.next();
                    		System.out.println("double monthlyRent :");
                    		double mountlyRent=scanner.nextDouble();
                    		scanner.nextLine();
                    		System.out.println("LocalDate leaseExpiryDate :");
                    		 System.out.println("Enter lease expiry date (yyyy-MM-dd):");
                    	        String dateInput = scanner.nextLine();
                    	        LocalDate leaseExpiryDate = null;
                    	        try {
                    	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    	            leaseExpiryDate = LocalDate.parse(dateInput, formatter);
                    	        } catch (Exception e) {
                    	            System.out.println("Invalid date format! Please enter in yyyy-MM-dd format.");
                    	        }
                    	        leaseservice.addNewLease(towerId, city, ownerName, mountlyRent, leaseExpiryDate);
                    	        System.out.println("Details added successfully..");
                    	   break;
                    	case 2:
                    	    System.out.println("Enter city or owner name to search :");
                    	    String keyword = scanner.nextLine();
                    	    leaseservice.searchByCityOrOwner(keyword).forEach(System.out::println);
                    	    break;
                    	case 3:
                    		leaseservice.getAllSortedByExpiryDate();
                    	case 4:
                    		System.out.println("Enter city which you want calculate rent :");
                    		String leasecity=scanner.next();
                    		  double totalRent = leaseservice.calculateTotalRentByCity(leasecity);
                    		    System.out.println("Total rent for all towers in " + leasecity + ": " + totalRent);
                    		    break;
                    	case 5: 
                    		System.out.println("5. Filter agreements expiring within the next 3 months :");
                    		leaseservice.getLeaseExpiringInNextThreeMonth();

                    	case 6:
                    		leaseservice.viewLeaseDetails();
                    		break;
                    	 case 7:
                             System.out.println("Exiting Admin menu...");
                             break;
                         default:
                             System.out.println("Invalid option. Try again.");
            
                    }
                }
                catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                if(choice == 7) {
                	break;
                }
        }
}
}
