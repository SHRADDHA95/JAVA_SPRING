
package com.cvsHealth.AppData;

import static com.cvsHealth.constants.ApplicationConstants.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.cvsHelath.Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONWriter {

	public void writeIntoJSON(User user) throws FileNotFoundException, IOException, ParseException {
		System.out.println("*****");
		BufferedReader reader = new BufferedReader(new FileReader(USER_INFORMATION_JSON));
		Gson gson = new GsonBuilder().create();
		User[] people = gson.fromJson(reader, User[].class);

		// System.out.println("Object mode: " + people.length);

		List<User> list = new ArrayList<>();
		if (people != null && people.length > 0) {
			for (int i = 0; i < people.length; i++) {
				// System.out.println(people[i]);
				list.add(people[i]);
			}
		}
		
		list.add(user);

		String json = gson.toJson(list);
		// write converted json data to a file named "CountryGSON.json"
		FileWriter writer = new FileWriter(USER_INFORMATION_JSON);
		writer.write(json);
		writer.close();

	}

	/* Write into JSON without reading first */
	public static void writeJSON(List<User> list) throws IOException {

		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		// write converted json data to a file named "CountryGSON.json"
		FileWriter writer = new FileWriter(USER_INFORMATION_JSON);
		writer.write(json);
		writer.close();

	}

}
