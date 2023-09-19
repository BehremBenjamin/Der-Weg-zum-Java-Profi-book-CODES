package org.example;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.time.LocalDate;

public class Person {

    String name;
    String city;
    LocalDate birthday;

    public Person(String name, String city, LocalDate birthday) {
        this.name = name;
        this.city = city;
        this.birthday = birthday;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }


    public static void writeByteArray(final OutputStream os, final byte[] bytesToWrite) throws IOException {
        os.write(bytesToWrite.length);
        os.write(' ');
        os.write(bytesToWrite);
        os.flush();
    }

    public static void main(String[] args) throws Exception {

        final String tmpDir = System.getProperty("java.io.tmpdir");
        final File file = new File(tmpDir, "Person.ser1");
        final Person max = new Person("Max", "Bihac", LocalDate.now());

        //saves Max (Person instance) in Date and reads Date
        writePersonToStream(max, new FileOutputStream(file));
        final Person newPerson = readPersonFromStream(new FileInputStream(file));

        System.out.println("same?" + max.equals(newPerson));

    }

    public static byte[] readByteArray(final InputStream is) throws IOException {
        final int bytesLength = is.read();
        is.read();   // Stepping over empty field, line 48

        final byte[] bytes = new byte[bytesLength];
        is.read(bytes);
        return bytes;
    }

    public static Person readPersonFromStream(final InputStream is) throws
            FileNotFoundException, IOException {

        final byte[] nameBytes = readByteArray(is);
        final String name = new String(nameBytes);

        final byte[] cityByte = readByteArray(is);
        final String city = new String(cityByte);

        final byte[] birthDayByte = readByteArray(is);
        final LocalDate birthday = LocalDate.parse(new String(birthDayByte));

        // make sure that all data needed for a constructor are collected, before object construction

            /*  NOTICE
           successive initalisation: read data and then setAttribute() should be avoided
           Threat of object inconsistent form/shape
           */

        return new Person(name, city, birthday);
    }

    private static void writePersonToStream(final @NotNull Person person, final OutputStream os)
            throws IOException {

        // String -> getBytes()
        final byte[] nameBytes = person.getName().getBytes();
        final byte[] cityBytes = person.getCity().getBytes();

        //LocalDate -> String -> getBytes()
        final String dataString = person.getBirthday().toString();
        final byte[] dateBytes = dataString.getBytes();

        writeByteArray(os, nameBytes);
        writeByteArray(os, cityBytes);
        writeByteArray(os, dateBytes);
    }
}





