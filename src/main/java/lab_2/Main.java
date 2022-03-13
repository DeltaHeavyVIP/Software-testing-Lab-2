package lab_2;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;

public class Main {
    public static void main(String [] args){
        double result = -1.0 / 0.0;

        if (result == POSITIVE_INFINITY)
            System.out.println("POSITIVE_INFINITY");
        else if (result == NEGATIVE_INFINITY)
            System.out.println("NEGATIVE_INFINITY");
    }
}
