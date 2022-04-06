package function;

public class PowerSeriesForSinFunction {
    private final static double ACCURACY = 0.001;

    public static double sin(double x) {
        if (Double.isInfinite(x))
            return Double.NaN;
        int n = 0;
        double absX = Math.abs(x);
        double cur = 0;
        double prev = -1;
        double res = 0;
        while (Math.abs(cur - prev) >= ACCURACY) {
            prev = cur;
           try {
               cur = expandIntoTaylorSeries(absX, n);
           } catch (FactorialException ex) {
               return Double.NaN;
           }
            res += cur;
            ++n;
        }
        return x < 0? -res : res;
    }
    private static double expandIntoTaylorSeries(double x, int n) throws FactorialException {
        return Math.pow(-1,n) * Math.pow(x,2*n + 1) / calculateFactorial(2*n + 1);
    }

    public static long calculateFactorial(int n) throws FactorialException {
        if (n > 20) {
            throw new FactorialException("Невозможно посчитать факториал");
        }
        if (n == 0) {
            return 1;
        }
        else {
            return n * calculateFactorial(n - 1);
        }
    }

}