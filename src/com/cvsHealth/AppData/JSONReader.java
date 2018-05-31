package com.cvsHealth.AppData;

import static com.cvsHealth.constants.ApplicationConstants.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.cvsHelath.Model.Country;
import com.cvsHelath.Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONReader {

	/* Read userInfo JSON */

	public List<User> readFromJSON() throws FileNotFoundException, IOException, ParseException {
		BufferedReader reader = new BufferedReader(new FileReader(USER_INFORMATION_JSON));
		Gson gson = new GsonBuilder().create();
		User[] people = gson.fromJson(reader, User[].class);
		List<User> list = new ArrayList<>();
		if (people != null && people.length > 0) {
			for (int i = 0; i < people.length; i++) {
				// System.out.println(people[i]);
				list.add(people[i]);
			}
		}
		return list;
	}

	/* Read country JSON */

	public List<Country> getCountryDetail() throws FileNotFoundException, IOException, ParseException {
		BufferedReader reader = new BufferedReader(new FileReader(COUNTRY_INFORMATION_JSON));
		Gson gson = new GsonBuilder().create();
		Country[] country = gson.fromJson(reader, Country[].class);

		List<Country> list = new ArrayList<>();
		if (country != null && country.length > 0) {
			for (int i = 0; i < country.length; i++) {
				list.add(country[i]);
			}
		}
		return list;
	}
}