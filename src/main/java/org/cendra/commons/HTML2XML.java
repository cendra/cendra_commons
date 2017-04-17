package org.cendra.commons;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

class HTML2XML {

	public static void main(String args[]) throws JDOMException {
		InputStream isInHtml = null;
		URL url = null;
		URLConnection connection = null;
		DataInputStream disInHtml = null;
		FileOutputStream fosOutHtml = null;
		FileWriter fwOutXml = null;
		FileReader frInHtml = null;
		BufferedWriter bwOutXml = null;
		BufferedReader brInHtml = null;
		try {
			// url = new URL("www.climb.co.jp");
			// connection = url.openConnection();
			// isInHtml = connection.getInputStream();

			frInHtml = new FileReader("/home/java/Descargas/Belgium - Wikipedia.html");
			brInHtml = new BufferedReader(frInHtml);
			SAXBuilder saxBuilder = new SAXBuilder("org.ccil.cowan.tagsoup.Parser", false);
			org.jdom.Document jdomDocument = saxBuilder.build(brInHtml);

			List<Element> list = jdomDocument.getRootElement().getChildren();

			for (Element e : list) {
				if(e.getName().equals("body")){
					List<Element> listBody = e.getChildren();
					for (Element eb : listBody) {
						System.out.println(eb);	
					}
						
				}
					
			}

			// XMLOutputter outputter = new XMLOutputter();
			// org.jdom.output.Format newFormat = outputter.getFormat();
			// String encoding = "iso-8859-2";
			// newFormat.setEncoding(encoding);
			// outputter.setFormat(newFormat);
			//
			// try {
			// outputter.output(jdomDocument, System.out);
			// fwOutXml = new FileWriter("/home/java/Descargas/Belgium -
			// Wikipedia.xml");
			// bwOutXml = new BufferedWriter(fwOutXml);
			// outputter.output(jdomDocument, bwOutXml);
			// System.out.flush();
			// } catch (IOException e) {
			// }

		} catch (IOException e) {
		} finally {
			System.out.flush();
			try {
				isInHtml.close();
				disInHtml.close();
				fosOutHtml.flush();
				fosOutHtml.getFD().sync();
				fosOutHtml.close();
				fwOutXml.flush();
				fwOutXml.close();
				bwOutXml.close();
			} catch (Exception w) {

			}
		}
	}
}