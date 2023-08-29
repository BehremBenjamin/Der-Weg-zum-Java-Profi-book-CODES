package org.example;


import java.util.Date;
import java.util.Objects;

public final class PeriodOfTime {

    private final Date start;
    private final Date end;


    /**
     * even tho parameters
     * @param start
     * @param end
     * are final, Date object is changable.
     * Class is without setters, but are available via Date object that is referenced!
     * To avoid mutability its is needed to decouple reference's "storage"
     * from the attribute
     */



    public PeriodOfTime(final Date start, final Date end) {

        Objects.requireNonNull(start, "start cant be null");
        Objects.requireNonNull(end, "end cant be null");

        if (start.after(end)) {
            throw new IllegalArgumentException("start must be <= end !!!");
        }

        this.start = start;
        this.end = end;
    }

    public Date getStart() {
       // return start;  -> BAD IMPLEMENTATION
        return new Date((start.getTime()));

    }

    public Date getEnd() {
        //return end;  -> BAD IMPLEMENTATION
        return new Date((end.getTime()));
    }

}
