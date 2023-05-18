package ictgradschool.industry.tetdoku.model.shapes;

import ictgradschool.industry.tetdoku.model.CellCoordinate;
import ictgradschool.industry.tetdoku.model.CellDimension;

/**
 * A line shape is a single line of a given length. It can be either a vertical or horizontal line.
 * <p>
 * Mutating this shape causes it to flip between vertical and horizontal modes.
 */
public class LineShape extends TetdokuShape {

    /**
     * The length of this line shape
     */
    private final int length;

    /**
     * Creates a new line shape with the given length
     *
     * @param length the length
     */
    public LineShape(int length) {
        this.length = length;
    }

    /**
     * If this shape is horizontal, then its bounds will have a width equal to its length, and a height of 1. Otherwise,
     * it will have a width of 1 and a height equal to its length.
     *
     * @return this shape's size
     */
    @Override
    public CellDimension getSize() {
        return new CellDimension(length, 1);
    }

    /**
     * A point within this line shape's bounds is always considered "filled" (i.e. there's no "empty space"). So, we
     * just need to check that the given point is within bounds.
     *
     * @param point the point to check
     * @return true if that point is within this shape's bounds, false otherwise.
     */
    @Override
    public boolean isFilled(CellCoordinate point) {
        CellDimension size = getSize();
        return (point.getCol() >= 0 && point.getCol() < size.getWidth() &&
                point.getRow() >= 0 && point.getRow() < size.getHeight());
    }
}
