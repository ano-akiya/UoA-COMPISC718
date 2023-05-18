package ictgradschool.industry.tetdoku.model.shapes;

import ictgradschool.industry.tetdoku.model.CellCoordinate;
import ictgradschool.industry.tetdoku.model.CellDimension;

/**
 * Represents a shape that takes up a single cell on the game board.
 */
public class SingleCellShape extends TetdokuShape {

    /**
     * This shape is always 1x1.
     */
    @Override
    public CellDimension getSize() {
        return new CellDimension(1, 1);
    }

    /**
     * Since this shape only has a single point (it's 1x1 after all), we can just check that the given point is (0, 0).
     *
     * @param point the point to check
     * @return true if that point is the origin of our shape (0, 0).
     */
    @Override
    public boolean isFilled(CellCoordinate point) {
        return point.getCol() == 0 && point.getRow() == 0;
    }
}
