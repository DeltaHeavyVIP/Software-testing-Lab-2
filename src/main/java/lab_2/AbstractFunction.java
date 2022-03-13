package lab_2;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public abstract class AbstractFunction {

    private Map<Double, Double> mocks = new HashMap<>();
    private Double e;

    public AbstractFunction(Double e) {
        this.e = e;
    }

    public abstract Double calculate(Double x);

    public abstract Double checkX(Double x) ;
}
