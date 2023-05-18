package ictgradschool.industry.concurrency.examples.example03;

/**
 * An IComputeTask which calculates the nth fibonacci number
 */
public class Fibonacci implements IComputeTask<Integer> {

    private int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    public Integer computeResult() {
        return fib(n);
    }

    /**
     * Computes the nth fibonacci number.
     *
     * As a guide, on my laptop:
     * - when n = 30 this method returns near-instantly
     * - when n = 40 this method returns in about half a second
     * - when n = 50 this method returns in just under a minute
     *
     * @param n
     * @return
     */
    private int fib(int n) {

        if (n < 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }

    }

    @Override
    public String toString() {
        return "Fibonacci(" + n + ")";
    }
}
