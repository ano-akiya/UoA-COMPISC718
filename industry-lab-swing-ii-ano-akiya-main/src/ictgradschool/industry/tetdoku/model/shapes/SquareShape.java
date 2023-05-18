package ictgradschool.industry.tetdoku.model.shapes;

import ictgradschool.industry.tetdoku.model.CellCoordinate;
import ictgradschool.industry.tetdoku.model.CellDimension;

import java.awt.*;

/**
 * Represents a square shape. A square shape is an n-by-n grid of cells, all of which are filled.
 */
public class SquareShape extends TetdokuShape {

    /**
     * The size of the shape
     */
    private final int size;

    /**
     * Creates a new square shape with the given size
     *
     * @param size the size of the square
     */
    public SquareShape(int size) {
        this.size = size;
    }

    /**
     * The bounding box of the square shape, is a size-by-size square, centered on the origin.
     */
    @Override
    public CellDimension getSize() {
        return new CellDimension(size, size);
    }

    /**
     * A given point within a square shape is filled as long as the given point lies inside the shape's bounding box
     * (0, 0, size.width, size.height) - i.e. there's no "empty space".
     *
     * @param point the point to check
     * @return true if the given point lies inside this shape's bounds, false otherwise.
     */
    @Override
    public boolean isFilled(CellCoordinate point) {
        CellDimension size = getSize();
        return (point.getCol() >= 0 && point.getCol() < size.getWidth() &&
                point.getRow() >= 0 && point.getRow() < size.getHeight());
    }
}
