package com.cvsHealth.AppData;

import static com.cvsHealth.constants.ApplicationConstants.COUNTRY_INFORMATION_JSON;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.cvsHelath.Model.Country;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONCountryWriter {

	public void writeIntoJSON(Country country) throws FileNotFoundException, IOException, ParseException {

		System.out.println("*****");
		BufferedReader reader = new BufferedReader(new FileReader(COUNTRY_INFORMATION_JSON));
		Gson gson = new GsonBuilder().create();
		Country[] countries = gson.fromJson(reader, Country[].class);

		List<Country> list = new ArrayList<>();
		if (countries != null && countries.length > 0) {
			for (int i = 0; i < countries.length; i++) {
			list.add(countries[i]);
			}
		}
		list.add(country);

		String json = gson.toJson(list);
		// write converted json data to a file named "CountryJSON.json"
		FileWriter writer = new FileWriter(COUNTRY_INFORMATION_JSON);
		writer.write(json);
		writer.close();

	}

	/* Write into JSON without reading first */
	public static void writeJSON(List<Country> list) throws IOException {

		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		// write converted json data to a file named "CountryGSON.json"
		FileWriter writer = new FileWriter(COUNTRY_INFORMATION_JSON);
		writer.write(json);
		writer.close();

	}

}
