package ictgradschool.industry.tetdoku.model;

import java.util.Objects;

public class CellDimension {

    private final int width, height;

    public CellDimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellDimension that = (CellDimension) o;
        return width == that.width &&
                height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
