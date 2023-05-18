package ictgradschool.industry.concurrency.ex03;

import ictgradschool.Keyboard;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class estimates PI using the Monte Carlo method (see: http://www.eveandersson.com/pi/monte-carlo-circle).
 * The more samples you allow the program to have, the more accurate your estimate will be, but the longer the program
 * will take to run.
 *
 * On my laptop, I get the following results:
 * <ul>
 *     <li>With 1,000,000 samples, estimation takes around 70ms and gets a value within 0.049% of Math.PI</li>
 *     <li>With 10,000,000 samples, estimation takes around 500ms and gets a value within 0.012% of Math.PI</li>
 *     <li>With 100,000,000 samples, estimation takes around 4850ms and gets a value within 0.0028% of Math.PI</li>
 *     <li>With 1,000,000,000 samples, estimation takes around 48,030ms and gets a value within 0.001% of Math.PI</li>
 * </ul>
 *
 * Monte Carlo is known as an "embarrassingly parallel" problem, which means that it is relatively easy to write a
 * multi-threaded version of the program that is significantly faster than the single-threaded version.
 */
public class ExerciseThreeSingleThreaded {

    /**
     * Prompts the user to enter a number of samples, then calls {@link # estimatePI(int)} to do the actual estimation.
     * Then prints the result, its accuracy, and how long the estimation took.
     */
    protected void start() {

        System.out.println("Enter the number of samples to use for approximation:");
        System.out.print("> ");

        long numSamples = Long.parseLong(Keyboard.readInput());



        System.out.println("Estimating PI...");
        long startTime = System.currentTimeMillis();

        // Do the estimation
        double estimatedPi = estimatePI(numSamples);

        long endTime = System.currentTimeMillis();
        long timeInMillis = endTime - startTime;

        double difference = Math.abs(estimatedPi - Math.PI);
        double differencePercent = 100.0 * difference / Math.PI;
        NumberFormat format = new DecimalFormat("#.####");

        System.out.println("Estimate of PI: " + estimatedPi);
        System.out.println("Estimate is within " + format.format(differencePercent) + "% of Math.PI");
        System.out.println("Estimation took " + timeInMillis + " milliseconds");

    }


    /**
     * Estimates PI using a single-threaded Monte Carlo method.
     */
    protected double estimatePI (long numSamples){

        // ThreadLocalRandom is a non-thread-safe version of Random that's designed to be used on a single thread.
        // Because it lacks thread-safety (ant its associated overheads), it is noticeably faster than Math.random(),
        // even when used on a single thread.
        ThreadLocalRandom tlr = ThreadLocalRandom.current();

        long numInsideCircle = 0;

        for (long i = 0; i < numSamples; i++) {

            double x = tlr.nextDouble();
            double y = tlr.nextDouble();

            if (Math.pow(x, 2.0) + Math.pow(y, 2.0) < 1.0) {
                numInsideCircle++;
            }
        }

        double estimatedPi = 4.0 * (double) numInsideCircle / (double) numSamples;
        return  estimatedPi;
    }

    /** Program entry point. */
    public static void main(String[] args) {

        new ExerciseThreeSingleThreaded().start();

    }
}
