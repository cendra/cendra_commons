package org.cendra.commons.util.model.geo.populate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.cendra.commons.model.geo.Continente;
import org.cendra.commons.util.model.geo.populate.geonames.ContinentCode;
import org.cendra.commons.util.model.geo.populate.geonames.GeoNames;
import org.cendra.commons.util.model.geo.populate.wikipedia.Wikipedia;

public class PopulateGeo {

	private HttpUtil httpUtil;
	private GeoNames geoNames;
	private Wikipedia wikipedia;

	private String pathConfig = "/home/java/dev/sources/cendra_commons/config";

	private String pathHome = "/home/java/Descargas";
	private String pathHomeGeo = pathHome + File.separatorChar + "geo";
	private String pathHomeGeoContinent = pathHomeGeo + File.separatorChar + "continente";
	private String pathHomeGeoNames = pathHomeGeo + File.separatorChar + "geonames";
//	private String pathAlternateNamesFile;

//	private List<Long> geonameIds = new ArrayList<Long>();

	private List<Continente> continentes = new ArrayList<Continente>();

	public void populate() throws FileNotFoundException, IOException {

		httpUtil = new HttpUtil(pathConfig);
		geoNames = new GeoNames(httpUtil);
		wikipedia = new Wikipedia(httpUtil);
//		geonameIds = new ArrayList<Long>();

		buildFolders();
		populateContinente();

	}

	private void buildFolders() {
		new File(pathHomeGeo).mkdirs();
		new File(pathHomeGeoContinent).mkdirs();
		new File(pathHomeGeoNames).mkdirs();
	}

	private void populateContinente() throws IOException {

		List<ContinentCode> continentsCodes = geoNames.getContinentsCodes();

		for (ContinentCode continentCode : continentsCodes) {

			Continente continente = new Continente();

			continente.setId(continentCode.getCode());
			continente.setNombre(continentCode.getName());
			continente.setGeonameId(Long.valueOf(continentCode.getGeonameId()));
			continente.setUrlWikipedia(wikipedia.getUrlWikipedia(continente.getId()));
			continente.setUrlWikipediaProyeccionOrtografica(
					wikipedia.getUrlWikipediaProyeccionOrtografica(continente.getNombre()));
			String fileName = httpUtil.download(continente.getUrlWikipediaProyeccionOrtografica(),
					pathHomeGeoContinent + File.separatorChar + continente.getId() + "_orthographic_projection");
			continente.setUrlProyeccionOrtografica(fileName);

			continentes.add(continente);
		}

	}

}
