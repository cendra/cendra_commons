package org.cendra.commons.model.geo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.cendra.commons.util.model.AbstractEntityErasableCoded;
import org.cendra.commons.util.model.LocaleStringValue;

public class Continente extends AbstractEntityErasableCoded implements Serializable, Cloneable, Comparable<Continente> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4997445290007661114L;

	private List<LocaleStringValue> nombres = new ArrayList<LocaleStringValue>();
	private List<LocaleStringValue> descripciones = new ArrayList<LocaleStringValue>();

	public List<LocaleStringValue> getNombres() {
		return nombres;
	}
	
	public List<LocaleStringValue> getNombres(ConfiguracionRegional configuracionRegional) {
		return nombres;
	}

	public void setNombres(List<LocaleStringValue> nombres) {
		this.nombres = nombres;
	}

	public boolean addNombre(LocaleStringValue e) {
		return nombres.add(e);
	}

	public List<LocaleStringValue> getDescripciones() {
		return descripciones;
	}

	public void setDescripciones(List<LocaleStringValue> descripciones) {
		this.descripciones = descripciones;
	}

	public boolean addDescripcion(LocaleStringValue e) {
		return descripciones.add(e);
	}

	public int compareTo(Continente o) {

		return 0;
	}

}
