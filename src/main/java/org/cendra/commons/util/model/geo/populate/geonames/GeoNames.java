package org.cendra.commons.util.model.geo.populate.geonames;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipException;

import org.cendra.commons.util.model.geo.populate.HttpUtil;
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

	public List<CountryInfo> getCountrysInfo(String pathHomeGeoNames) throws IOException {

		String uri = "http://download.geonames.org/export/dump/countryInfo.txt";
		String fileName = httpUtil.download(uri, pathHomeGeoNames);

		List<CountryInfo> countrysInfos = new ArrayList<CountryInfo>();

		CSVReader reader = new CSVReader(new FileReader(pathHomeGeoNames + File.separatorChar + fileName), '\t');

		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {

			CountryInfo countryInfo = new CountryInfo();
			countryInfo.setiSO(nextLine[0]);
			countryInfo.setiSO3(nextLine[1]);
			countryInfo.setiSONumeric(nextLine[2]);
			countryInfo.setFips(nextLine[3]);
			countryInfo.setCapital(nextLine[4]);
			countryInfo.setArea(nextLine[5]);
			countryInfo.setPopulation(nextLine[6]);
			countryInfo.setContinent(nextLine[7]);
			countryInfo.setTld(nextLine[8]);
			countryInfo.setCurrencyCode(nextLine[9]);
			countryInfo.setCurrencyName(nextLine[10]);
			countryInfo.setPhone(nextLine[11]);
			countryInfo.setPostalCodeFormat(nextLine[12]);
			countryInfo.setPostalCodeRegex(nextLine[13]);
			countryInfo.setLanguages(nextLine[14]);
			countryInfo.setGeonameid(nextLine[15]);
			countryInfo.setNeighbours(nextLine[16]);
			countryInfo.setEquivalentFipsCode(nextLine[17]);

			countrysInfos.add(countryInfo);

		}

		return countrysInfos;

	}

	public List<AlternateName> downloadAlternateNames(String pathHomeGeoNames, String pathAlternateNamesFile,
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
