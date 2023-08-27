package org.example;

// States of an object durring object initialization


/* BAD DEFINED CLASS with a possibility to save and create object of invalid state

import java.io.IOException;

public final class SimpleImage {
    private String name;
    private int height;
    private int width;
    private byte[] imageData;

    public SimpleImage() {
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // other getters and setters

    public SimpleImage createSimpleImageFromFile() throws IOException {
        final  SimpleImage simpleImage = new SimpleImage():


        // HERE IS THE OBJECT TOO EARLY REGISTRED, NOT PROPER INIT
        storedImages.add(SimpleImage);
        final String imageName = readNameFromFile();  //setting name

        try {
            final int imgWidth = readWidthFromFile();
            simpleImage.setWidth(imgWidth)

            final int imgHeight = readHeightFromFile();
            simpleImage.setWidth(imgHeight);
        }
        catch (final NumberFormatException e) {
            // No exception "treatment" to demonstrate
        }

        final String imageData = readImageDataFromFile();
        simpleImage.setImageData(imageData);
        return simpleImage;
    }

    /**
     * INVALID STATE OF AND OBJECT
     * too early registred in a list
     * with part attributes not being defined
     *
     /

}
*/



//WAY TO PROPER INITIALIZE OBJECTS OF THIS CLASS AND AVOID CLIENTS TO GIVE OBJECTS INVALID STATE


import java.io.IOException;

public final class SimpleImage {
    private final String name;
    private int height;
    private int width;
    private byte[] imageData;

    public SimpleImage() {
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

// other getters


    public SimpleImage(String name, int height, int width, byte[] imageData) {
        this.name = name;
        changeImageData(width, height, imageData);
    }

    private void changeImageData(int width, int height, byte[] imageData) {
        this.width = width;
        this.height = height;
        this.imageData = imageData;
    }

    public SimpleImage createImageFromFile() throws IOException {
        final String imageName = readNameFromFile();


        try {
            final int imgWidth = readWidthFromFile();
            final int imgHeight = readHeightFromFile();
            final int imgData = readDataFromFile();
            final SimpleImage simpleImage = new SimpleImage(imageName, imgHeight, imgWidth, imgData);

            // Now its possible, if all parameters in a intermediadate state catched are, to create and store and object!

            storedImages.add(simpleImage);
            return simpleImage;
        } catch (final NumberFormatException e) {
            log.error("Failed to create Simpleimage object from file", ex);
        }
        throw new IOException("illegal content!");
    }
}
