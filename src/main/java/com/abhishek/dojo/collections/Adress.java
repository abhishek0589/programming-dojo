package com.abhishek.dojo.collections;

public class Adress {

	private int zipCode;
	private String CityName;
	private String StateId;
	private String countryId;

	public Adress(int zipCode, String cityName, String stateId, String countryId) {
		super();
		this.zipCode = zipCode;
		CityName = cityName;
		StateId = stateId;
		this.countryId = countryId;

	}

	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getCityName() {
		return CityName;
	}
	public void setCityName(String cityName) {
		CityName = cityName;
	}
	public String getStateId() {
		return StateId;
	}
	public void setStateId(String stateId) {
		StateId = stateId;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		//"--------------------"+ this.zipCode + "--------------------"+ this.CityName + "--------------------"+
		return  this.StateId + "--------------------"+ this.countryId;
	}
}
