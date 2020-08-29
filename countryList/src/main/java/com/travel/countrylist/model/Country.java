package com.travel.countrylist.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Country {

	@Id
	@NotNull
	private String countryCode;
	@NotNull
	private String countryName;
	@NotNull
	private String schengenStatus;
	@NotNull
	private String continent;

	public Country(@NotNull String countryCode, @NotNull String countryName, @NotNull String schengenStatus,
			@NotNull String continent) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.schengenStatus = schengenStatus;
		this.continent = continent;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getSchengenStatus() {
		return schengenStatus;
	}

	public void setSchengenStatus(String schengenStatus) {
		this.schengenStatus = schengenStatus;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}
}
