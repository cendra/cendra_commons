package org.cendra.commons.util.populate.geo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.cendra.commons.model.geo.Continente;
import org.cendra.commons.model.geo.Moneda;
import org.cendra.commons.model.geo.Pais;
import org.cendra.commons.util.populate.geo.geonames.ContinentCode;
import org.cendra.commons.util.populate.geo.geonames.CountryInfo;
import org.cendra.commons.util.populate.geo.geonames.GeoNames;
import org.cendra.commons.util.populate.geo.wikipedia.WikipediaContinente;

public class PopulateGeo {

	private HttpUtil httpUtil;

	private GeoNames geoNames;
	private WikipediaContinente wikipedia;

	private String pathConfig = "/home/java/dev/sources/cendra_commons/config";

	private String pathHome = "/home/java/Descargas";

	private String pathGeoModel = pathHome + File.separatorChar + "geo_model";

	private String pathData = pathGeoModel + File.separatorChar + "data";
	private String pathContinente = pathData + File.separatorChar + "continente";
	private String pathPais = pathData + File.separatorChar + "pais";

	private String pathDownload = pathGeoModel + File.separatorChar + "download";
	private String pathGeoNames = pathDownload + File.separatorChar + "geonames";
	// private String pathAlternateNamesFile;

	// private List<Long> geonameIds = new ArrayList<Long>();

	private List<Log> logs = new ArrayList<Log>();

	private List<Continente> continentes = new ArrayList<Continente>();
	private List<Pais> paises = new ArrayList<Pais>();

	public void populate() throws FileNotFoundException, IOException {

		httpUtil = new HttpUtil(pathConfig);
		geoNames = new GeoNames(httpUtil);
		wikipedia = new WikipediaContinente(httpUtil);
		// geonameIds = new ArrayList<Long>();

		buildFolders();
		// populateContinente();
		populatePais();
		
		for(Log log : logs){
			System.out.println(log);
		}

	}

	private void buildFolders() {
		new File(pathGeoModel).mkdirs();
		new File(pathGeoNames).mkdirs();
		new File(pathContinente).mkdirs();
		new File(pathPais).mkdirs();

	}

	private void populateContinente() throws IOException {

		List<ContinentCode> continentsCodes = geoNames.getContinentsCodes();

		for (ContinentCode continentCode : continentsCodes) {

			Continente continente = new Continente();

			continente.setId(continentCode.getCode());
			continente.setNombre(continentCode.getName());
			continente.setGeonameId(Long.valueOf(continentCode.getGeonameId()));
			continente.setUrlWikipedia(wikipedia.getUrlWikipedia(continente.getId()));
			continente.setUrlWikipediaDivisionPolitica(wikipedia.getUrlWikipediaDivisionPolitica(continente.getId()));
			continente.setUrlWikipediaProyeccionOrtografica(
					wikipedia.getUrlWikipediaProyeccionOrtografica(continente.getNombre()));
			String fileName = httpUtil.download(continente.getUrlWikipediaProyeccionOrtografica(),
					pathContinente + File.separatorChar + continente.getId() + "_orthographic_projection");
			continente.setUrlProyeccionOrtografica(fileName);

			continentes.add(continente);
		}

	}

