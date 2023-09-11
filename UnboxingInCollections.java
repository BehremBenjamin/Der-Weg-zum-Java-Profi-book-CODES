package org.example;

import java.util.ArrayList;
import java.util.List;

public class UnboxingInCollections {

    public static void main(String[] args) {

        final List<Integer> indexList = new ArrayList<>();

        indexList.add(7);
        indexList.add(8);

        // Autoboxing => Integer.valueOf(0) => remove(Object) or remove(int) ?
        final Integer removed = indexList.remove(0);
        System.out.println(removed); // first element in list will be removed since arg is int

        //Autounboxing => 8 => remove(int) ?
        final Integer value = 8;
        System.out.println(indexList.remove(value));  // true, Integer obj val 8 found and deleted!
    }
}
