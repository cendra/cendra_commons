package org.cendra.commons.util.populate.geo.geonames;

public class CountryInfo {

	private String iSO;
	private String iSO3;
	private String iSONumeric;
	private String fips;
	private String country;
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

		this.iSO = format(iSO);
	}

	public String getiSO3() {
		return iSO3;
	}

	public void setiSO3(String iSO3) {

		this.iSO3 = format(iSO3);
	}

	public String getiSONumeric() {
		return iSONumeric;
	}

	public void setiSONumeric(String iSONumeric) {

		this.iSONumeric = format(iSONumeric);
	}

	public String getFips() {
		return fips;
	}

	public void setFips(String fips) {

		this.fips = format(fips);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {

		this.country = format(country);
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {

		this.capital = format(capital);
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {

		this.area = format(area);
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {

		this.population = format(population);
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {

		this.continent = format(continent);
	}

	public String getTld() {
		return tld;
	}

	public void setTld(String tld) {

		this.tld = format(tld);
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {

		this.currencyCode = format(currencyCode);
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {

		this.currencyName = format(currencyName);
		;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = format(phone);
	}

	public String getPostalCodeFormat() {
		return postalCodeFormat;
	}

	public void setPostalCodeFormat(String postalCodeFormat) {
		this.postalCodeFormat = format(postalCodeFormat);
	}

	public String getPostalCodeRegex() {
		return postalCodeRegex;
	}

	public void setPostalCodeRegex(String postalCodeRegex) {
		this.postalCodeRegex = format(postalCodeRegex);
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = format(languages);
	}

	public String getGeonameid() {
		return geonameid;
	}

	public void setGeonameid(String geonameid) {
		this.geonameid = format(geonameid);
	}

	public String getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(String neighbours) {
		this.neighbours = format(neighbours);
	}

	public String getEquivalentFipsCode() {
		return equivalentFipsCode;
	}

	public void setEquivalentFipsCode(String equivalentFipsCode) {
		this.equivalentFipsCode = format(equivalentFipsCode);
	}

	@Override
	public String toString() {
		return "CountryInfo [iSO=" + iSO + ", iSO3=" + iSO3 + ", iSONumeric=" + iSONumeric + ", fips=" + fips
				+ ", country=" + country + ", capital=" + capital + ", area=" + area + ", population=" + population
				+ ", continent=" + continent + ", tld=" + tld + ", currencyCode=" + currencyCode + ", currencyName="
				+ currencyName + ", phone=" + phone + ", postalCodeFormat=" + postalCodeFormat + ", postalCodeRegex="
				+ postalCodeRegex + ", languages=" + languages + ", geonameid=" + geonameid + ", neighbours="
				+ neighbours + ", equivalentFipsCode=" + equivalentFipsCode + "]";
	}

	private String format(String v) {
		if (v != null && v.isEmpty()) {
			return null;
		}

		return v.trim();
	}

}
