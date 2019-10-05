package cells;

import java.awt.Point;

public abstract class Cell {
    private Point loc;

    public Cell(Point loc) {
        this.loc = loc;
    }

    public Point getLoc() {
        return loc;
    }

}