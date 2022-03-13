package lab_2.trig;

import lab_2.AbstractFunction;

import static java.lang.Double.*;
import static java.lang.Math.*;

public class Sin extends AbstractFunction {

    public Sin(Double e) {
        super(e);
    }

    @Override
    public Double calculate(Double x) {
        x = checkX(x);

        if (x == 0 || x == -PI) {
            return 0.0;
        }

        int n = 0;
        double resultSin = 0;
        while (abs((pow(-1, n - 1) / getFactorial(2 * n - 1)) * pow(x, 2 * n - 1)) > getE()) {
            resultSin += (pow(-1, n - 1) / getFactorial(2 * n - 1)) * pow(x, 2 * n - 1);
            n++;
        }
        return resultSin;
    }
}
