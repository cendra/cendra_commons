package org.cendra.commons;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.cendra.commons.util.model.geo.populate.PopulateGeo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        PopulateGeo populateGeo = new PopulateGeo();
        
        try {
			populateGeo.populate();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
