package org.example;

import java.io.InputStream;
import java.net.URL;

public class JarResources {
    public static void main(String[] args) {

        final String filename = "C:/Users/benjo/OneDrive/Pictures/12212.jpg";

        //variant with class loader 1 and with class 2
        final URL imageURL1 =  JarResources.class.getClassLoader().getResource(filename); //1
        final URL imageURL2 = JarResources.class.getResource(filename); //2
        System.out.println("imageurl1 " + imageURL1);
        System.out.println("imageurl2 " + imageURL2);

        // with input stream
        final InputStream is1 = JarResources.class.getClassLoader().getResourceAsStream(filename);
        final InputStream is2 = JarResources.class.getResourceAsStream(filename);
        System.out.println("is1 " + is1);
        System.out.println("is2 " + is2);
    }
}
