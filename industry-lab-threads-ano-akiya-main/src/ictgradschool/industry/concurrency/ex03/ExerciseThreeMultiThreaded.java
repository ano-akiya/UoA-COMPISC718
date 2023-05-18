package ictgradschool.industry.concurrency.ex03;

/**
 * TODO Create a multi-threaded program to calculate PI using the Monte Carlo method.
 */

import java.util.ArrayList;
import ictgradschool.Keyboard;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.ThreadLocalRandom;

public class ExerciseThreeMultiThreaded extends ExerciseThreeSingleThreaded {

    /**
     * Estimates PI using a multi-threaded Monte Carlo method.
     */
    @Override
    protected double estimatePI(long numSamples) {
        // TODO Implement this.
        int numThreads = 10;
        long numSamplesPerThread = numSamples / numThreads;
        Thread[] threads = new Thread[numThreads];
        ArrayList<Long> counter = new ArrayList<>();
        for (int i = 0; i < numThreads; i++)
        {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    ThreadLocalRandom tlr = ThreadLocalRandom.current();
                    long numInsideCircle = 0;
                    for (long j = 0; j < numSamplesPerThread; j++) {
                        double x = tlr.nextDouble();
                        double y = tlr.nextDouble();
                        if (Math.pow(x, 2.0) + Math.pow(y, 2.0) < 1.0) {
                            numInsideCircle++;
                        }
                    }
                    counter.add(numInsideCircle);
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            }
            catch(InterruptedException e)
            {
                System.out.println("InterruptedException");
            }
        }

        long numInsideCircle = 0;
        for (int i = 0; i < counter.size(); i++) {
            numInsideCircle += counter.get(i);
        }
        double estimatedPi = 4.0 * (double) numInsideCircle / (double) numSamples;
        return estimatedPi;
    }

    /** Program entry point. */
    public static void main(String[] args) {
        new ExerciseThreeMultiThreaded().start();
    }
}
