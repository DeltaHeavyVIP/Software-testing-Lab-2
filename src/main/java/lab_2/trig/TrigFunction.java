package lab_2.trig;

import lab_2.AbstractFunction;

import static java.lang.Double.*;
import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class TrigFunction extends AbstractFunction {

    public TrigFunction(Double e) {
        super(e);
    }

    /*
    ((((((((((((cos(x) - tanResult(x)) ^ 2) * tanResult(x)) / (cosResult(x) ^ 2)) / ((tanResult(x) + cotResult(x)) + (tanResult(x) ^ 2))) / (secResult(x) ^ 2)) - (cscResult(x) - secResult(x))) - sinResult(x)) + (tanResult(x) + (cotResult(x) * cosResult(x)))) - ((sinResult(x) - (secResult(x) * ((cscResult(x) + (sinResult(x) + cosResult(x))) + sinResult(x)))) + ((cscResult(x) + tanResult(x)) - secResult(x)))) - ((secResult(x) * ((secResult(x) - ((sinResult(x) - sinResult(x)) + cotResult(x))) ^ 3)) / ((cscResult(x) ^ 2) + sinResult(x)))) ^ 2)
     */
    @Override
    public Double calculate(Double x) {
        double sinResult = new Sin(getE()).calculate(x);
        double cosResult = new Cos(getE()).calculate(x);
        double tanResult = new Tan(getE()).calculate(x);
        double cotResult = new Cot(getE()).calculate(x);
        double secResult = new Sec(getE()).calculate(x);
        double cscResult = new Csc(getE()).calculate(x);

        return pow((((((((((pow((cosResult - tanResult), 2) * tanResult) / pow(cosResult, 2)) / ((tanResult + cotResult) + pow(tanResult, 2))) / pow(secResult, 2)) - (cscResult - secResult)) - sinResult) + (tanResult + (cotResult * cosResult))) - ((sinResult - (secResult * ((cscResult + (sinResult + cosResult)) + sinResult))) + ((cscResult + tanResult) - secResult))) - ((secResult * pow((secResult - ((sinResult - sinResult) + cotResult)), 3)) / (pow(cscResult, 2) + sinResult))), 2);
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
