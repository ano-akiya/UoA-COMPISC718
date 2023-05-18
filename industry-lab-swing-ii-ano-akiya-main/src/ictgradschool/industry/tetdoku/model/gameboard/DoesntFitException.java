package ictgradschool.industry.tetdoku.model.gameboard;

/**
 * Intended to be thrown if a shape tries to be added to a gameboard at a location where it doesn't fit.
 *
 * @author Andrew Meads
 */
public class DoesntFitException extends RuntimeException {

    public DoesntFitException(String message) {
        super(message);
    }
}
