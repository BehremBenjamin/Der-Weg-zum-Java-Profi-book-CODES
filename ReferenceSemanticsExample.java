package org.example;

import java.util.Arrays;

public class ReferenceSemanticsExample {
    public static void changeSomething(String[] names) {

        // changes in referenced array
        names[0] = "Benjamin";
        names[1] = "Behrem";

        //no influence on an array
        names = new String[] {"Nearly Empty"};
    }

    public static void main(String[] args) {
        final String names[] = {"Test1", "Test2", "!!!"};

        changeSomething(names);
        System.out.println(Arrays.toString(names));
    }
}
