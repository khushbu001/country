package com.travel.countrylist.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.countrylist.model.Country;

public interface CountryRepo extends JpaRepository<Country, String> {

}
