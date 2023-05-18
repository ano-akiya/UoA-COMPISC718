package ictgradschool.industry.concurrency.examples.example03;

import java.util.ArrayList;
import java.util.List;

/**
 * An IComputeTask that calculates the prime factors of n.
 */
public class PrimeFactors implements IComputeTask<List<Long>> {

    private long n;

    public PrimeFactors(long n) {
        this.n = n;
    }

    /**
     * Computes the prime factors of n.
     *
     * Most values of n will result in this method returning very quickly. For some longer ones, try:
     * - n = 4444444444444463
     * - n = 1000000014000000049
     * - n = 9201111169755555649
     *
     * See: http://introcs.cs.princeton.edu/java/13flow/Factors.java.html
     *
     * @return
     */
    @Override
    public List<Long> computeResult() {

        List<Long> factors = new ArrayList<>();

        long n = this.n;

        // For each potential factor i.
        for (long i = 2; i*i <= n; i++) {

            // If i is a factor of N, repeatedly divide it out.
            while (n % i == 0) {
                factors.add(i);
                n = n / i;
            }
        }

        // If biggest factor occurs only once, n > 1
        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }

    @Override
    public String toString() {
        return "PrimeFactors(" + n + ")";
    }
}
