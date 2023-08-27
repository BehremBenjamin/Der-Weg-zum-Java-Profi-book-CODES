package org.example;

//Invariant, pre and postcondition example

public final class GridPosition
{
    private static final int GRID_SIZE = 10;

    // Invariant: x,y grid size is always 10
    private int x = 0;
    private int y = 0;

    GridPosition()
    {
    }

    public void addOffset(final int dx, final int dy)
    {
        // precondition: x, y on arbitrary grid point
        checkOnGrid(x,y);

        x += snapToGrid(dx);
        y += snapToGrid(dy);

        // postcondition: x + (dy % 10), y + (dy % 10) on grid point
        checkOnGrid(x,y);
    }

    public void setSamePos(final int pos)
    {
        // precontidion: x, y on arbitrary grid point
        checkOnGrid(x,y);

        x = snapToGrid(pos);
        y = snapToGrid(pos);

        // postcondition: x = y = (pos % 10) on grid
        checkOnGrid(x,y);
    }

    private static void checkOnGrid(final int x, final int y)
    {
        if (x % GRID_SIZE != 0 || y % GRID_SIZE != 0)
            throw new IllegalStateException("invalid position, not on grid");
    }

    private int snapToGrid(final int value)
    {
        return value - value % GRID_SIZE;
    }

    public int getX()    				{ return x; }
    public int getY()   				{ return y; }

    // demostrating problems
    public void setX(final int x)		{ this.x = x; }
    public void setY(final int y)		{ this.y = y; }
}
