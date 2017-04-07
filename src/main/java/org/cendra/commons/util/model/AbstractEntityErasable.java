package org.cendra.commons.util.model;

public abstract class AbstractEntityErasable extends AbstractEntity {

	private Boolean erased;

	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

}
