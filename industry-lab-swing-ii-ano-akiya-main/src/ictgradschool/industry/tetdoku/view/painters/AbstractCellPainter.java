package ictgradschool.industry.tetdoku.view.painters;

import ictgradschool.industry.tetdoku.model.CellArea;
import ictgradschool.industry.tetdoku.view.colorscheme.GameColors;

import java.awt.*;

/**
 * A class which is capable of drawing grids of cells. The colors of those cells are determined by the abstract method
 * {@link #getCellColor(int, int)}, which should be overridden in derived classes.
 *
 * @author Andrew Meads
 */
public abstract class AbstractCellPainter {

    /**
     * Graphics object to use to draw stuff
     **/
    protected final Graphics2D graphics;

    /**
     * The size of a cell, in pixels
     */
    protected final int cellSize;

    /**
     * The X, Y, Width Height, in cells, to draw.
     */
    protected final CellArea area;

    /**
     * Creates a new cell painter
     *
     * @param graphics the graphics object to use to draw the cells
     * @param cellSize the size of the cells, in pixels
     * @param area     the grid area to draw, in the grid's own coordinate space
     */
    public AbstractCellPainter(Graphics2D graphics, int cellSize, CellArea area) {
        this.graphics = graphics;
        this.cellSize = cellSize;
        this.area = area;
    }

    /**
     * Draws the grid
     */
    public void paint() {
        for (int col = area.getX(); col < area.getX() + area.getWidth(); col++) {
            for (int row = area.getY(); row < area.getY() + area.getHeight(); row++) {

                GameColors cellVisuals = getCellColor(col, row);

                if (isInBounds(col, row) && cellVisuals != null) {
                    int cellX = col * cellSize;
                    int cellY = row * cellSize;

                    graphics.setColor(cellVisuals.getColor());
                    graphics.fillRect(cellX, cellY, cellSize, cellSize);
                }

            }
        }
    }

    /**
     * This method is called for each cell to draw. If it returns false, that cell won't be drawn.
     * <p>
     * By default this always returns true, but can be overridden if required.
     *
     * @param col the column to check
     * @param row the row to check
     * @return true if the cell at that row / col should be drawn, false otherwise
     */
    protected boolean isInBounds(int col, int row) {
        return true;
    }

    /**
     * When overridden in a derived class, gets the cell color to use for a particular cell.
     *
     * @param col the cell's column. Will be within the bounds supplied in the {@link #area} field.
     * @param row the cell's row. Will be within the bounds supplied in the {@link #area} field.
     * @return the appropriate {@link GameColors}, or null if no cell should be drawn there.
     */
    protected abstract GameColors getCellColor(int col, int row);
}
