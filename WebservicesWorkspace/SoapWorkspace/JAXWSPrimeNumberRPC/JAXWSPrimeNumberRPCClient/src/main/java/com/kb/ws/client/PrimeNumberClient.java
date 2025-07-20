package com.kb.ws.client;

public class PrimeNumberClient {
	public static void main(String[] args) {
		PrimeNumberServiceImplService service = new PrimeNumberServiceImplService();
		PrimeNumberService primeNumberService = service.getPrimeNumberServiceImplPort();
		         
		 System.out.println(primeNumberService.isPrimeNumber(13));
		 
		 System.out.println(primeNumberService.isPrimeNumber(14));

	}

}
