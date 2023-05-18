package ictgradschool.industry.tetdoku.view.painters;

import ictgradschool.industry.tetdoku.model.CellArea;
import ictgradschool.industry.tetdoku.model.CellCoordinate;
import ictgradschool.industry.tetdoku.model.shapes.TetdokuShape;
import ictgradschool.industry.tetdoku.view.colorscheme.GameColors;

import java.awt.*;

/**
 * A cell painter intended to draw a {@link TetdokuShape} at some location.
 */
public abstract class AbstractShapePainter extends AbstractCellPainter {

    /**
     * The shape to draw
     */
    protected final TetdokuShape shape;

    /**
     * Creates a new shape painter
     *
     * @param shape             the shape to draw
     * @param shapeCellLocation where to draw the shape, in cell coordinates
     * @param graphics          the graphics object to use to draw the shape
     * @param cellSize          the size of each cell, in pixels
     */
    public AbstractShapePainter(TetdokuShape shape, CellCoordinate shapeCellLocation, Graphics2D graphics, int cellSize) {
        super(graphics, cellSize, new CellArea(
                shapeCellLocation.getCol(), shapeCellLocation.getRow(),
                shape.getSize().getWidth(), shape.getSize().getHeight()));

        this.shape = shape;
    }

    /**
     * Ensures that "empty" shape cells aren't drawn by returning null in those cases.
     *
     * @return null if the shape is "empty" at the given col / row, or the value of {@link #getFilledShapeCellColor(int, int)} otherwise.
     */
    @Override
    protected final GameColors getCellColor(int col, int row) {

        int shapeX = col - this.area.getX();
        int shapeY = row - this.area.getY();

        if (this.shape.isFilled(new CellCoordinate(shapeX, shapeY))) {
            return getFilledShapeCellColor(col, row);
        } else {
            return null;
        }
    }

    /**
     * When overridden in a derived class, gets the color that should be used to draw the given shape cell in the event
     * that it is supposed to be drawn.
     */
    protected abstract GameColors getFilledShapeCellColor(int col, int row);
}
