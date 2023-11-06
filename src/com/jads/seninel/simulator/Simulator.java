package com.jads.seninel.simulator;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.logging.Level;

public class Simulator {

	public static void main(String args[]) throws URISyntaxException, IOException {

		int idReport = 1;
		int idAddress;
		String city;
		String province;
		boolean housing;
		boolean health;
		boolean labor;
		boolean employer;
		boolean payment;
		boolean householdsExceeded;
		boolean workingHoursExceeded;
		boolean paymentExceeded;
		boolean noContract;
		boolean noVacation;
	
		System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tQ %5$s %n");
		Log my_log = new Log("log.txt");

		List<List<String>> cityProvince = new ArrayList<>();

		DataFromCSV data = new DataFromCSV();
		cityProvince = data.getListOfListsFromCsv();
		
		for (int i = 0; i < 100; i++) {
			
			idAddress = random(100);
			int randomValue = random(cityProvince.size());
			city = cityProvince.get(randomValue).get(0);
			province = cityProvince.get(randomValue).get(5);

			householdsExceeded = randomBool();
			workingHoursExceeded = randomBool();
			paymentExceeded = randomBool();
			noContract = randomBool();
			noVacation = randomBool();
			
			if(householdsExceeded) {
				housing = true;
			} else {
				housing = randomBool();
			}
			
			if(workingHoursExceeded) {
				labor = true;
			} else {
				labor = randomBool();
			}
			
			if(paymentExceeded) {
				payment = true;
			} else {
				payment = randomBool();
			}
			
			if(noContract) {
				payment = employer = labor = true;
			} else {
				payment = randomBool();
				employer = randomBool();
				labor = randomBool();
			}
			
			if(noVacation) {
				payment = employer = true;
			}else {
				payment = randomBool();
				employer = randomBool();
			}
			
			health = randomBool();
			
			saveLogSituation(idReport, idAddress, city, province, housing, health, labor, employer, payment,
					householdsExceeded, workingHoursExceeded, paymentExceeded, noContract, noVacation, my_log);
			
			idReport++;
		}

	}
	
	public static int random(int upperbound) {
		// Instance of random class
		Random rand = new Random();
		
		// Generating random values from 0 - upperboud excluded
		// using nextInt()
		int int_random = rand.nextInt(upperbound);

		return int_random;
	}
	
	public static boolean randomBool() {
		// Instance of random class
		Random rand = new Random();
		boolean bool_random = rand.nextBoolean();
		return bool_random;
	}
	

	private static void saveLogSituation(int idReport, int idAddress, String city, String province, boolean housing,
			boolean health, boolean labor, boolean employer, boolean payment, boolean householdsExceeded,
			boolean workingHoursExceeded, boolean paymentExceeded, boolean noContract, boolean noVacation, Log my_log) {
		try {

			my_log.logger.setLevel(Level.INFO);
			/*
			 * my_log.logger.
			 * info("situation(long idReport, long idAddress, String City, String Province, boolean housingExpl, boolean healthExpl, "
			 * +
			 * "boolean paymentExpl, boolean laborExpl, boolean employerExpl, boolean householdsExceeded, boolean workingHoursExceeded, "
			 * + "boolean pteamsaymentExceeded, boolean noContract, boolean noVacation)");
			 */
			my_log.logger.info("situation(" + idReport + ", " + idAddress + ", " + city + ", " + province + ", " +
					// save categories
					housing + ", " + health + ", " + labor + ", " + employer + ", " + payment + ", " +
					// save questions
					householdsExceeded + ", " + workingHoursExceeded + ", " + paymentExceeded + ", " + noContract + ", "
					+ noVacation + ")");

		} catch (Exception e) {
		}

	}

}
