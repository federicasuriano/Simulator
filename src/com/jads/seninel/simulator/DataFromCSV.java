package com.jads.seninel.simulator;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataFromCSV {

	public List<List<String>> getListOfListsFromCsv() throws URISyntaxException, IOException {
		List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Utente\\Desktop\\PoliMi\\Biennio\\Tesi\\Simulator\\resources", "nl.csv"));

		List<List<String>> listOfLists = new ArrayList<>();
		lines.forEach(line -> {
			List<String> innerList = new ArrayList<>(Arrays.asList(line.split(",")));
			listOfLists.add(innerList);
		});
		return listOfLists;
	}
}
