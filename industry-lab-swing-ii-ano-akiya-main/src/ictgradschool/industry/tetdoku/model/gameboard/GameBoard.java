package ictgradschool.industry.tetdoku.model.gameboard;

import ictgradschool.industry.tetdoku.model.CellArea;
import ictgradschool.industry.tetdoku.model.CellCoordinate;
import ictgradschool.industry.tetdoku.model.CellDimension;
import ictgradschool.industry.tetdoku.model.shapes.TetdokuShape;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a game board for this game, of a configurable size.
 * <p>
 * The default size is a 9x9 grid, with "squares" of size 3 - i.e. the same as a standard Sudoku board.
 */
public class GameBoard {

    /**
     * The default board size
     */
    private static final CellDimension DEFAULT_BOARD_SIZE = new CellDimension(9, 9);

    /**
     * The default square size
     */
    private static final int DEFAULT_SQUARE_SIZE = 3;

    /**
     * The board state
     */
    private final CellState[][] board;

    /**
     * The size of the board
     */
    private final CellDimension boardSize;

    /**
     * The size of each square in the board
     */
    private final int squareSize;

    /**
     * Creates a new game board with the default size
     */
    public GameBoard() {
        this(DEFAULT_BOARD_SIZE, DEFAULT_SQUARE_SIZE);
    }

    /**
     * Creates a new game board with the given size
     *
     * @param boardSize  the board size
     * @param squareSize the square size
     */
    public GameBoard(CellDimension boardSize, int squareSize) {
        this.boardSize = boardSize;
        this.squareSize = squareSize;
        this.board = new CellState[boardSize.getWidth()][boardSize.getHeight()];

        this.clearBoard();
    }

    /**
     * Clears the board (i.e. sets all cells on the board to {@link CellState#Empty}), and notifies listeners.
     */
    public void clearBoard() {
        clearBoard(new CellArea(0, 0, getBoardSize().getWidth(), getBoardSize().getHeight()));
    }

    /**
     * Clears all cells within the given bounds, and notifies listeners.
     *
     * @param bounds the cells to clear
     */
    private void clearBoard(CellArea bounds) {
        setCellStates(bounds, CellState.Empty);
    }

    /**
     * Sets the state of all cells within the given bounds to the given state, then notifies listeners.
     *
     * @param bounds the cells whose state to set
     * @param state  the state to set
     */
    private void setCellStates(CellArea bounds, CellState state) {
        for (int col = bounds.getX(); col < bounds.getX() + bounds.getWidth(); col++) {
            for (int row = bounds.getY(); row < bounds.getY() + bounds.getHeight(); row++) {
                this.board[col][row] = state;
            }
        }
    }

    /**
     * Gets the size of the board, in cells
     */
    public CellDimension getBoardSize() {
        return this.boardSize;
    }

    /**
     * Gets the state of the cell at the given point
     *
     * @param point the point to check
     */
    public CellState getCellState(CellCoordinate point) {
        return this.board[point.getCol()][point.getRow()];
    }

    /**
     * Gets the size of the "squares" on this board, in cells. Points are scored if a row, column, or square is filled.
     */
    public int getSquareSize() {
        return squareSize;
    }

    /**
     * Returns a value indicating whether the given shape "fits" (i.e. is able to be placed) on the gameboard at the
     * given location.
     *
     * @param shape  the shape to check
     * @param origin the origin coordinate which should be checked
     * @return true if the shape fits, false otherwise
     */
    public boolean shapeFits(TetdokuShape shape, CellCoordinate origin) {

        CellDimension shapeSize = shape.getSize();

        // Loop through all cells in the shape...
        for (int col = 0; col < shapeSize.getWidth(); col++) {
            for (int row = 0; row < shapeSize.getHeight(); row++) {

                // Figure out if the shape itself is filled at this point. If it is..
                if (shape.isFilled(new CellCoordinate(col, row))) {

                    // col, row in the for-loops are in the shape's coordinate space. Let's work out what the corresponding
                    // point is in the gameboard's coordinate space (using the supplied origin).
                    CellCoordinate gameCoord = new CellCoordinate(origin.getCol() + col, origin.getRow() + row);

                    // Is that gameCoord even on the gameboard at all? If not, then the shape definitely won't fit.
                    if (gameCoord.getCol() < 0 || gameCoord.getCol() >= this.getBoardSize().getWidth() ||
                            gameCoord.getRow() < 0 || gameCoord.getRow() >= this.getBoardSize().getHeight()) {

                        return false;
                    }

                    // Is that gameCoord filled? If so, then the shape won't fit either.
                    if (this.board[gameCoord.getCol()][gameCoord.getRow()] == CellState.Filled) {

                        return false;
                    }


                }
            }
        }

        // If we get here, then none of the points within the shape collide with any filled or out-of-bounds portions
        // of the gameboard, so the shape will fit.
        return true;
    }

