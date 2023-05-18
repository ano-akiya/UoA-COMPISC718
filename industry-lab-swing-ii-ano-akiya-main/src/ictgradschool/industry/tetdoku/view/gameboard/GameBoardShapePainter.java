package ictgradschool.industry.tetdoku.view.gameboard;

import ictgradschool.industry.tetdoku.model.CellCoordinate;
import ictgradschool.industry.tetdoku.model.CellDimension;
import ictgradschool.industry.tetdoku.model.gameboard.GameBoard;
import ictgradschool.industry.tetdoku.model.shapes.TetdokuShape;
import ictgradschool.industry.tetdoku.view.colorscheme.GameColors;
import ictgradschool.industry.tetdoku.view.painters.AbstractShapePainter;

import java.awt.*;

/**
 * Intended to render the current shape on top of the gameboard, at the user's mouse location. The shape will be
 * colored differently depending on whether it actually fits on the gameboard at that location.
 */
public class GameBoardShapePainter extends AbstractShapePainter {

    /**
     * The color to draw the shape
     */
    private final GameColors shapeColor;

    /**
     * The size of the gameboard, in cells
     */
    private final CellDimension gameBoardSize;

    /**
     * Creates a new gameboard shape painter. Checks whether the given shape fits on the given gameboard at the given
     * location, and sets the color used to render the shape accordingly.
     *
     * @param shape             the shape to render
     * @param gameBoard         the gameboard we're checking to see if the shape fits
     * @param shapeCellLocation where the shape should be placed, in cells
     * @param graphics          the graphics object to use for rendering
     * @param cellSize          the size of the cells, in pixels
     */
    public GameBoardShapePainter(TetdokuShape shape, GameBoard gameBoard, CellCoordinate shapeCellLocation, Graphics2D graphics, int cellSize) {
        super(shape, shapeCellLocation, graphics, cellSize);

        this.gameBoardSize = gameBoard.getBoardSize();

        if (gameBoard.shapeFits(shape, shapeCellLocation)) {
            shapeColor = GameColors.PositiveHighlight;
        } else {
            shapeColor = GameColors.NegativeHighlight;
        }
    }

    /**
     * Ensures that the parts of this shape that are outside the gameboard aren't drawn at all.
     *
     * @param col the column to check
     * @param row the row to check
     * @return true if the given coordinate is within the gameboard's bounds, false otherwise
     */
    @Override
    protected boolean isInBounds(int col, int row) {
        return (col >= 0 && row >= 0 && col < gameBoardSize.getWidth() && row < gameBoardSize.getHeight());
    }

    /**
     * Returns the shape color that was calculated in the constructor
     */
    @Override
    protected GameColors getFilledShapeCellColor(int col, int row) {

        return shapeColor;
    }
}
