package org.cendra.commons.model.geo;

public class Pais {

	private Continente continente;
	private Long geonameId;
	private String ISO3166Alpha2;
	private String ISO3166Alpha3;
	private Integer ISO3166Numeric;
	private String fips;
	private String equivalentFipsCode;
	private String nombre;
	private String capital;
	private String prefijoTelefónico;
	private String formatoCodigoPostal;
	private String expresionRegularCodigoPostal;
	private Moneda moneda;

	private String urlWikipedia;
	private String urlWikipediaProyeccionOrtografica;
	private String urlProyeccionOrtografica;
	private String urlWikipediaBandera;
	private String urlBandera;

	public Continente getContinente() {
		return continente;
	}

	public void setContinente(Continente continente) {
		this.continente = continente;
	}

	public Long getGeonameId() {
		return geonameId;
	}

	public void setGeonameId(Long geonameId) {
		this.geonameId = geonameId;
	}

	public String getISO3166Alpha2() {
		return ISO3166Alpha2;
	}

	public void setISO3166Alpha2(String iSO3166Alpha2) {
		ISO3166Alpha2 = iSO3166Alpha2;
	}

	public String getISO3166Alpha3() {
		return ISO3166Alpha3;
	}

	public void setISO3166Alpha3(String iSO3166Alpha3) {
		ISO3166Alpha3 = iSO3166Alpha3;
	}

	public Integer getISO3166Numeric() {
		return ISO3166Numeric;
	}

	public void setISO3166Numeric(Integer iSO3166Numeric) {
		ISO3166Numeric = iSO3166Numeric;
	}

	public String getFips() {
		return fips;
	}

	public void setFips(String fips) {
		this.fips = fips;
	}

	public String getEquivalentFipsCode() {
		return equivalentFipsCode;
	}

	public void setEquivalentFipsCode(String equivalentFipsCode) {
		this.equivalentFipsCode = equivalentFipsCode;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getPrefijoTelefónico() {
		return prefijoTelefónico;
	}

	public void setPrefijoTelefónico(String prefijoTelefónico) {
		this.prefijoTelefónico = prefijoTelefónico;
	}

	public String getFormatoCodigoPostal() {
		return formatoCodigoPostal;
	}

	public void setFormatoCodigoPostal(String formatoCodigoPostal) {
		this.formatoCodigoPostal = formatoCodigoPostal;
	}

	public String getExpresionRegularCodigoPostal() {
		return expresionRegularCodigoPostal;
	}

	public void setExpresionRegularCodigoPostal(String expresionRegularCodigoPostal) {
		this.expresionRegularCodigoPostal = expresionRegularCodigoPostal;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public String getUrlWikipedia() {
		return urlWikipedia;
	}

	public void setUrlWikipedia(String urlWikipedia) {
		this.urlWikipedia = urlWikipedia;
	}

	public String getUrlWikipediaProyeccionOrtografica() {
		return urlWikipediaProyeccionOrtografica;
	}

	public void setUrlWikipediaProyeccionOrtografica(String urlWikipediaProyeccionOrtografica) {
		this.urlWikipediaProyeccionOrtografica = urlWikipediaProyeccionOrtografica;
	}

	public String getUrlProyeccionOrtografica() {
		return urlProyeccionOrtografica;
	}

	public void setUrlProyeccionOrtografica(String urlProyeccionOrtografica) {
		this.urlProyeccionOrtografica = urlProyeccionOrtografica;
	}

	public String getUrlWikipediaBandera() {
		return urlWikipediaBandera;
	}

	public void setUrlWikipediaBandera(String urlWikipediaBandera) {
		this.urlWikipediaBandera = urlWikipediaBandera;
	}

	public String getUrlBandera() {
		return urlBandera;
	}

	public void setUrlBandera(String urlBandera) {
		this.urlBandera = urlBandera;
	}

}
