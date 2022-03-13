package lab_2.trig;

import lab_2.AbstractFunction;

import static java.lang.Double.*;
import static java.lang.Math.PI;

public abstract class TrigFunction extends AbstractFunction {
    @Override
    public Double checkX(double x) {
        x = super.checkX(x);
        if (x > 0) {
            throw new ArithmeticException("Х должен быть <=0");
        }
        return x % (2 * PI);
    }
        public Double calculate(Double x) {
            double sinResult = new Sin(getE()).calculate(x);
            double cosResult = new Cos(getE()).calculate(x);
            double tanResult = new Tan(getE()).calculate(x);
            double cotResult = new Cot(getE()).calculate(x);
            double secResult = new Sec(getE()).calculate(x);
            double cscResult = new Csc(getE()).calculate(x);

            return Math.pow((((((((((Math.pow((cosResult - tanResult), 2) * tanResult) / Math.pow(cosResult, 2)) / ((tanResult + cotResult) + Math.pow(tanResult, 2))) / Math.pow(secResult, 2)) - (cscResult - secResult)) - sinResult) + (tanResult + (cotResult * cosResult))) - ((sinResult - (secResult * ((cscResult + (sinResult + cosResult)) + sinResult))) + ((cscResult + tanResult) - secResult))) - ((secResult * Math.pow((secResult - ((sinResult - sinResult) + cotResult)), 3)) / (Math.pow(cscResult, 2) + sinResult))), 2);
        }

    public Double checkX(Double x) {
        if (isNaN(x) || isInfinite(x)) {
            return NaN;
        }
        if (x > 0) {
            throw new ArithmeticException("Х должен быть <=0");
        }
        return x % (2 * PI);
    }
}
