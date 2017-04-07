package org.cendra.commons.model.geo;

import java.io.Serializable;

import org.cendra.commons.util.model.AbstractEntityErasableCoded;

// ISO 639
public class Lenguaje extends AbstractEntityErasableCoded implements Serializable, Cloneable, Comparable<Lenguaje> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5817890474121748726L;

	public int compareTo(Lenguaje o) {
		
		if(this.getCode() != null){
			return this.getCode().compareToIgnoreCase(o.getCode());
		}

		return 0;
	}

}
