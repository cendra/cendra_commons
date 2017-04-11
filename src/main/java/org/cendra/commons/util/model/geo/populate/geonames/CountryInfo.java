package org.cendra.commons.util.model.geo.populate.geonames;

public class CountryInfo {

	private String iSO;
	private String iSO3;
	private String iSONumeric;
	private String fips;
	private String capital;
	private String area;
	private String population;
	private String continent;
	private String tld;
	private String currencyCode;
	private String currencyName;
	private String phone;
	private String postalCodeFormat;
	private String postalCodeRegex;
	private String languages;
	private String geonameid;
	private String neighbours;
	private String equivalentFipsCode;

	public String getiSO() {
		return iSO;
	}

	public void setiSO(String iSO) {
		this.iSO = iSO;
	}

	public String getiSO3() {
		return iSO3;
	}

	public void setiSO3(String iSO3) {
		this.iSO3 = iSO3;
	}

	public String getiSONumeric() {
		return iSONumeric;
	}

	public void setiSONumeric(String iSONumeric) {
		this.iSONumeric = iSONumeric;
	}

	public String getFips() {
		return fips;
	}

	public void setFips(String fips) {
		this.fips = fips;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getTld() {
		return tld;
	}

	public void setTld(String tld) {
		this.tld = tld;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalCodeFormat() {
		return postalCodeFormat;
	}

	public void setPostalCodeFormat(String postalCodeFormat) {
		this.postalCodeFormat = postalCodeFormat;
	}

	public String getPostalCodeRegex() {
		return postalCodeRegex;
	}

	public void setPostalCodeRegex(String postalCodeRegex) {
		this.postalCodeRegex = postalCodeRegex;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getGeonameid() {
		return geonameid;
	}

	public void setGeonameid(String geonameid) {
		this.geonameid = geonameid;
	}

	public String getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(String neighbours) {
		this.neighbours = neighbours;
	}

	public String getEquivalentFipsCode() {
		return equivalentFipsCode;
	}

	public void setEquivalentFipsCode(String equivalentFipsCode) {
		this.equivalentFipsCode = equivalentFipsCode;
	}

	@Override
	public String toString() {
		return "CountryInfo [iSO=" + iSO + ", iSO3=" + iSO3 + ", iSONumeric=" + iSONumeric + ", fips=" + fips
				+ ", capital=" + capital + ", area=" + area + ", population=" + population + ", continent=" + continent
				+ ", tld=" + tld + ", currencyCode=" + currencyCode + ", currencyName=" + currencyName + ", phone="
				+ phone + ", postalCodeFormat=" + postalCodeFormat + ", postalCodeRegex=" + postalCodeRegex
				+ ", languages=" + languages + ", geonameid=" + geonameid + ", neighbours=" + neighbours
				+ ", equivalentFipsCode=" + equivalentFipsCode + "]";
	}

}
