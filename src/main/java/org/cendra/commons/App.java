package org.cendra.commons;

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
        
        populateGeo.populate();
    }
}
