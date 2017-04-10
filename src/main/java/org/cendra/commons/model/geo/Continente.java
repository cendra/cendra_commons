package org.cendra.commons.model.geo;

// https://en.wikipedia.org/wiki/Continent
public class Continente {

	private String urlWikipedia;
	private String urlWikipediaImage;
	private Long geonameId;
	private String codigo;
	private String nombre;

	public String getUrlWikipedia() {
		return urlWikipedia;
	}

	public void setUrlWikipedia(String urlWikipedia) {
		this.urlWikipedia = urlWikipedia;
	}

	public String getUrlWikipediaImage() {
		return urlWikipediaImage;
	}

	public void setUrlWikipediaImage(String urlWikipediaImage) {
		this.urlWikipediaImage = urlWikipediaImage;
	}

	public Long getGeonameId() {
		return geonameId;
	}

	public void setGeonameId(Long geonameId) {
		this.geonameId = geonameId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
