package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Spielkarte {

    enum Color {CLUB, SPADE, HEART, DIAMOND}
    private final Color color;
    private final int number;
    // optional member String holderOfCards;   => if null values were accepted for this one

    public Spielkarte(final Color farba, int number) {

        this.color = Objects.requireNonNull(farba, "farba cant be null");
        this.number = number;
        // this.holderOfCards = holderOfCards;
    }

    /**
     * NULL Acceptance  - no nulls
     * Reflexivity x != null  x == x
     * Symmetry  x.equals(y) AND y.equals(x)
     * Transivity x.equals(y) , y.equals(z)  -> x.equals(z)
     * Consistency x,y != null ->  x.equals(y) TRUE / FALSE  consistent!
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null)      //preventing in the first place NullPointerException by not using .equals(Object)
            return false;
        if (this == obj)
            return true;
        if (this.getClass() != obj.getClass())
            return false;

       return compareAttributes((Spielkarte) obj);
    }

    public static void main(String[] args) {

        List<Spielkarte> spielkarten = new ArrayList<>();
        spielkarten.add(new Spielkarte(Color.HEART, 7));
        spielkarten.add(new Spielkarte(Color.SPADE, 8));
        spielkarten.add(new Spielkarte(Color.HEART, 9));

        final boolean found = spielkarten.contains(new Spielkarte(Color.SPADE, 8));

        System.out.println("found?: " + found);

    }

    private boolean compareAttributes(final Spielkarte spielkarte) {
        return (this.color.equals(spielkarte.color) && this.number == spielkarte.number);
        /**
         * in case that we have a memeber that can be null like holderOfCards in this class
         * we would need to add another predicate =>
         * && this.holderOfCards != null && this.holderOfCards.equals(spielkarte.holderOfCards);
         */
    }

    /** In case we have floating numbers and doubles as a class member which we need to compare, use this method
     * @param value  first value
     * @param expected value to be compared with
     * @param rangeOfTolerance the tolerance range that will be included when comparing
     * @return boolean value
     */
    public static boolean isEqualsWithPrecision(double value, double expected, double rangeOfTolerance) {
        return (value > expected - rangeOfTolerance && value < expected + rangeOfTolerance);
    }
}
