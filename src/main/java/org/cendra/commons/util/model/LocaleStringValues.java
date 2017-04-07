package org.cendra.commons.util.model;

import java.util.ArrayList;

import org.cendra.commons.model.geo.ConfiguracionRegional;

public class LocaleStringValues extends ArrayList<LocaleStringValue> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3976459522516761141L;

	public LocaleStringValues getAll(ConfiguracionRegional configuracionRegional) {

		LocaleStringValues other = new LocaleStringValues();

		for (LocaleStringValue item : this) {
			if (item != null && item.getConfiguracionRegional().equals(configuracionRegional)) {
				other.add(item);
			}
		}

		return other;

	}

}
