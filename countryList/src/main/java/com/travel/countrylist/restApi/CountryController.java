package com.travel.countrylist.restApi;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.countrylist.model.Country;
import com.travel.countrylist.service.CountryService;

@RestController
@ControllerAdvice
public class CountryController {

	Logger logger = LoggerFactory.getLogger(CountryService.class);

	@Autowired
	private CountryService countryService;

	@PostMapping(value = "/country")
	public void addCountry(@RequestBody Country countryName) {
		countryService.addNewCountry(countryName);
	}

	@PutMapping(value = "/country/{code}")
	public ResponseEntity<Object> updateCountry(@PathVariable String code, @RequestBody Country countryName) {
		countryService.updateCountry(code, countryName);
		return new ResponseEntity<>("Country is updated successsfully", HttpStatus.OK);

	}

	@DeleteMapping(value = "/country/{code}")
	public ResponseEntity<Object> deleteCountry(@PathVariable String code) {
		logger.info("CountryController::deleteCountry::Start");
		countryService.deleteCountry(code);
		logger.debug("CountryController::deleteCountry::Start");
		return new ResponseEntity<>("Deletion  Done:", HttpStatus.OK);

	}

	@GetMapping(value = "country")
	public List<Country> getCountry() {
		return countryService.getCountry();
	}
}
