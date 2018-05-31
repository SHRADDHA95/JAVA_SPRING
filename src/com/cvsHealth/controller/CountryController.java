package com.cvsHealth.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cvsHealth.AppData.JSONCountryWriter;
import com.cvsHealth.AppData.JSONReader;
import com.cvsHealth.AppData.JSONWriter;
import com.cvsHelath.Model.Country;
import com.cvsHelath.Model.User;

@Controller
@RequestMapping(value = "/countryList")
public class CountryController {

	@RequestMapping()
	public String displayCountries(Model model) {

		try {
			model.addAttribute("countryInfo", new Country());
			model.addAttribute("country_info", this.getCountryDetail());
			System.out.println("Inside Country Controller");
			return "countryList";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@ModelAttribute("countryInfo")
	public Country country() {
		return new Country();
	}

	// update country
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCountry(Country country, Model model)
			throws FileNotFoundException, IOException, ParseException {
		try {
			System.out.println("Inside Update");
			JSONReader reader = new JSONReader();
			List<Country> valFromJSON = reader.getCountryDetail();
			List<Country> list = new ArrayList<>();
			if (country != null) {
				for (Country c : valFromJSON) {
					int c_id = c.getId();
					if (c_id == country.getId()) {
						Country conObj = new Country();
						conObj.setCountry_code(country.getCountry_code());
						conObj.setCountry_name(country.getCountry_name());
						conObj.setContinent(country.getContinent());
						list.add(conObj);
					} else {
						list.add(c);
					}
				}
			} else {
				System.out.println("COUNTRY NOT FOUND**********");
			}

			JSONCountryWriter.writeJSON(list);
			model.addAttribute("country_info", this.getCountryDetail());
			model.addAttribute("successMessage", "Country details updated Successfully");
			return "countryList";

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	public List<Country> getCountryDetail() throws FileNotFoundException, IOException, ParseException {
		JSONReader reader = new JSONReader();
		List<Country> valFromJSON = reader.getCountryDetail();
		return valFromJSON;
	}

	/** Add Country **/

	@RequestMapping(value = "/add")
	public String addUser(Model model, Country country) {
		try {

			JSONCountryWriter writer = new JSONCountryWriter();
			writer.writeIntoJSON(country);

			model.addAttribute("country_info", this.getCountryDetail());
			model.addAttribute("successMessage", "Country details added Successfully");
			return "countryList";

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/* Remove selected country */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	@ResponseBody
	public String removeUser(@RequestParam int id, HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, IOException, ParseException {
		JSONObject obj = new JSONObject();
		System.out.println("****************");
		try {
			JSONReader reader = new JSONReader();
			System.out.println("Inside remove,ide:" + id);
			List<Country> valFromJSON = reader.getCountryDetail();
			List<Country> list = new ArrayList<>();
			if (id > 0) {
				for (Country c : valFromJSON) {
					int c_id = c.getId();
					if (c_id != id) {
						list.add(c);
					}
				}
				JSONCountryWriter.writeJSON(list);
			} else {
				System.out.println("USERNAME NOT FOUND**********");
			}

			// model.addAttribute("lists", this.getCountryDetail());
			obj.put("status", "true");
			obj.put("successMessage", "Country Deleted Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("status", "false");
			// model.addAttribute("errorMessage", "Unable to Delete Country. Please Login
			// Again");
		}
		return obj.toString();
	}

}
