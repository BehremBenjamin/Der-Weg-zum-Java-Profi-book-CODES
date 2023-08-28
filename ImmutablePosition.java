package org.example;

public class ImmutablePosition {
    private final int x;
    private final int y;

    public ImmutablePosition(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX()       {return x;}
    public int getY()       {return y;}

    public ImmutablePosition offset (final int xOffset, final int yOffset) {
        return new ImmutablePosition(x + xOffset, y + yOffset);
    }
}


/* JDK14 record version

record ImmutablePositionJDK14 (intx, int y) {

 public ImmutablePosition offset (final int xOffset, final int yOffset) {
        return new ImmutablePosition(x + xOffset, y + yOffset);
    }
}

*/
