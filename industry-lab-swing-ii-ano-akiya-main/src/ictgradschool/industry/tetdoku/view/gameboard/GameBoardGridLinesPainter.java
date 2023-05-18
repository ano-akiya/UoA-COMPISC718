package ictgradschool.industry.tetdoku.view.gameboard;

import ictgradschool.industry.tetdoku.model.CellArea;
import ictgradschool.industry.tetdoku.model.gameboard.GameBoard;
import ictgradschool.industry.tetdoku.view.colorscheme.GameLineStyles;
import ictgradschool.industry.tetdoku.view.painters.AbstractGridLinesPainter;

import java.awt.*;

/**
 * Draws the gameboard's line grid, with "major" lines between sudoku "squares" and on the gameboard's borders,
 * and "minor" lines between all other cells.
 */
public class GameBoardGridLinesPainter extends AbstractGridLinesPainter {

    private final GameBoard gameBoard;

    /**
     * Creates a new gameboard gridlines painter
     *
     * @param gameBoard the gameboard whose gridlines we are rendering
     * @param graphics  the graphics object to use for rendering
     * @param cellSize  the size of the cells, in pixels
     */
    public GameBoardGridLinesPainter(GameBoard gameBoard, Graphics2D graphics, int cellSize) {
        super(graphics, cellSize, new CellArea(0, 0, gameBoard.getBoardSize().getWidth(), gameBoard.getBoardSize().getHeight()));
        this.gameBoard = gameBoard;
    }

    /**
     * Ensures that "major" or "minor" gridlines are drawn in appropriate cases.
     */
    @Override
    protected GameLineStyles getLineColor(int lineNumber, boolean isRowLine) {
        // TODO Don't always return this - sometimes we want MajorGridLines, other times we want MinorGridLines.
        return GameLineStyles.MajorGridLine;
    }
}
