package org.cendra.commons.util.populate.geo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

public class HttpUtil {

	private Properties mimeTypes;
	private Properties mimeTypes2;

	public HttpUtil(String pathConfig) throws FileNotFoundException, IOException {
		loadProperties(pathConfig);
	}

	private void loadProperties(String pathConfig) throws FileNotFoundException, IOException {
		mimeTypes = new Properties();
		mimeTypes2 = new Properties();

		mimeTypes.load(new FileInputStream(pathConfig + File.separatorChar + "mime-types.properties"));

		for (Iterator<Entry<Object, Object>> iterator = mimeTypes.entrySet().iterator(); iterator.hasNext();) {
			Entry<Object, Object> entry = (Entry<Object, Object>) iterator.next();

			if (entry.getValue().toString().contains(",")) {
				String[] values = entry.getValue().toString().split(",");
				for (String value : values) {
					mimeTypes2.put(value, entry.getKey());
				}
			} else {
				mimeTypes2.put(entry.getValue(), entry.getKey());
			}

		}

	}

	public String download(String uri, String toPathFile) throws IOException {

		// Url con la foto
		URL url = new URL(uri);

		// establecemos conexion
		URLConnection urlCon = url.openConnection();

		// Sacamos por pantalla el tipo de fichero
		// System.out.println(urlCon.getContentType());

		toPathFile += "." + mimeTypes2.getProperty(urlCon.getContentType());

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

		return toPathFile;
	}

	public String getFile(String path) throws IOException {

		URL url = new URL(path);
		URLConnection urlc = url.openConnection();

		BufferedInputStream buffer = new BufferedInputStream(urlc.getInputStream());

		StringBuilder builder = new StringBuilder();
		int byteRead;
		while ((byteRead = buffer.read()) != -1)
			builder.append((char) byteRead);

		buffer.close();

		return builder.toString();

	}

	public boolean ifExists(String path) {
		URL url;
		try {
			url = new URL(path);
		} catch (MalformedURLException e) {
			return false;
		}
		URLConnection urlc;
		try {
			urlc = url.openConnection();
		} catch (IOException e) {
			return false;
		}
		
		try {
			urlc.getContentType();
		} catch (Exception e) {
			return false;
		}
		
		try {
			InputStream is = urlc.getInputStream();
		} catch (Exception e) {
			return false;
		}

		return true;

	}

	public boolean ifExists() {

		String path = "http://en.wikipedia.org/wiki/Andorra";

		URL url;
		try {
			url = new URL(path);
		} catch (MalformedURLException e) {
			return false;
		}
		URLConnection urlc;
		try {
			urlc = url.openConnection();
		} catch (IOException e) {
			return false;
		}
		
		try {
			urlc.getContentType();
		} catch (Exception e) {
			return false;
		}
		
		try {
			InputStream is = urlc.getInputStream();
		} catch (Exception e) {
			return false;
		}
		
		

		return true;

	}

}
