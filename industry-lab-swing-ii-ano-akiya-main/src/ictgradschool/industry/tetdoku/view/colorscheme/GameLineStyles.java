package ictgradschool.industry.tetdoku.view.colorscheme;

import java.awt.*;

/**
 * Represents a styled line. I have put them here in this enum so we can see and modify all the colors at once.
 */
public enum GameLineStyles {

    /**
     * "minor" gameboard gridlines will have this color and style
     */
    MinorGridLine(GameColors.LightLineColor.getColor(), LineStyle.Dashed.getStroke()),

    /**
     * "major" gameboard gridlines will have this color and style
     */
    MajorGridLine(GameColors.DarkLineColor.getColor(), LineStyle.Solid.getStroke()),

    /**
     * component borders will have this color and style
     */
    BorderLine(GameColors.BorderColor.getColor(), LineStyle.Solid.getStroke());

    private final Color color;
    private final Stroke stroke;

    GameLineStyles(Color color, Stroke stroke) {
        this.color = color;
        this.stroke = stroke;
    }

    public Color getColor() {
        return color;
    }

    public Stroke getStroke() {
        return stroke;
    }
}
