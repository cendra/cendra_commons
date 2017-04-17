package org.cendra.commons.util.populate.geo.geonames;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipException;

import org.cendra.commons.util.populate.geo.HttpUtil;
import org.cendra.commons.util.zip.UtilZip;

import au.com.bytecode.opencsv.CSVReader;

public class GeoNames {

	private HttpUtil httpUtil;

	public GeoNames(HttpUtil httpUtil) {
		super();
		this.httpUtil = httpUtil;
	}

	public List<ContinentCode> getContinentsCodes() {

		// AF : Africa geonameId=6255146
		// AS : Asia geonameId=6255147
		// EU : Europe geonameId=6255148
		// NA : North America geonameId=6255149
		// OC : Oceania geonameId=6255151
		// SA : South America geonameId=6255150
		// AN : Antarctica geonameId=6255152

		List<ContinentCode> continentsCodes = new ArrayList<ContinentCode>();

		ContinentCode continentCode = new ContinentCode();
		continentCode.setGeonameId("6255146");
		continentCode.setCode("AF");
		continentCode.setName("Africa");
		continentsCodes.add(continentCode);

		continentCode = new ContinentCode();
		continentCode.setGeonameId("6255147");
		continentCode.setCode("AS");
		continentCode.setName("Asia");
		continentsCodes.add(continentCode);

		continentCode = new ContinentCode();
		continentCode.setGeonameId("6255148");
		continentCode.setCode("EU");
		continentCode.setName("Europe");
		continentsCodes.add(continentCode);

		continentCode = new ContinentCode();
		continentCode.setGeonameId("6255149");
		continentCode.setCode("NA");
		continentCode.setName("North America");
		continentsCodes.add(continentCode);

		continentCode = new ContinentCode();
		continentCode.setGeonameId("6255151");
		continentCode.setCode("OC");
		continentCode.setName("Oceania");
		continentsCodes.add(continentCode);

		continentCode = new ContinentCode();
		continentCode.setGeonameId("6255150");
		continentCode.setCode("SA");
		continentCode.setName("South America");
		continentsCodes.add(continentCode);

		continentCode = new ContinentCode();
		continentCode.setGeonameId("6255152");
		continentCode.setCode("AN");
		continentCode.setName("Antarctica");
		continentsCodes.add(continentCode);

		return continentsCodes;

	}

	public List<CountryInfo> getCountrysInfo(String pathGeoNames) throws IOException {

		String uri = "http://download.geonames.org/export/dump/countryInfo.txt";
		String filePath = httpUtil.download(uri, pathGeoNames + File.separatorChar + "countryInfo");

		List<CountryInfo> countrysInfos = new ArrayList<CountryInfo>();

		CSVReader reader = new CSVReader(new FileReader(filePath), '\t');

		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {

			if (nextLine[0].startsWith("#") == false) {
				CountryInfo countryInfo = new CountryInfo();
				countryInfo.setiSO(nextLine[0]);
				countryInfo.setiSO3(nextLine[1]);
				countryInfo.setiSONumeric(nextLine[2]);
				countryInfo.setFips(nextLine[3]);
				countryInfo.setCountry(nextLine[4]);
				countryInfo.setCapital(nextLine[5]);
				countryInfo.setArea(nextLine[6]);
				countryInfo.setPopulation(nextLine[7]);
				countryInfo.setContinent(nextLine[8]);
				countryInfo.setTld(nextLine[9]);
				countryInfo.setCurrencyCode(nextLine[10]);
				countryInfo.setCurrencyName(nextLine[11]);
				countryInfo.setPhone(nextLine[12]);
				countryInfo.setPostalCodeFormat(nextLine[13]);
				countryInfo.setPostalCodeRegex(nextLine[14]);
				countryInfo.setLanguages(nextLine[15]);
				countryInfo.setGeonameid(nextLine[16]);
				countryInfo.setNeighbours(nextLine[17]);
				countryInfo.setEquivalentFipsCode(nextLine[18]);

				countrysInfos.add(countryInfo);

			}

		}

		return countrysInfos;
	}

	public String getUrlGeoNames(String id, String nombre) {
		return "http://www.geonames.org/countries/" + id + "/" + nombre.replace(" ", "-") + ".html";
	}

	public String getUrlGeoNamesDivisionPolitica(String id, String nombre) {

		return "http://www.geonames.org/" + id + "/administrative-division-" + nombre.toLowerCase().replace(" ", "-")
				+ ".html";
	}

	public String getUrlMapa(String id) {

		if ("CW".equalsIgnoreCase(id)) {
			id = "CK";
		}

		return "http://www.geonames.org/img/country/250/" + id + ".png";

	}

	public String getUrlBanderaA(String id) {

		return "http://www.geonames.org/flags/x/" + id.toLowerCase() + ".gif";

	}

	public String getUrlWikipediaPais(String url) throws IOException {

		String s = httpUtil.getFile(url);

		if (s == null) {
			return null;
		}

		String key = "<h3>";

		if (s.contains(key) == false) {
			return null;
		}

		s = s.split(key)[1];

		key = "href";

		if (s.contains(key) == false) {
			return null;
		}

		s = s.split(key)[1];

		key = "=";

		if (s.contains(key) == false) {
			return null;
		}

		s = s.split(key)[1];

		key = "\"";

		if (s.contains(key) == false) {
			return null;
		}

		s = s.split(key)[1];

		return s;

	}

	// =======================================================================================

	private List<AlternateName> downloadAlternateNames(String pathHomeGeoNames, String pathAlternateNamesFile,
			List<Long> geonameIds) throws ZipException, IOException {
		String alternateNamestxt = "alternateNames.txt";

		String uri = "http://download.geonames.org/export/dump/alternateNames.zip";

		// String fileName = download(uri, pathHomeGeoNames);
		String fileName = "alternateNames.zip";

		String path = pathHomeGeoNames + File.separatorChar + "alternateNames";

		UtilZip utilZip = new UtilZip();

		utilZip.unZipFiles(new File(pathHomeGeoNames + File.separatorChar + fileName), path);

		pathAlternateNamesFile = path + File.separatorChar + alternateNamestxt;

		return readAlternateName(geonameIds, pathAlternateNamesFile);

	}

	private List<AlternateName> readAlternateName(List<Long> geonameIds, String pathAlternateNamesFile)
			throws IOException {

		List<AlternateName> alternateNames = new ArrayList<AlternateName>();

		CSVReader reader = new CSVReader(new FileReader(pathAlternateNamesFile), '\t');

		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {

			for (Long geonameId : geonameIds) {

				if (nextLine[1].trim().equals(geonameId.toString())) {

					AlternateName alternateName = new AlternateName();

					alternateName.setAlternateNameId(nextLine[0]);
					alternateName.setGeonameId(geonameId);
					alternateName.setIsolanguage(nextLine[2]);
					alternateName.setAlternateName(nextLine[3]);
					alternateName.setIsPreferredName(nextLine[4]);
					alternateName.setIsShortName(nextLine[5]);
					alternateName.setIsColloquial(nextLine[6]);
					alternateName.setIsHistoric(nextLine[7]);

					alternateNames.add(alternateName);

					System.out.println(alternateName);
				}
			}

		}

		return alternateNames;
	}

}
