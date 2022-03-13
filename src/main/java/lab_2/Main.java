package lab_2;

import lab_2.log.*;
import lab_2.trig.*;

import static java.lang.Math.PI;

public class Main {
    public static void main(String[] args) {
        var sin = new Sin();
        var cos = new Cos();
        var tan = new Tan();
        var cot = new Cot();
        var sec = new Sec();
        var csc = new Csc();
        var trigCalculator = new TrigCalculator(sin, cos, tan, cot, sec, csc);

        var ln = new Ln();
        var log3 = new Log3(ln);
        var log5 = new Log5(ln);
        var log10 = new Log10(ln);
        var logCalculator = new LogCalculator(ln, log3, log5, log10);

        var calculator = new Calculator(logCalculator, trigCalculator);

        double x = -PI / 4;

        System.out.println(calculator.calculate(x));
    }
}
