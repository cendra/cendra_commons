package org.cendra.commons;

import java.util.Locale;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        String[] s = Locale.getISOLanguages();
        
        for(String i : s){
        	System.out.println(i);
        }
    }
}
