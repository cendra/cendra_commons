package org.cendra.commons.util.model.geo.populate.geonames;

public class ContinentCode {

	private String geonameId;
	private String code;
	private String name;

	public String getGeonameId() {
		return geonameId;
	}

	public void setGeonameId(String geonameId) {
		this.geonameId = geonameId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ContinentCodes [geonameid=" + geonameId + ", code=" + code + ", name=" + name + "]";
	}

}
