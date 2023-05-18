package ictgradschool.industry.tetdoku.view.painters;

import ictgradschool.industry.tetdoku.model.CellArea;
import ictgradschool.industry.tetdoku.view.colorscheme.GameLineStyles;

import java.awt.*;

/**
 * A class which can draw lines "between" cells on a cell grid. Intended to be overridden for specific purposes such as
 * rendering the gameboard gridlines, or the "shape view" gridlines.
 *
 * @author Andrew Meads
 */
public abstract class AbstractGridLinesPainter {

    private final Graphics2D graphics;

    private final int cellSize;

    /**
     * X and Y correspond to starting position within the cell grid; Width and Height correspond to number of cols & rows.
     */
    private final CellArea area;

    /**
     * Creates a new gridlines painter
     *
     * @param graphics the graphics to use to draw the lines
     * @param cellSize the cell size of the grid, used to calculate the line size and location
     * @param area     the area over which to draw gridlines, in cells. Lines will be drawn between each rown & column.
     */
    public AbstractGridLinesPainter(Graphics2D graphics, int cellSize, CellArea area) {
        this.graphics = graphics;
        this.cellSize = cellSize;
        this.area = area;
    }

    /**
     * Paints all gridlines.
     */
    public void paint() {
        paintHorizontalLines();
        paintVerticalLines();
    }

    /**
     * Draws all vertial lines on the grid.
     */
    private void paintVerticalLines() {

        int lineYStart = area.getY() * cellSize;
        int lineYEnd = lineYStart + area.getHeight() * cellSize;

        for (int col = area.getX(); col <= area.getX() + area.getWidth(); col++) {

            int lineX = col * cellSize;
            GameLineStyles lineColor = getLineColor(col, false);

            paintLine(graphics, lineColor, lineX, lineYStart, lineX, lineYEnd);
        }
    }

    /**
     * Draws all horizontal lines on the grid.
     */
    private void paintHorizontalLines() {

        int lineXStart = area.getX() * cellSize;
        int lineXEnd = lineXStart + area.getWidth() * cellSize;

        for (int row = area.getY(); row <= area.getY() + area.getHeight(); row++) {

            int lineY = row * cellSize;
            GameLineStyles lineColor = getLineColor(row, true);

            paintLine(graphics, lineColor, lineXStart, lineY, lineXEnd, lineY);
        }
    }

    /**
     * Paints a single line at the given coordinates using the given graphics object.
     *
     * @param graphics  the graphics object to use to draw the line.
     * @param lineColor the color of line
     * @param x1        the starting x coordinate, in pixels
     * @param y1        the starting y coordinate, in pixels
     * @param x2        the ending x coordinate, in pixels
     * @param y2        the ending y coordinate, in pixels
     */
    private void paintLine(Graphics2D graphics, GameLineStyles lineColor, int x1, int y1, int x2, int y2) {
        graphics.setColor(lineColor.getColor());
        graphics.setStroke(lineColor.getStroke());
        graphics.drawLine(x1, y1, x2, y2);
    }

    /**
     * When overridden in a derived class, get the line color & style to use to draw the particular line in question
     *
     * @param lineNumber the line number
     * @param isRowLine  true if this is a line between rows, false if this is a line between columns
     * @return the color & style of line to draw
     */
    protected abstract GameLineStyles getLineColor(int lineNumber, boolean isRowLine);
}
