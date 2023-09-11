package org.example;

public class IntegerPoolUnboxing {

    public static void main(String[] args) {

        //Auto- Unboxing
        System.out.println(7 == new Integer(7));   //true
        System.out.println(7777 == new Integer(7777)); //true
        System.out.println(new Integer(7) == 7);   //true
        System.out.println(new Integer(7777) == 7777); //true
        System.out.println(new Integer(7) == new Integer(7));   // False   new Obj != new Obj
        System.out.println(new Integer(7777).equals(new Integer(7777))); // true  | comparement of values


        //Integer catche references -128 to 127
        final Integer i1 = 7;      // autoboxing cache
        final Integer i2 = 4711;   // autoboxing New

        System.out.println(i1 == new Integer(7));  //false, catche != new
        System.out.println(i2 == new Integer(4711));  //false, comparing New references
        System.out.println(i1 == Integer.valueOf(7));  //true, cache == cache
        System.out.println(i2 == Integer.valueOf(4711));  //false, comparing New references


        /**
         * <= and >= are used to compare primitives
         *  == is used to compare object references
         *  funny example comming up as next...
         */

        final Integer i3 = new Integer(1);
        final Integer i4 = new Integer(1);

        System.out.println( i3 >= i4);  //true
        System.out.println( i3 <= i4);  //true
        System.out.println(i3 == i4);   //False
    }
}
