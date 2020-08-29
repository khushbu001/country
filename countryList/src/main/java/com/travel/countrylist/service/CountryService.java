package com.travel.countrylist.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.travel.countrylist.model.Country;
import com.travel.countrylist.repo.CountryRepo;

/**
 * 
 * @author khushii
 *
 */
@Service
public class CountryService {

	Logger logger = LoggerFactory.getLogger(CountryService.class);

	/**
	 * 
	 */
	@Autowired
	private CountryRepo countryRepo;

	/**
	 * 
	 * @param countryName
	 */
	public void addNewCountry(Country countryName) {

		logger.debug("CountryService::addNewCountry::Start");
		logger.debug("countryCode: {}, countryName: {}, schengenStatus: {}, continent: {}",
				countryName.getCountryCode(), countryName.getCountryName(), countryName.getSchengenStatus(),
				countryName.getContinent());
		countryRepo.save(countryName);
		logger.debug("CountryService::addNewCountry::end");
	}

	/**
	 * 
	 * @param countryName
	 */
	public ResponseEntity<Object> updateCountry(String countryCode, Country countryName) {
		logger.debug("CountryService::updateCountry::Start");
		logger.debug("countryCode: {}, countryName: {}, schengenStatus: {}, continent: {}",
				countryName.getCountryCode(), countryName.getCountryName(), countryName.getSchengenStatus(),
				countryName.getContinent());
		Country updateCountry;
		if (countryRepo.findById(countryCode) == null) {

		} else {
			countryName.setCountryCode(countryCode);
			updateCountry = countryRepo.getOne(countryName.getCountryCode());
			updateCountry.setCountryName(countryName.getCountryName());
			updateCountry.setSchengenStatus(countryName.getSchengenStatus());
			updateCountry.setContinent(countryName.getContinent());

			countryRepo.save(updateCountry);
			logger.debug("CountryService::updateCountry::End");
		}
		return new ResponseEntity<>("CountryData is updated successsfully", HttpStatus.OK);
	}

	/**
	 * 
	 * @param countryName
	 */
	public ResponseEntity<Object> deleteCountry(String countryCode) {
		logger.debug("CountryService::deleteCountry::Start");
		if (countryRepo.findById(countryCode) == null) {
//throw some message
		} else {
			countryRepo.deleteById(countryCode);
		}
		logger.debug("CountryService::deleteCountry::End");
		return new ResponseEntity<>("Country data deleted successfully", HttpStatus.FORBIDDEN);
	}

	/**
	 * 
	 * @param countryName
	 */
	public List getCountry() {
		logger.debug("CountryService::getCountry::Start");
		List<Country> allCountry = new ArrayList<Country>();
		countryRepo.findAll().forEach(s -> allCountry.add(s));
		logger.debug("CountryService::getCountry::End");
		return allCountry;
	}

}
