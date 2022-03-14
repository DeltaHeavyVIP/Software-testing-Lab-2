package lab_2.log;

import lab_2.AbstractFunction;

public abstract class LogFunction extends AbstractFunction {
    @Override
    public Double checkX(double x) {
        x = super.checkX(x);
        if (x <= 0) {
            throw new ArithmeticException("Х должен быть > 0");
        }
        return x;
    }
}
