package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Man {

    public Man(int age, String city)  {
        this.age = age;
        this.city = city;
    }

    int age;
    String city;

    public int getAge()     {return this.age;}
    public String getCity()     {return this.city;}
}




public class Predicates {
    public static void main(String[] args) {


        //Simple predicates
        final Predicate<String> isNull = str -> str == null;
        final Predicate<String> isEmpty = String::isEmpty;
        final Predicate<Man> isAdult = man -> man.getAge() >= 18;
        final Predicate<Man> livesInBerlin = man -> man.getCity().equals("Berlin");


        //Negation of predicate
        final Predicate<Man> isYoung = isAdult.negate();

        //Kombination of predicates with AND
        final Predicate<Man> boysFromBerlin = isYoung.and(livesInBerlin);

        //Kombination of predicates with OR
        final Predicate<Man> boysFromBerlinOrHamburg = boysFromBerlin
                .or(man -> man.getCity().equals("Hamburg"));




        Man pia = new Man(22, "Amsterdam");
        Man maxExample2 = new Man("17", "Berlin");

        List<Man> people = new ArrayList<>();
        people.addAll(List.of(pia, maxExample2));

        System.out.println("isNull(): " + isNull.test(""));
        System.out.println("isEmpty(): " + isEmpty.test(""));

        System.out.println("isYoung(): " + isYoung.test(pia));
        System.out.println("livesInBerlin(): " + livesInBerlin.test(pia));
        System.out.println("boysFromBerlin(): " + boysFromBerlin.test(pia));
        System.out.println("boysFromBerlinOrHamburg(): " + boysFromBerlinOrHamburg.test(pia));

        people.removeIf(boysFromBerlinOrHamburg);  // removing elements based on predicate!

        

    }
}
