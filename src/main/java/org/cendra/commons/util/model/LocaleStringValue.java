package org.cendra.commons.util.model;

import java.io.Serializable;

import org.cendra.commons.model.geo.ConfiguracionRegional;
import org.cendra.commons.model.geo.Continente;

public class LocaleStringValue implements Serializable, Cloneable, Comparable<Continente> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1335949476774739340L;

	private ConfiguracionRegional configuracionRegional;
	private String value;

	public ConfiguracionRegional getConfiguracionRegional() {
		return configuracionRegional;
	}

	public void setConfiguracionRegional(ConfiguracionRegional configuracionRegional) {
		this.configuracionRegional = configuracionRegional;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int compareTo(Continente o) {

		return 0;
	}

}
