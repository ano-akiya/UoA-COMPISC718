package ictgradschool.industry.tetdoku.view.gameboard;

import ictgradschool.industry.tetdoku.model.*;
import ictgradschool.industry.tetdoku.model.gameboard.GameBoard;
import ictgradschool.industry.tetdoku.model.shapes.SingleCellShape;
import ictgradschool.industry.tetdoku.model.shapes.TetdokuShape;
import ictgradschool.industry.tetdoku.view.colorscheme.GameColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This is a Swing panel that renders a {@link GameBoard}. It also can render a {@link TetdokuShape} on top, and color it
 * according to whether the shape will fit on the board at the current mouse position or not.
 * <p>
 * Clicking the grid will cause the shape to be placed on the board, if possible.
 */
public class GameBoardPanel extends JPanel {

    /**
     * We will always have at least this many pixels between the edge of this panel and the gameboard visuals.
     */
    private static final int BORDER_SIZE = 10;

    /**
     * When the app first loads, how large should each cell in the gameboard appear? (the user can resize the screen
     * to change this to their liking later).
     */
    private static final int PREFERRED_CELL_SIZE = 64;

    /**
     * The game itself that's currently being played and rendered in this component
     */
    private final GameBoard gameBoard;

    /**
     * The shape we're currently trying to place on the gameboard, if any.
     */
    private TetdokuShape shapeToPlace;

    /**
     * Creates a new GameBoardView.
     */
    public GameBoardPanel() {

        this.gameBoard = new GameBoard();

        this.shapeToPlace = new SingleCellShape();

        this.addMouseListener(mouseListener);

        this.setBackground(GameColors.PanelColor.getColor());

        this.setMinimumSize(new Dimension(
                PREFERRED_CELL_SIZE * gameBoard.getBoardSize().getWidth() / 2,
                PREFERRED_CELL_SIZE * gameBoard.getBoardSize().getHeight() / 2));

        this.setPreferredSize(new Dimension(
                PREFERRED_CELL_SIZE * gameBoard.getBoardSize().getWidth(),
                PREFERRED_CELL_SIZE * gameBoard.getBoardSize().getHeight()));

        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    /**
     * When this component draws itself, it will draw all cells on the gameboard, with lines between them.
     *
     * @param g the graphics object to use to perform rendering.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Create a copy of the graphics object which we'll use here, so we can mess with its properties (such as
        // Colors) without worrying about messing up the rendering of any other components.
        Graphics2D graphics = (Graphics2D) g.create();

        // Calculate cell size, offsets, etc.
        final int cellSize = getMaxCellSize();
        final int gameBoardWidth = cellSize * gameBoard.getBoardSize().getWidth();
        final int gameBoardHeight = cellSize * gameBoard.getBoardSize().getHeight();
        final int xOffs = (getWidth() - gameBoardWidth) / 2;
        final int yOffs = (getHeight() - gameBoardHeight) / 2;

        // Make sure we're drawing at the right location
        graphics.translate(xOffs, yOffs);

        // Draw the gameboard's cells
        GameBoardCellPainter cellPainter = new GameBoardCellPainter(this.gameBoard, graphics, cellSize);
        cellPainter.paint();

        // TODO Draw the current shape at the user's current mouse location, if any

        // Draw the gameboard's gridlines
        GameBoardGridLinesPainter linesPainter = new GameBoardGridLinesPainter(this.gameBoard, graphics, cellSize);
        linesPainter.paint();
    }

    /**
     * Gets the maximum size of the cells which we can draw. We want the game board to be as large as possible on the
     * user's screen, while fitting entirely within this component.
     *
     * @return the max allowed cell size in pixels, given this component's current width and height.
     */
    private int getMaxCellSize() {

        int width = getWidth() - 2 * BORDER_SIZE;
        int height = getHeight() - 2 * BORDER_SIZE;

        int maxCellSizeX = width / gameBoard.getBoardSize().getWidth();
        int maxCellSizeY = height / gameBoard.getBoardSize().getHeight();

        return Math.min(maxCellSizeX, maxCellSizeY);

    }

    /**
     * Converts the given pixel coordinates (e.g. from the mouse X, Y position) into cell coordinates (e.g. which
     * game board cell the mouse is currently hovering over). Returns null if the given coordinates don't correspond
     * to any game board cell.
     *
     * @param pixelCoordinates the pixel coordinates to check, relative to the top-left of this component.
     * @return the cell coordinates corresponding to the given pixel coordinates, or null if there are no matching cells
     */
    private CellCoordinate getCellCoordinates(Point pixelCoordinates) {

        int cellSize = getMaxCellSize();

        // We can't possibly be referring to a cell if the cell size is too small.
        if (cellSize <= 0) {
            return null;
        }

        final int gameBoardWidth = cellSize * gameBoard.getBoardSize().getWidth();
        final int gameBoardHeight = cellSize * gameBoard.getBoardSize().getHeight();
        final int xOffs = (getWidth() - gameBoardWidth) / 2;
        final int yOffs = (getHeight() - gameBoardHeight) / 2;

        // Get outta here if the given coordinates are too small
        if (pixelCoordinates.x - xOffs < 0 || pixelCoordinates.y - yOffs < 0) {
            return null;
        }

        int cellX = (pixelCoordinates.x - xOffs) / cellSize;
        int cellY = (pixelCoordinates.y - yOffs) / cellSize;

        // Get outta here if the given coordinates are too large
        if (cellX >= gameBoard.getBoardSize().getWidth() || cellY >= gameBoard.getBoardSize().getHeight()) {
            return null;
        }

        return new CellCoordinate(cellX, cellY);
    }

    /**
     * Gets the cell coordinates where the current shape should be placed, given the current mouse cell coords.
     *
     * @param currentMouseCoords the current mouse cell coords
     * @return the current shape cell coords, or null if there are no mouse coords or no shape to place
     */
    private CellCoordinate getCurrentShapeCoords(CellCoordinate currentMouseCoords) {

        if (currentMouseCoords == null || this.shapeToPlace == null) {
            return null;
        }

        CellDimension size = this.shapeToPlace.getSize();
        return new CellCoordinate(
                currentMouseCoords.getCol() - size.getWidth() / 2,
                currentMouseCoords.getRow() - size.getHeight() / 2);
    }

    /**
     * A {@link MouseListener} lets us respond to mouse clicks, amongst other things.
     * <p>
     * Whenever the mouse is clicked on this component, we'll check if we have a shape to place.
     * If we do, then we'll check whether we can place that shape on the gameboard at the location that's currently
     * being pointed to by the user's mouse. If it can, we'll place it on the gameboard there.
     */
    private final MouseListener mouseListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            // If we have a shape to place...
            if (shapeToPlace != null) {

                // Get the gameboard cell the user is pointing to with the mouse
                CellCoordinate mouseCellCoordinates = getCellCoordinates(e.getPoint());

                // If they are pointing somewhere...
                if (mouseCellCoordinates != null) {

                    // Get the location the shape should be placed
                    CellCoordinate shapeCoordinates = getCurrentShapeCoords(mouseCellCoordinates);

                    // If the shape can be placed there, place it.
                    if (gameBoard.shapeFits(shapeToPlace, shapeCoordinates)) {
                        gameBoard.placeShape(shapeToPlace, shapeCoordinates);

                        // TODO Add some more code here...

                    }
                }
            }
        }
    };



}
