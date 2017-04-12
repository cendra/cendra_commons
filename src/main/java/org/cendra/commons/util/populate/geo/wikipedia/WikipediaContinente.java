package org.cendra.commons.util.populate.geo.wikipedia;

import java.io.IOException;

import org.cendra.commons.util.populate.geo.HttpUtil;

//https://en.wikipedia.org/wiki/Continent
public class WikipediaContinente {

	private HttpUtil httpUtil;

	public WikipediaContinente(HttpUtil httpUtil) {
		super();
		this.httpUtil = httpUtil;
	}

	public String getUrlWikipedia(String id) {

		// AF : Africa geonameId=6255146
		// AS : Asia geonameId=6255147
		// EU : Europe geonameId=6255148
		// NA : North America geonameId=6255149
		// OC : Oceania geonameId=6255151
		// SA : South America geonameId=6255150
		// AN : Antarctica geonameId=6255152

		if (id.equals("AF")) {
			return "https://en.wikipedia.org/wiki/Africa";
		} else if (id.equals("AS")) {
			return "https://en.wikipedia.org/wiki/Asia";
		} else if (id.equals("EU")) {
			return "https://en.wikipedia.org/wiki/Europe";
		} else if (id.equals("NA")) {
			return "https://en.wikipedia.org/wiki/North_America";
		} else if (id.equals("OC")) {
			return "https://en.wikipedia.org/wiki/Australia";
		} else if (id.equals("SA")) {
			return "https://en.wikipedia.org/wiki/South_America";
		} else if (id.equals("AN")) {
			return "https://en.wikipedia.org/wiki/Antarctica";
		}

		return null;
	}
	
	public String getUrlWikipediaDivisionPolitica(String id) {

		// AF : Africa geonameId=6255146
		// AS : Asia geonameId=6255147
		// EU : Europe geonameId=6255148
		// NA : North America geonameId=6255149
		// OC : Oceania geonameId=6255151
		// SA : South America geonameId=6255150
		// AN : Antarctica geonameId=6255152

		if (id.equals("AF")) {
			return "https://en.wikipedia.org/wiki/List_of_sovereign_states_and_dependent_territories_in_Africa";
		} else if (id.equals("AS")) {
			return "https://es.wikipedia.org/wiki/Anexo:Divisi%C3%B3n_pol%C3%ADtica_de_Asia";
		} else if (id.equals("EU")) {
			return "https://es.wikipedia.org/wiki/Anexo:Divisi%C3%B3n_pol%C3%ADtica_de_Europa";
		} else if (id.equals("NA")) {
			return "https://es.wikipedia.org/wiki/Anexo:Divisi%C3%B3n_pol%C3%ADtica_de_Am%C3%A9rica";
		} else if (id.equals("OC")) {
			return "https://es.wikipedia.org/wiki/Anexo:Divisi%C3%B3n_pol%C3%ADtica_de_Ocean%C3%ADa";
		} else if (id.equals("SA")) {
			return "https://es.wikipedia.org/wiki/Anexo:Divisi%C3%B3n_pol%C3%ADtica_de_Am%C3%A9rica";
		} else if (id.equals("AN")) {
			return "https://en.wikipedia.org/wiki/Antarctica";
		}

		return null;
	}

	public String getUrlWikipediaProyeccionOrtografica(String nombre) throws IOException {

		String s = httpUtil.getFile("https://en.wikipedia.org/wiki/File:" + nombre + "_(orthographic_projection).svg");

		if (s == null) {
			return null;
		}

		String key = "id=\"file\"";

		if (s.contains(key) == false) {
			return null;
		}

		s = s.split(key)[1];

		key = "href=\"";

		if (s.contains(key) == false) {
			return null;
		}

		s = s.split(key)[1];

		key = "\"";

		if (s.contains(key) == false) {
			return null;
		}

		s = s.split(key)[0];

		return "https:" + s;

	}

}
