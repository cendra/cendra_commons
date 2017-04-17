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

		for (Log log : logs) {
			if (log.getType().equals(Log.TYPE_ERROR)) {
				System.out.println(log);
			}
		}

		for (Log log : logs) {
			if (log.getType().equals(Log.TYPE_WARNING)) {
				System.out.println(log);
			}
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

			// --------------------------------------------------------------------------

			if (continentCode.getCode() != null) {
				continente.setId(continentCode.getCode());
			} else {
				Log log = new Log();
				log.setType(Log.TYPE_ERROR);
				log.setId(continente.getId());
				log.setClassName(continente.getClass().getSimpleName());
				log.addAtt("id");
				log.setSubject("No se pudo cargar el atributo 'Id' para el contienete " + continente.getId());
				log.setMsg("El atributo es nulo en countryInfo.");

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (continentCode.getName() != null) {
				continente.setNombre(continentCode.getName());
			} else {
				Log log = new Log();
				log.setType(Log.TYPE_ERROR);
				log.setId(continente.getId());
				log.setClassName(continente.getClass().getSimpleName());
				log.addAtt("nombre");
				log.setSubject("No se pudo cargar el atributo 'Nombre' para el contienete " + continente.getId());
				log.setMsg("El atributo es nulo en countryInfo.");

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (continentCode.getGeonameId() != null) {

				try {
					continente.setGeonameId(Long.valueOf(continentCode.getGeonameId()));
				} catch (Exception e) {
					Log log = new Log();
					log.setType(Log.TYPE_ERROR);
					log.setId(continente.getId());
					log.setClassName(continente.getClass().getSimpleName());
					log.addAtt("geonameId");
					log.setSubject(
							"No se pudo cargar el atributo 'Geoname Id' para el contienete " + continente.getId());
					log.setMsg("El atributo no es numérico en countryInfo.");

					logs.add(log);
				}

			} else {
				Log log = new Log();
				log.setType(Log.TYPE_ERROR);
				log.setId(continente.getId());
				log.setClassName(continente.getClass().getSimpleName());
				log.addAtt("geonameId");
				log.setSubject("No se pudo cargar el atributo 'Geoname Id' para el contienete " + continente.getId());
				log.setMsg("El atributo es nulo en countryInfo.");

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (httpUtil.ifExists(wikipedia.getUrlWikipedia(continente.getId()))) {

				continente.setUrlWikipedia(wikipedia.getUrlWikipedia(continente.getId()));

			} else {
				Log log = new Log();
				log.setType(Log.TYPE_WARNING);
				log.setId(continente.getId());
				log.setClassName(continente.getClass().getSimpleName());
				log.addAtt("urlWikipedia");
				log.setSubject(
						"No se pudo cargar el atributo 'URL Wikipedia' para el continente " + continente.getId());
				log.setMsg("URL: " + wikipedia.getUrlWikipedia(continente.getId()));

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (httpUtil.ifExists(wikipedia.getUrlWikipediaDivisionPolitica(continente.getId()))) {

				continente
						.setUrlWikipediaDivisionPolitica(wikipedia.getUrlWikipediaDivisionPolitica(continente.getId()));

			} else {
				Log log = new Log();
				log.setType(Log.TYPE_WARNING);
				log.setId(continente.getId());
				log.setClassName(continente.getClass().getSimpleName());
				log.addAtt("urlWikipediaDivisionPolitica");
				log.setSubject("No se pudo cargar el atributo 'URL Wikipedia Division Politica' para el continente "
						+ continente.getId());
				log.setMsg("URL: " + wikipedia.getUrlWikipediaDivisionPolitica(continente.getId()));

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (httpUtil.ifExists(wikipedia.getUrlWikipediaProyeccionOrtografica(continente.getNombre()))) {

				continente.setUrlWikipediaProyeccionOrtografica(
						wikipedia.getUrlWikipediaProyeccionOrtografica(continente.getNombre()));

				String fileName = httpUtil.download(continente.getUrlWikipediaProyeccionOrtografica(),
						pathContinente + File.separatorChar + continente.getId() + "_orthographic_projection");
				continente.setUrlLocalProyeccionOrtografica(fileName);

			} else {
				Log log = new Log();
				log.setType(Log.TYPE_WARNING);
				log.setId(continente.getId());
				log.setClassName(continente.getClass().getSimpleName());
				log.addAtt("urlLocalProyeccionOrtografica");
				log.setSubject(
						"No se pudo cargar el atributo 'URL Wikipedia Proyeccion Ortografica' para el continente "
								+ continente.getId());
				log.setMsg("URL: " + wikipedia.getUrlWikipediaProyeccionOrtografica(continente.getNombre()));

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			continentes.add(continente);
		}

	}

	private void populatePais() throws IOException {

		List<CountryInfo> countrysInfo = geoNames.getCountrysInfo(pathGeoNames);

		for (CountryInfo countryInfo : countrysInfo) {

			Pais pais = new Pais();

			// --------------------------------------------------------------------------

			if (countryInfo.getContinent() != null) {
				Continente continente = new Continente();
				continente.setId(countryInfo.getContinent());
				pais.setContinente(continente);
			} else {
				Log log = new Log();
				log.setType(Log.TYPE_ERROR);
				log.setId(pais.getId());
				log.setClassName(pais.getClass().getSimpleName());
				log.addAtt("continente");
				log.setSubject("No se pudo cargar el atributo 'Continente' para el país " + pais.getId());
				log.setMsg("El atributo es nulo en countryInfo. " + countryInfo);

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (countryInfo.getiSO() != null) {
				pais.setId(countryInfo.getiSO());
			} else {
				Log log = new Log();
				log.setType(Log.TYPE_ERROR);
				log.setId(pais.getId());
				log.setClassName(pais.getClass().getSimpleName());
				log.addAtt("iso");
				log.setSubject("No se pudo cargar el atributo 'ISO' para el país " + pais.getId());
				log.setMsg("El atributo es nulo en countryInfo. " + countryInfo);

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (countryInfo.getiSO3() != null) {
				pais.setIso3166Alpha3(countryInfo.getiSO3());
			} else {
				Log log = new Log();
				log.setType(Log.TYPE_ERROR);
				log.setId(pais.getId());
				log.setClassName(pais.getClass().getSimpleName());
				log.addAtt("iso3166Alpha3");
				log.setSubject("No se pudo cargar el atributo 'ISO 3166 Alpha 3' para el país " + pais.getId());
				log.setMsg("El atributo es nulo en countryInfo. " + countryInfo);

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (countryInfo.getiSONumeric() != null) {

				try {
					pais.setIso3166Numeric(Integer.valueOf(countryInfo.getiSONumeric()));
				} catch (Exception e) {
					Log log = new Log();
					log.setType(Log.TYPE_ERROR);
					log.setId(pais.getId());
					log.setClassName(pais.getClass().getSimpleName());
					log.addAtt("iso3166Numeric");
					log.setSubject("No se pudo cargar el atributo 'ISO 3166 Numeric' para el país " + pais.getId());
					log.setMsg("El atributo no es numérico en countryInfo. " + countryInfo);

					logs.add(log);
				}

			} else {
				Log log = new Log();
				log.setType(Log.TYPE_ERROR);
				log.setId(pais.getId());
				log.setClassName(pais.getClass().getSimpleName());
				log.addAtt("iso3166Numeric");
				log.setSubject("No se pudo cargar el atributo 'ISO 3166 Numeric' para el país " + pais.getId());
				log.setMsg("El atributo es nulo en countryInfo. " + countryInfo);

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (countryInfo.getFips() != null) {
				pais.setFips(countryInfo.getFips());
			} else {
				Log log = new Log();
				log.setType(Log.TYPE_WARNING);
				log.setId(pais.getId());
				log.setClassName(pais.getClass().getSimpleName());
				log.addAtt("fips");
				log.setSubject("No se pudo cargar el atributo 'Fips' para el país " + pais.getId());
				log.setMsg("El atributo es nulo en countryInfo. " + countryInfo);

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (countryInfo.getFips() != null) {
				pais.setEquivalentFipsCode(countryInfo.getEquivalentFipsCode());
			} else {
				Log log = new Log();
				log.setType(Log.TYPE_WARNING);
				log.setId(pais.getId());
				log.setClassName(pais.getClass().getSimpleName());
				log.addAtt("equivalentFipsCode");
				log.setSubject("No se pudo cargar el atributo 'EquivalentFipsCode' para el país " + pais.getId());
				log.setMsg("El atributo es nulo en countryInfo. " + countryInfo);

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (countryInfo.getCountry() != null) {
				pais.setNombre(countryInfo.getCountry());
			} else {
				Log log = new Log();
				log.setType(Log.TYPE_ERROR);
				log.setId(pais.getId());
				log.setClassName(pais.getClass().getSimpleName());
				log.addAtt("nombre");
				log.setSubject("No se pudo cargar el atributo 'Nombre' para el país " + pais.getId());
				log.setMsg("El atributo es nulo en countryInfo. " + countryInfo);

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (countryInfo.getCapital() != null) {
				pais.setCapital(countryInfo.getCapital());
			} else {
				Log log = new Log();
				log.setType(Log.TYPE_WARNING);
				log.setId(pais.getId());
				log.setClassName(pais.getClass().getSimpleName());
				log.addAtt("capital");
				log.setSubject("No se pudo cargar el atributo 'Capital' para el país " + pais.getId());
				log.setMsg("El atributo es nulo en countryInfo. " + countryInfo);

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (countryInfo.getPhone() != null) {
				pais.setPrefijoTelefónico(countryInfo.getPhone());
			} else {
				Log log = new Log();
				log.setType(Log.TYPE_ERROR);
				log.setId(pais.getId());
				log.setClassName(pais.getClass().getSimpleName());
				log.addAtt("prefijoTelefónico");
				log.setSubject("No se pudo cargar el atributo 'Prefijo Telefónico' para el país " + pais.getId());
				log.setMsg("El atributo es nulo en countryInfo. " + countryInfo);

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (countryInfo.getPostalCodeFormat() != null) {
				pais.setFormatoCodigoPostal(countryInfo.getPostalCodeFormat());
			} else {
				Log log = new Log();
				log.setType(Log.TYPE_WARNING);
				log.setId(pais.getId());
				log.setClassName(pais.getClass().getSimpleName());
				log.addAtt("formatoCodigoPostal");
				log.setSubject("No se pudo cargar el atributo 'Formato Codigo Postal' para el país " + pais.getId());
				log.setMsg("El atributo es nulo en countryInfo. " + countryInfo);

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (countryInfo.getPostalCodeRegex() != null) {
				pais.setExpresionRegularCodigoPostal(countryInfo.getPostalCodeRegex());
			} else {
				Log log = new Log();
				log.setType(Log.TYPE_WARNING);
				log.setId(pais.getId());
				log.setClassName(pais.getClass().getSimpleName());
				log.addAtt("expresionRegularCodigoPostal");
				log.setSubject(
						"No se pudo cargar el atributo 'Expresion Regular Codigo Postal' para el país " + pais.getId());
				log.setMsg("El atributo es nulo en countryInfo. " + countryInfo);

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (countryInfo.getCurrencyCode() != null) {
				Moneda moneda = new Moneda();
				moneda.setId(countryInfo.getCurrencyCode());
				pais.setMoneda(moneda);
			} else {
				Log log = new Log();
				log.setType(Log.TYPE_WARNING);
				log.setId(pais.getId());
				log.setClassName(pais.getClass().getSimpleName());
				log.addAtt("moneda");
				log.setSubject("No se pudo cargar el atributo 'Moneda' para el país " + pais.getId());
				log.setMsg("El atributo es nulo en countryInfo. " + countryInfo);

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (countryInfo.getGeonameid() != null) {

				try {
					pais.setGeonameId(Long.valueOf(countryInfo.getGeonameid()));
				} catch (Exception e) {
					Log log = new Log();
					log.setType(Log.TYPE_ERROR);
					log.setId(pais.getId());
					log.setClassName(pais.getClass().getSimpleName());
					log.addAtt("geonameId");
					log.setSubject("No se pudo cargar el atributo 'Geoname Id' para el país " + pais.getId());
					log.setMsg("El atributo no es numérico en countryInfo. " + countryInfo);

					logs.add(log);
				}

			} else {
				Log log = new Log();
				log.setType(Log.TYPE_ERROR);
				log.setId(pais.getId());
				log.setClassName(pais.getClass().getSimpleName());
				log.addAtt("geonameId");
				log.setSubject("No se pudo cargar el atributo 'Geoname Id' para el país " + pais.getId());
				log.setMsg("El atributo es nulo en countryInfo. " + countryInfo);

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (httpUtil.ifExists(geoNames.getUrlGeoNames(pais.getId(), pais.getNombre()))) {

				pais.setUrlGeoNames(geoNames.getUrlGeoNames(pais.getId(), pais.getNombre()));

			} else if (httpUtil.ifExists(geoNames.getUrlGeoNames(pais.getIso3166Alpha3(), pais.getNombre()))) {

				pais.setUrlGeoNames(geoNames.getUrlGeoNames(pais.getIso3166Alpha3(), pais.getNombre()));

			} else if (httpUtil.ifExists(geoNames.getUrlGeoNames(pais.getFips(), pais.getNombre()))) {

				pais.setUrlGeoNames(geoNames.getUrlGeoNames(pais.getFips(), pais.getNombre()));

			} else {
				Log log = new Log();
				log.setType(Log.TYPE_ERROR);
				log.setId(pais.getId());
				log.setClassName(pais.getClass().getSimpleName());
				log.addAtt("urlGeoNames");
				log.setSubject("No se pudo cargar el atributo 'URL Geo Names' para el país " + pais.getId());
				log.setMsg("URLs: " + geoNames.getUrlGeoNames(pais.getId(), pais.getNombre()) + ", "
						+ geoNames.getUrlGeoNames(pais.getIso3166Alpha3(), pais.getNombre()) + ", "
						+ geoNames.getUrlGeoNames(pais.getFips(), pais.getNombre()));

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (httpUtil.ifExists(geoNames.getUrlGeoNamesDivisionPolitica(pais.getId(), pais.getNombre()))) {

				pais.setUrlWikipedia(geoNames.getUrlGeoNamesDivisionPolitica(pais.getId(), pais.getNombre()));

			} else {
				Log log = new Log();
				log.setType(Log.TYPE_ERROR);
				log.setId(pais.getId());
				log.setClassName(pais.getClass().getSimpleName());
				log.addAtt("urlGeoNamesDivisionPolitica");
				log.setSubject(
						"No se pudo cargar el atributo 'URL GeoNames Division Politica' para el país " + pais.getId());
				log.setMsg("URLs: " + geoNames.getUrlGeoNamesDivisionPolitica(pais.getId(), pais.getNombre()));

				logs.add(log);
			}

			// --------------------------------------------------------------------------

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

			// --------------------------------------------------------------------------

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
				Log log = new Log();
				log.setType(Log.TYPE_WARNING);
				log.setId(pais.getId());
				log.setClassName(pais.getClass().getSimpleName());
				log.addAtt("urlBanderaA");
				log.addAtt("urlLocalBanderaA");
				log.setSubject("No se pudo cargar el atributo 'URL Bandera A' para el país " + pais.getId());
				log.setMsg("URLs: " + geoNames.getUrlBanderaA(pais.getId()) + ", "
						+ geoNames.getUrlBanderaA(pais.getIso3166Alpha3()) + ", "
						+ geoNames.getUrlBanderaA(pais.getFips()));

				logs.add(log);
			}

			// --------------------------------------------------------------------------

			if (httpUtil.ifExists(pais.getUrlGeoNames())
					&& httpUtil.ifExists(geoNames.getUrlWikipediaPais(pais.getUrlGeoNames()))) {

				pais.setUrlWikipedia(geoNames.getUrlWikipediaPais(pais.getUrlGeoNames()));

			} else {
				Log log = new Log();
				log.setType(Log.TYPE_WARNING);
				log.setId(pais.getId());
				log.setClassName(pais.getClass().getSimpleName());
				log.addAtt("urlWikipedia");
				log.setSubject("No se pudo cargar el atributo 'URL Wikipedia' para el país " + pais.getId());
				log.setMsg("URLs: " + geoNames.getUrlWikipediaPais(pais.getUrlGeoNames()));

				logs.add(log);

			}

			// --------------------------------------------------------------------------

			// System.out.println(pais);

			paises.add(pais);
		}

	}

}
