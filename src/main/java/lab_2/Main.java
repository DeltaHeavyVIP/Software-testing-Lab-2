package lab_2;

import lab_2.trig.*;

import static java.lang.Math.PI;

public class Main {
    public static void main(String [] args){
        double x = -PI/4;
        var sin = new Sin();
        var cos = new Cos();
        var tan = new Tan();
        var cot = new Cot();
        var sec = new Sec();
        var csc = new Csc();
        var calculator = new Calculator(sin, cos, tan, cot, sec, csc);
        System.out.println(calculator.calculate(x));
    }
}
