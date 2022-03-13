package lab_2;

import lab_2.log.LogCalculator;
import lab_2.trig.TrigCalculator;

public class Calculator {
    private final LogCalculator logCalculator;
    private final TrigCalculator trigCalculator;

    public Calculator(LogCalculator logCalculator, TrigCalculator trigCalculator) {
        this.logCalculator = logCalculator;
        this.trigCalculator = trigCalculator;
    }

    public Double calculate(Double x) {
        if (x > 0) {
            return logCalculator.calculate(x);
        } else {
            return trigCalculator.calculate(x);
        }
    }
}
