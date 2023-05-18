package ictgradschool.industry.tetdoku.view.colorscheme;

import java.awt.*;

/**
 * Represents different styles of line (e.g. solid, dashed...)
 */
public enum LineStyle {

    Solid(new BasicStroke()),
    Dashed(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1f, new float[]{2f, 0f, 2f}, 2f));

    private final Stroke stroke;

    LineStyle(Stroke stroke) {
        this.stroke = stroke;
    }

    public Stroke getStroke() {
        return stroke;
    }
}