package com.cvsHealth.AppData;

import static com.cvsHealth.constants.ApplicationConstants.USER_INFORMATION_JSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.cvsHelath.Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Test<T> {
	public static String Vinno_Read;
	public static List<String> linststring;

	public static void main(String[] args) {
		try {

			System.out.println("*****");
			BufferedReader reader = new BufferedReader(new FileReader(USER_INFORMATION_JSON));
			Gson gson = new GsonBuilder().create();
			User[] people = gson.fromJson(reader, User[].class);

			System.out.println("Object mode: " + people.length);

			List<User> list = new ArrayList<>();

			for (int i = 0; i < people.length; i++) {
				System.out.println(people[i]);
				list.add(people[i]);
			}
			for (int i = 200; i < 250; i++) {
				User user = new User();
				user.setDOB("12/12/2017");
				user.setEmail("PUSHKAR : " + i);
				user.setPassword("password : " + i);
				user.setUsername("username : " + i);
				list.add(user);
			}

			System.out.println("done....");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
