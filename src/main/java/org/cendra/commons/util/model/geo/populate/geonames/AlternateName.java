package org.cendra.commons.util.model.geo.populate.geonames;

public class AlternateName {

	private String alternateNameId;
	private Long geonameId;
	private String isolanguage;
	private String alternateName;
	private String isPreferredName;
	private String isShortName;
	private String isColloquial;
	private String isHistoric;

	public String getAlternateNameId() {
		return alternateNameId;
	}

	public void setAlternateNameId(String alternateNameId) {
		alternateNameId = format(alternateNameId);
		this.alternateNameId = alternateNameId;
	}

	@Override
	public String toString() {
		return "AlternateName [alternateNameId=" + alternateNameId + ", geonameId=" + geonameId + ", isolanguage="
				+ isolanguage + ", alternateName=" + alternateName + ", isPreferredName=" + isPreferredName
				+ ", isShortName=" + isShortName + ", isColloquial=" + isColloquial + ", isHistoric=" + isHistoric
				+ "]";
	}

	public Long getGeonameId() {
		return geonameId;
	}

	public void setGeonameId(Long geonameId) {		
		this.geonameId = geonameId;
	}

	public String getIsolanguage() {
		return isolanguage;
	}

	public void setIsolanguage(String isolanguage) {
		isolanguage = format(isolanguage);
		this.isolanguage = isolanguage;
	}

	public String getAlternateName() {
		return alternateName;
	}

	public void setAlternateName(String alternateName) {
		alternateName = format(alternateName);
		this.alternateName = alternateName;
	}

	public String getIsPreferredName() {
		return isPreferredName;
	}

	public void setIsPreferredName(String isPreferredName) {
		isPreferredName = format(isPreferredName);
		this.isPreferredName = isPreferredName;
	}

	public String getIsShortName() {
		return isShortName;
	}

	public void setIsShortName(String isShortName) {
		isShortName = format(isShortName);
		this.isShortName = isShortName;
	}

	public String getIsColloquial() {
		return isColloquial;
	}

	public void setIsColloquial(String isColloquial) {
		isColloquial = format(isColloquial);
		this.isColloquial = isColloquial;
	}

	public String getIsHistoric() {
		return isHistoric;
	}

	public void setIsHistoric(String isHistoric) {
		isHistoric = format(isHistoric);
		this.isHistoric = isHistoric;
	}

	private String format(String v) {
		if (v != null && v.isEmpty()) {
			return null;
		}

		return v.trim();
	}

}
