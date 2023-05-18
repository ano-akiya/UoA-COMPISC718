package ictgradschool.industry.tetdoku.view.gameboard;

import ictgradschool.industry.tetdoku.model.CellArea;
import ictgradschool.industry.tetdoku.model.CellCoordinate;
import ictgradschool.industry.tetdoku.model.gameboard.CellState;
import ictgradschool.industry.tetdoku.model.gameboard.GameBoard;
import ictgradschool.industry.tetdoku.view.colorscheme.GameColors;
import ictgradschool.industry.tetdoku.view.painters.AbstractCellPainter;

import java.awt.*;

/**
 * Draws the cells for the gameboard. Distinguishes visually between filled and empty cells.s
 */
public class GameBoardCellPainter extends AbstractCellPainter {

    private final GameBoard gameBoard;

    public GameBoardCellPainter(GameBoard gameBoard, Graphics2D graphics, int cellSize) {
        super(graphics, cellSize, new CellArea(0, 0, gameBoard.getBoardSize().getWidth(), gameBoard.getBoardSize().getHeight()));
        this.gameBoard = gameBoard;
    }

    /**
     * Returns different colors depending on if the cell at the given location is supposed to be filled or empty.
     *
     * @param col the cell's column. Will be within the bounds supplied in the {@link #area} field.
     * @param row the cell's row. Will be within the bounds supplied in the {@link #area} field.
     * @return an appropriate color to use to draw the gameboard cell
     */
    @Override
    protected GameColors getCellColor(int col, int row) {
        if (gameBoard.getCellState(new CellCoordinate(col, row)) == CellState.Empty) {
            return GameColors.BlankCell;
        } else {
            return GameColors.FilledCell;
        }
    }
}