	private void populatePais() throws IOException {

		List<CountryInfo> countrysInfo = geoNames.getCountrysInfo(pathGeoNames);

		for (CountryInfo countryInfo : countrysInfo) {

			Pais pais = new Pais();

			if (countryInfo.getContinent() != null) {
				Continente continente = new Continente();
				continente.setId(countryInfo.getContinent());
				pais.setContinente(continente);
			}

			pais.setId(countryInfo.getiSO());
			pais.setIso3166Alpha3(countryInfo.getiSO3());
			if (countryInfo.getiSONumeric() != null) {
				pais.setIso3166Numeric(Integer.valueOf(countryInfo.getiSONumeric()));
			}
			pais.setFips(countryInfo.getFips());
			pais.setEquivalentFipsCode(countryInfo.getEquivalentFipsCode());
			pais.setNombre(countryInfo.getCountry());

			pais.setCapital(countryInfo.getCapital());
			pais.setPrefijoTelefónico(countryInfo.getPhone());
			pais.setFormatoCodigoPostal(countryInfo.getPostalCodeFormat());
			pais.setExpresionRegularCodigoPostal(countryInfo.getPostalCodeRegex());

			if (countryInfo.getContinent() != null) {
				Moneda moneda = new Moneda();
				moneda.setId(countryInfo.getCurrencyCode());
				pais.setMoneda(moneda);
			}

			if (httpUtil.ifExists(geoNames.getUrlMapa(pais.getId()))) {

				pais.setUrlMapa(geoNames.getUrlMapa(pais.getId()));

				String fileName = httpUtil.download(pais.getUrlMapa(),
						pathPais + File.separatorChar + pais.getId() + "_mapa");
				pais.setUrlLocalMapa(fileName);

			} else if (httpUtil.ifExists(geoNames.getUrlMapa(pais.getIso3166Alpha3()))) {

				pais.setUrlMapa(geoNames.getUrlMapa(pais.getIso3166Alpha3()));

				String fileName = httpUtil.download(pais.getUrlMapa(),
						pathPais + File.separatorChar + pais.getIso3166Alpha3() + "_mapa");
				pais.setUrlLocalMapa(fileName);
			} else if (httpUtil.ifExists(geoNames.getUrlMapa(pais.getFips()))) {
				pais.setUrlMapa(geoNames.getUrlMapa(pais.getFips()));

				String fileName = httpUtil.download(pais.getUrlMapa(),
						pathPais + File.separatorChar + pais.getFips() + "_mapa");
				pais.setUrlLocalMapa(fileName);
			}

			if (httpUtil.ifExists(geoNames.getUrlGeoNames(pais.getId(), pais.getNombre()))) {

				pais.setUrlGeoNames(geoNames.getUrlGeoNames(pais.getId(), pais.getNombre()));

			} else if (httpUtil.ifExists(geoNames.getUrlGeoNames(pais.getIso3166Alpha3(), pais.getNombre()))) {

				pais.setUrlGeoNames(geoNames.getUrlGeoNames(pais.getIso3166Alpha3(), pais.getNombre()));

			} else if (httpUtil.ifExists(geoNames.getUrlGeoNames(pais.getFips(), pais.getNombre()))) {

				pais.setUrlGeoNames(geoNames.getUrlGeoNames(pais.getFips(), pais.getNombre()));

			} else {
				throw new RuntimeException("No se pudo cargar el atributo 'URL GeoNames' para el país " + pais.getId());
			}

			if (httpUtil.ifExists(geoNames.getUrlMapa(pais.getId()))) {

				pais.setUrlMapa(geoNames.getUrlMapa(pais.getId()));

				String fileName = httpUtil.download(pais.getUrlMapa(),
						pathPais + File.separatorChar + pais.getId() + "_mapa");
				pais.setUrlLocalMapa(fileName);

			} else if (httpUtil.ifExists(geoNames.getUrlMapa(pais.getIso3166Alpha3()))) {

				pais.setUrlMapa(geoNames.getUrlMapa(pais.getIso3166Alpha3()));

				String fileName = httpUtil.download(pais.getUrlMapa(),
						pathPais + File.separatorChar + pais.getId() + "_mapa");
				pais.setUrlLocalMapa(fileName);

			} else if (httpUtil.ifExists(geoNames.getUrlMapa(pais.getFips()))) {
				pais.setUrlMapa(geoNames.getUrlMapa(pais.getFips()));

				String fileName = httpUtil.download(pais.getUrlMapa(),
						pathPais + File.separatorChar + pais.getId() + "_mapa");
				pais.setUrlLocalMapa(fileName);

			} else if (httpUtil.ifExists(geoNames.getUrlMapa(pais.getEquivalentFipsCode()))) {
				pais.setUrlMapa(geoNames.getUrlMapa(pais.getEquivalentFipsCode()));

				String fileName = httpUtil.download(pais.getUrlMapa(),
						pathPais + File.separatorChar + pais.getId() + "_mapa");
				pais.setUrlLocalMapa(fileName);

			} else {
				Log log = new Log();
				log.setType(Log.TYPE_WARNING);
				log.setId(pais.getId());
				log.setClassName(pais.getClass().getSimpleName());
				log.addAtt("urlMapa");
				log.addAtt("urlLocalMapa");
				log.setSubject("No se pudo cargar el atributo 'URL Mapa' para el país " + pais.getId());
				log.setMsg("URLs: " + geoNames.getUrlMapa(pais.getId()) + ", "
						+ geoNames.getUrlMapa(pais.getIso3166Alpha3()) + ", " + geoNames.getUrlMapa(pais.getFips())
						+ ", " + geoNames.getUrlMapa(pais.getEquivalentFipsCode()));
				
				logs.add(log);

			}

			if (httpUtil.ifExists(geoNames.getUrlBanderaA(pais.getId()))) {

				pais.setUrlBanderaA(geoNames.getUrlBanderaA(pais.getId()));

				String fileName = httpUtil.download(pais.getUrlBanderaA(),
						pathPais + File.separatorChar + pais.getId() + "_bandera_a");
				pais.setUrlLocalBanderaA(fileName);

			} else if (httpUtil.ifExists(geoNames.getUrlBanderaA(pais.getIso3166Alpha3()))) {

				pais.setUrlBanderaA(geoNames.getUrlBanderaA(pais.getIso3166Alpha3()));

				String fileName = httpUtil.download(pais.getUrlBanderaA(),
						pathPais + File.separatorChar + pais.getId() + "_bandera_a");
				pais.setUrlLocalBanderaA(fileName);

			} else if (httpUtil.ifExists(geoNames.getUrlBanderaA(pais.getFips()))) {

				pais.setUrlBanderaA(geoNames.getUrlBanderaA(pais.getFips()));

				String fileName = httpUtil.download(pais.getUrlBanderaA(),
						pathPais + File.separatorChar + pais.getId() + "_bandera_a");
				pais.setUrlLocalBanderaA(fileName);

			} else {
				throw new RuntimeException(
						"No se pudo cargar el atributo 'URL Bandera A' para el país " + pais.getId());
			}

			paises.add(pais);
		}

	}

}
