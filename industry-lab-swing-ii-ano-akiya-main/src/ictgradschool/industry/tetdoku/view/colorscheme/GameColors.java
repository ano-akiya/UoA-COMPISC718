package ictgradschool.industry.tetdoku.view.colorscheme;

import java.awt.*;

/**
 * Represents different colors used in this game
 */
public enum GameColors {

    /**
     * Cells in the game board will look like this when they are blank.
     */
    BlankCell(new Color(136, 135, 142, 50)),

    /**
     * Cells in the game board will look like this when they are filled.
     */
    FilledCell(new Color(27, 16, 106)),

    /**
     * Cells in the game board will look like this when we are trying to fill them with a shape, and that shape is valid.
     */
    PositiveHighlight(new Color(142, 170, 109)),

    /**
     * Cells in the game board will look like this when we are trying to fill them with a shape, and that shape is invalid.
     */
    NegativeHighlight(new Color(187, 125, 120)),

    /**
     * The "major" gameboard gridlines will be this color
     */
    DarkLineColor(new Color(13, 2, 94)),

    /**
     * The "minor" gameboard gridlines will be this color
     */
    LightLineColor(new Color(94, 89, 130)),

    /**
     * The color of the different panels (e.g. gameboard, sidebar) will be this color.
     */
    PanelColor(Color.WHITE),

    /**
     * The background color of the app window itself will be this color.
     */
    BackgroundColor(new Color(150, 148, 162)),

    /**
     * The border of the gameboard view will be this color
     */
    BorderColor(new Color(13, 2, 94));

    private final Color color;

    GameColors(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
