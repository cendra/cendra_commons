package org.cendra.commons.util.model;

public abstract class AbstractEntityErasableCoded extends AbstractEntityErasable {

	private String code;

	public String getCode() {
		this.code = formatValue(code);
		return code;
	}

	public void setCode(String code) {
		this.code = formatValue(code);
	}
	
	protected String formatValue(String value) {
		value = super.formatValue(value);
		
		if(value != null){
			value = value.toUpperCase();
		}

		return value;
	}

}
