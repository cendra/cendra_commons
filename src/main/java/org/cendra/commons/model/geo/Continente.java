package org.cendra.commons.model.geo;

public class Continente {

	private String id;
	private String nombre;

	private Long geonameId;
	private String urlWikipedia;
	private String urlWikipediaDivisionPolitica;
	private String urlWikipediaProyeccionOrtografica;
	private String urlProyeccionOrtografica;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

}