    /**
     * Places the given shape at the given location on the board, notifies listeners, and then checks for filled
     * rows / columns / squares.
     *
     * @param shape  the shape to place
     * @param origin the location where the shape should be placed
     * @throws DoesntFitException if the shape can't be placed at the given location
     */
    public void placeShape(TetdokuShape shape, CellCoordinate origin) throws DoesntFitException {

        if (!shapeFits(shape, origin)) {
            throw new DoesntFitException("Shape doesn't fit!");
        }

        // Set all cells in the gameboard corresponding to this shape to "filled".
        CellDimension shapeSize = shape.getSize();

        // Loop through all cells in the shape...
        for (int col = 0; col < shapeSize.getWidth(); col++) {
            for (int row = 0; row < shapeSize.getHeight(); row++) {

                // If the shape is filled at that point...
                if (shape.isFilled(new CellCoordinate(col, row))) {

                    // Fill the corresponding gameboard cell
                    CellCoordinate gameCoord = new CellCoordinate(origin.getCol() + col, origin.getRow() + row);
                    this.board[gameCoord.getCol()][gameCoord.getRow()] = CellState.Filled;
                }

            }
        }

        // Once we've placed a shape, remove any areas that have been filled.
        clearFilledAreas();

    }

    /**
     * Checks for and clears any filled areas (rows, columns, squares). Notifies listeners of any that were cleared.
     */
    private void clearFilledAreas() {

        List<CellArea> filledAreas = getFilledAreas();

        // TODO Go through and clear everything that needs clearing.
        // HINT: the existing clearBoard() method might help here...
    }

    /**
     * Gets all filled areas on the board (rows, columns, squares).
     *
     * @return a List containing the filled areas
     */
    private List<CellArea> getFilledAreas() {

        List<CellArea> areas = getAreas();

        Iterator<CellArea> iter = areas.iterator();
        while (iter.hasNext()) {
            if (!isAreaFilled(iter.next())) {
                iter.remove();
            }
        }

        return areas;
    }

    /**
     * Gets all areas on the board (rows, columns, squares).
     *
     * @return a List containing all areas
     */
    private List<CellArea> getAreas() {
        List<CellArea> areas = new ArrayList<>();

        // Rows
        for (int row = 0; row < getBoardSize().getHeight(); row++) {
            areas.add(new CellArea(0, row, getBoardSize().getWidth(), 1));
        }

        // Cols
        for (int col = 0; col < getBoardSize().getWidth(); col++) {
            areas.add(new CellArea(col, 0, 1, getBoardSize().getHeight()));
        }

        // Squares
        for (int col = 0; col < getBoardSize().getWidth(); col += this.squareSize) {
            for (int row = 0; row < getBoardSize().getHeight(); row += this.squareSize) {
                areas.add(new CellArea(col, row, this.squareSize, this.squareSize));
            }
        }

        return areas;
    }

    /**
     * Returns a value indicating whether the given area is entirely filled on the gameboard.
     *
     * @param area the area to check
     * @return true if the area is entirely filled, false otherwise
     */
    private boolean isAreaFilled(CellArea area) {
        for (int col = area.getX(); col < area.getX() + area.getWidth(); col++) {
            for (int row = area.getY(); row < area.getY() + area.getHeight(); row++) {
                if (getCellState(new CellCoordinate(col, row)) != CellState.Filled) {
                    return false;
                }
            }
        }
        return true;
    }
}
