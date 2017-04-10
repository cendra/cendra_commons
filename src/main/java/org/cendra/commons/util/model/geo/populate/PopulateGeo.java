package org.cendra.commons.util.model.geo.populate;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.cendra.commons.model.geo.Continente;

public class PopulateGeo {

	// AF : Africa geonameId=6255146
	// AS : Asia geonameId=6255147
	// EU : Europe geonameId=6255148
	// NA : North America geonameId=6255149
	// OC : Oceania geonameId=6255151
	// SA : South America geonameId=6255150
	// AN : Antarctica geonameId=6255152

	public void populate() {

		Continente continente = new Continente();
		continente.setGeonameId(6255146L);
		continente.setCodigo("AF");
		continente.setNombre("Africa");
		continente.setUrlWikipedia("https://en.wikipedia.org/wiki/Africa");
		continente.setUrlWikipediaImage(getUrlWikipediaImage(continente.getNombre()));
		System.out.println(continente.getUrlWikipediaImage());
		
		continente = new Continente();
		continente.setGeonameId(6255147L);
		continente.setCodigo("AS");
		continente.setNombre("Asia");
		continente.setUrlWikipedia("https://en.wikipedia.org/wiki/Asia");
		continente.setUrlWikipediaImage(getUrlWikipediaImage(continente.getNombre()));
		System.out.println(continente.getUrlWikipediaImage());
		
		continente = new Continente();
		continente.setGeonameId(6255148L);
		continente.setCodigo("EU");
		continente.setNombre("Europe");
		continente.setUrlWikipedia("https://en.wikipedia.org/wiki/Europe");
		continente.setUrlWikipediaImage(getUrlWikipediaImage(continente.getNombre()));
		System.out.println(continente.getUrlWikipediaImage());
		
		
		continente = new Continente();
		continente.setGeonameId(6255149L);
		continente.setCodigo("NA");
		continente.setNombre("North America");
		continente.setUrlWikipedia("https://en.wikipedia.org/wiki/North_America");
		continente.setUrlWikipediaImage(getUrlWikipediaImage(continente.getNombre()));
		System.out.println(continente.getUrlWikipediaImage());
		
		continente = new Continente();
		continente.setGeonameId(6255151L);
		continente.setCodigo("OC");
		continente.setNombre("Oceania");
		continente.setUrlWikipedia("https://en.wikipedia.org/wiki/Australia");
		continente.setUrlWikipediaImage(getUrlWikipediaImage(continente.getNombre()));
		System.out.println(continente.getUrlWikipediaImage());
		
		continente = new Continente();
		continente.setGeonameId(6255150L);
		continente.setCodigo("SA");
		continente.setNombre("South America");
		continente.setUrlWikipedia("https://en.wikipedia.org/wiki/South_America");
		continente.setUrlWikipediaImage(getUrlWikipediaImage(continente.getNombre()));
		System.out.println(continente.getUrlWikipediaImage());
		
		continente = new Continente();
		continente.setGeonameId(6255152L);
		continente.setCodigo("AN");
		continente.setNombre("Antarctica");
		continente.setUrlWikipedia("https://en.wikipedia.org/wiki/Antarctica");
		continente.setUrlWikipediaImage(getUrlWikipediaImage(continente.getNombre()));
		System.out.println(continente.getUrlWikipediaImage());

	}

	private String getUrlWikipediaImage(String nombre) {

		String s = this.getFile("https://en.wikipedia.org/wiki/File:" + nombre + "_(orthographic_projection).svg");

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

	private void download(String uri, String toPathFile) {
		try {
			// Url con la foto
			URL url = new URL(uri);

			// establecemos conexion
			URLConnection urlCon = url.openConnection();

			// Sacamos por pantalla el tipo de fichero
			System.out.println(urlCon.getContentType());

			// Se obtiene el inputStream de la foto web y se abre el fichero
			// local.
			InputStream is = urlCon.getInputStream();
			FileOutputStream fos = new FileOutputStream(toPathFile);

			// Lectura de la foto de la web y escritura en fichero local
			byte[] array = new byte[1000]; // buffer temporal de lectura.
			int leido = is.read(array);
			while (leido > 0) {
				fos.write(array, 0, leido);
				leido = is.read(array);
			}

			// cierre de conexion y fichero.
			is.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getFile(String path) {
		try {

			URL url = new URL(path);
			URLConnection urlc = url.openConnection();

			BufferedInputStream buffer = new BufferedInputStream(urlc.getInputStream());

			StringBuilder builder = new StringBuilder();
			int byteRead;
			while ((byteRead = buffer.read()) != -1)
				builder.append((char) byteRead);

			buffer.close();

			return builder.toString();

		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	private boolean ifExists(String path) {
		try {

			URL url = new URL(path);
			URLConnection urlc = url.openConnection();

			BufferedInputStream buffer = new BufferedInputStream(urlc.getInputStream());

			StringBuilder builder = new StringBuilder();
			int byteRead;
			while ((byteRead = buffer.read()) != -1)
				builder.append((char) byteRead);

			buffer.close();

			return builder.toString().length() > 0;

		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return false;
	}

}
