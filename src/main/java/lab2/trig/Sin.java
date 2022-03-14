package lab2.trig;

import static java.lang.Math.*;

public class Sin extends TrigFunction {

    @Override
    public Double calculate(Double x) {
        x = checkX(x);

        if (x == 0 || x == -PI) {
            return 0.0;
        }

        int n = 1;
        double resultSin = 0;
        while (Math.abs((Math.pow(-1, n - 1) / getFactorial(2 * n - 1)) * Math.pow(x, 2 * n - 1)) > 0.001) {
            resultSin += (Math.pow(-1, n - 1) / getFactorial(2 * n - 1)) * Math.pow(x, 2 * n - 1);
            n++;
        }
        return resultSin;
    }
}
