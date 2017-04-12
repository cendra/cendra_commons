package org.cendra.commons.model.geo;

public class PaisNombreAltenativo {

	private Lenguaje lenguaje;
	private String nombre;
	private Boolean preferido;
	private Boolean nombreCorto;
	private Boolean coloquial;
	private Boolean historico;

	public Lenguaje getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(Lenguaje lenguaje) {
		this.lenguaje = lenguaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getPreferido() {
		return preferido;
	}

	public void setPreferido(Boolean preferido) {
		this.preferido = preferido;
	}

	public Boolean getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(Boolean nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public Boolean getColoquial() {
		return coloquial;
	}

	public void setColoquial(Boolean coloquial) {
		this.coloquial = coloquial;
	}

	public Boolean getHistorico() {
		return historico;
	}

	public void setHistorico(Boolean historico) {
		this.historico = historico;
	}

}
