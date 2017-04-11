package org.cendra.commons.model.geo;

public class Continente {

	private String id;
	private String nombre;

	private String urlWikipedia;
	private String urlWikipediaProyeccionOrtografica;
	private String urlProyeccionOrtografica;

	private Long geonameId;

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

	public Long getGeonameId() {
		return geonameId;
	}

	public void setGeonameId(Long geonameId) {
		this.geonameId = geonameId;
	}

}
