package lab_2;

import lab_2.trig.Tan;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Math.PI;

public class Main {
    public static void main(String [] args){
        double x = -PI/4;
        double res = new Tan(0.1).calculate(x);
        System.out.println(res);
    }
}
