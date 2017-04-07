package org.cendra.commons.util.model;

public abstract class AbstractEntity {

	private String id;

	public String getId() {
		this.id = formatValue(id);

		return id;
	}

	public void setId(String id) {

		this.id = formatValue(id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		AbstractEntity other = (AbstractEntity) obj;

		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;

		return true;
	}

	@Override
	public String toString() {

		if (this.getId() != null) {
			return this.getId();
		}

		return "";
	}

	protected String formatValue(String value) {
		if (value != null && value.isEmpty()) {
			value = null;
		}

		if (value != null) {
			value = value.trim();
		}

		return value;
	}

}
