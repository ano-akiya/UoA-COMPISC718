package ictgradschool.industry.tetdoku.model.shapes;

import ictgradschool.industry.tetdoku.model.CellCoordinate;
import ictgradschool.industry.tetdoku.model.CellDimension;


/**
 * Represents a shape to be placed on the gameboard.
 */
public abstract class TetdokuShape {

    /**
     * When overridden in a derived class, gets the width and height of this shape.
     *
     * @return
     */
    public abstract CellDimension getSize();

    /**
     * When overridden in a derived class, gets a boolean indicating whether the given cell is actually filled for
     * this shape. The coordinate to be supplied represents a cell coordinate, with (0, 0) being the top-left of the shape.
     *
     * @param point
     * @return
     */
    public abstract boolean isFilled(CellCoordinate point);
}
