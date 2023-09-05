package org.example;

import java.util.function.UnaryOperator;

public class UnaryOperators_Functions {

    private static void printResult (final String text, final String value, final UnaryOperator<String> op) {
        System.out.println(text + ": '" + value + "'->'" + op.apply(value));
    }

    public static void main(String[] args) {

        //Mark
        final UnaryOperator<String> markTextWithM = str -> str.startsWith("M") ? ">>" +str.toUpperCase() + "<<" : str;

        printResult("Mark 1", "unchanged", markTextWithM);
        printResult("Mark 2", "Michael", markTextWithM);

        //trim
        final UnaryOperator<String> trimmer = String::trim;
        printResult("Trim1", "no_trim", trimmer);
        printResult("Trim1", "            trim me   now", trimmer);

        //Map
        final UnaryOperator<String> mapNullToEMpty = str -> str == null ? "" : str;

        printResult("Map same", "same", mapNullToEMpty);
        printResult("Map null", null, mapNullToEMpty);

    }

}
