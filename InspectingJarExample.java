package org.example;

import java.io.File;
import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class InspectingJarExample {
    public static void main(String[] args) throws IOException {
        final String jarFileName = "C:\\Users\\benjo\\jar_files\\jaro\\iceberg.jar";
        final File file = new File(jarFileName);
        System.out.println(file.getAbsolutePath());
        System.out.println(" 'jar file name = '" + jarFileName + "'");

        //determine information objects
        try (final JarFile jarFile = new JarFile(jarFileName)) {
            final Manifest manifest = jarFile.getManifest();
            final Attributes attributes = manifest.getMainAttributes();

            // Reading infos
            final String mainClassName = attributes.getValue(Attributes.Name.MAIN_CLASS);
            System.out.println("'main class name = '" + mainClassName + "'");

            final String createdBy = attributes.getValue("Created-By");
            System.out.println("'Created By: ' " + createdBy + "'");

            final String manifestVersion = attributes.getValue(Attributes.Name.MANIFEST_VERSION);
            System.out.println("'manifest Version'" + manifestVersion + "'");
        }
    }
}
