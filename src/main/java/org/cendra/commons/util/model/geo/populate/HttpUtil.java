package org.cendra.commons.util.model.geo.populate;

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
import java.util.Properties;
import java.util.Map.Entry;

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

	public String download(String uri, String toPathFile) {
		try {
			// Url con la foto
			URL url = new URL(uri);

			// establecemos conexion
			URLConnection urlCon = url.openConnection();

			// Sacamos por pantalla el tipo de fichero
			System.out.println(urlCon.getContentType());

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
		} catch (Exception e) {
			e.printStackTrace();
		}

		return toPathFile;
	}

	public String getFile(String path) {
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

	public boolean ifExists(String path) {
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
