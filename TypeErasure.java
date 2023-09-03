package org.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


/**
 * @Author Benjamin Behrem
 * No type checking of generic container classes is possible
 *
 * */

class Person {

    private final String name;
    private final LocalDate date;
    private final String city;

    public Person(String name, LocalDate date, String city) {
        this.name = name;
        this.date = date;
        this.city = city;
    }
}

public class TypeErasure {

    public static void main(String[] args) {
        final String[] nicknames = {"dragonman", "iron mike", "Lordmaster"};

        final LocalDate feb7th = LocalDate.of(1971,2,7);
        final LocalDate jul17th = LocalDate.of(1970,7,17);
        final LocalDate aug22th = LocalDate.of(1970, 8, 22);

        final Person[] bowlingPeople ={ new Person("Sven", aug22th, "Kiel"),
                                        new Person("Michael", feb7th, "Bremen"),
                                        new Person("Andreas", jul17th, "Kiel")};


        //incomparable types: Class<String> and Class<Person>
                //final boolean sameType1 = (String.class == Person.class);

        /*
        incomparable types: Class<CAP#1> and Class<CAP#2> where CAP#1,CAP#2 are fresh type-variables:
        CAP#1 extends String[] from capture of ? extends String[]
        CAP#2 extends Person[] from capture of ? extends Person[]

        final boolean sameType2 = (nicknames.getClass() == bowlingPeople.getClass());
        */

        final boolean sameType3 = (nicknames.getClass().equals(bowlingPeople.getClass()));
        System.out.println("sametype3 " + sameType3);  //  FALSE


        // Typecasting with generics
        final List<String> nicknamesList = Arrays.asList(nicknames);
        final List<Person> bowlingPeopleList = Arrays.asList(bowlingPeople);

        //compile error: identifier expected
                //final boolean sameType1 = (List<String>.class == List<Person>.class);

        final boolean sameType2 = (nicknamesList.getClass() == bowlingPeopleList.getClass());

        System.out.println(sameType2);  // TRUE
    }
}
