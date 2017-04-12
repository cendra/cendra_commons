package org.cendra.commons.model.geo;

import java.util.ArrayList;
import java.util.List;

public class Pais {

	private Continente continente;

	private String id; // iso3166Alpha2
	private String iso3166Alpha3;
	private Integer iso3166Numeric;
	private String fips;
	private String equivalentFipsCode;
	private String nombre;
	private List<String> descripcionNombres = new ArrayList<String>();
	private String capital;
	private String prefijoTelefónico;
	private String formatoCodigoPostal;
	private String expresionRegularCodigoPostal;
	private Moneda moneda;

	private Long geonameId;

	private String urlWikipedia;
	private String urlWikipediaDivisionPolitica;
	private String urlGeoNames;

	private String urlProyeccionOrtografica;
	private String urlLocalProyeccionOrtografica;
	private String urlBanderaA;
	private String urlLocalBanderaA;
	private String urlBanderaB;
	private String urlLocalBanderaB;
	private String urlEscudo;
	private String urlLocalEscudo;
	private String urlRegion;
	private String urlLocalRegion;
	private String urlMapa;
	private String urlLocalMapa;

	public Continente getContinente() {
		return continente;
	}

	public void setContinente(Continente continente) {
		this.continente = continente;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIso3166Alpha3() {
		return iso3166Alpha3;
	}

	public void setIso3166Alpha3(String iso3166Alpha3) {
		this.iso3166Alpha3 = iso3166Alpha3;
	}

	public Integer getIso3166Numeric() {
		return iso3166Numeric;
	}

	public void setIso3166Numeric(Integer iso3166Numeric) {
		this.iso3166Numeric = iso3166Numeric;
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

	public List<String> getDescripcionNombres() {
		return descripcionNombres;
	}

	public void setDescripcionNombres(List<String> descripcionNombres) {
		this.descripcionNombres = descripcionNombres;
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

	public Long getGeonameId() {
		return geonameId;
	}

	public void setGeonameId(Long geonameId) {
		this.geonameId = geonameId;
	}

	public String getUrlWikipedia() {
		return urlWikipedia;
	}

	public void setUrlWikipedia(String urlWikipedia) {
		this.urlWikipedia = urlWikipedia;
	}

	public String getUrlWikipediaDivisionPolitica() {
		return urlWikipediaDivisionPolitica;
	}

	public void setUrlWikipediaDivisionPolitica(String urlWikipediaDivisionPolitica) {
		this.urlWikipediaDivisionPolitica = urlWikipediaDivisionPolitica;
	}

	public String getUrlGeoNames() {
		return urlGeoNames;
	}

	public void setUrlGeoNames(String urlGeoNames) {
		this.urlGeoNames = urlGeoNames;
	}

	public String getUrlProyeccionOrtografica() {
		return urlProyeccionOrtografica;
	}

	public void setUrlProyeccionOrtografica(String urlProyeccionOrtografica) {
		this.urlProyeccionOrtografica = urlProyeccionOrtografica;
	}

	public String getUrlLocalProyeccionOrtografica() {
		return urlLocalProyeccionOrtografica;
	}

	public void setUrlLocalProyeccionOrtografica(String urlLocalProyeccionOrtografica) {
		this.urlLocalProyeccionOrtografica = urlLocalProyeccionOrtografica;
	}

	public String getUrlBanderaA() {
		return urlBanderaA;
	}

	public void setUrlBanderaA(String urlBanderaA) {
		this.urlBanderaA = urlBanderaA;
	}

	public String getUrlLocalBanderaA() {
		return urlLocalBanderaA;
	}

	public void setUrlLocalBanderaA(String urlLocalBanderaA) {
		this.urlLocalBanderaA = urlLocalBanderaA;
	}

	public String getUrlBanderaB() {
		return urlBanderaB;
	}

	public void setUrlBanderaB(String urlBanderaB) {
		this.urlBanderaB = urlBanderaB;
	}

	public String getUrlLocalBanderaB() {
		return urlLocalBanderaB;
	}

	public void setUrlLocalBanderaB(String urlLocalBanderaB) {
		this.urlLocalBanderaB = urlLocalBanderaB;
	}

	public String getUrlEscudo() {
		return urlEscudo;
	}

	public void setUrlEscudo(String urlEscudo) {
		this.urlEscudo = urlEscudo;
	}

	public String getUrlLocalEscudo() {
		return urlLocalEscudo;
	}

	public void setUrlLocalEscudo(String urlLocalEscudo) {
		this.urlLocalEscudo = urlLocalEscudo;
	}

	public String getUrlRegion() {
		return urlRegion;
	}

	public void setUrlRegion(String urlRegion) {
		this.urlRegion = urlRegion;
	}

	public String getUrlLocalRegion() {
		return urlLocalRegion;
	}

	public void setUrlLocalRegion(String urlLocalRegion) {
		this.urlLocalRegion = urlLocalRegion;
	}

	public String getUrlMapa() {
		return urlMapa;
	}

	public void setUrlMapa(String urlMapa) {
		this.urlMapa = urlMapa;
	}

	public String getUrlLocalMapa() {
		return urlLocalMapa;
	}

	public void setUrlLocalMapa(String urlLocalMapa) {
		this.urlLocalMapa = urlLocalMapa;
	}

}
