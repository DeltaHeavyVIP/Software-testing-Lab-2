package trig;

import lab_2.trig.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Trig calculator")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class trigTests {

    private Sin sin;
    private Cos cos;
    private Tan tan;
    private Cot cot;
    private Sec sec;
    private Csc csc;
    private TrigFunction trigFunction;
    private final double accuracy = 0.1;
    private final double e = 0.01;

    @BeforeAll
    void init() {
        this.sin = new Sin(e);
        this.cos = new Cos(e);
        this.tan = new Tan(e);
        this.cot = new Cot(e);
        this.sec = new Sec(e);
        this.csc = new Csc(e);
        this.trigFunction = new TrigFunction(e);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/sinData.csv")
    @DisplayName("sin(x) test")
    void sinTest(Double divisible, Double divider, Double trueResult) {
        double x = divisible * Math.PI / divider;
        double result = sin.calculate(x);
        assertEquals(trueResult, result, accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/cosData.csv")
    @DisplayName("cos(x) test")
    void cosTest(Double divisible, Double divider, Double trueResult) {
        double x = divisible * Math.PI / divider;
        double result = cos.calculate(x);
        assertEquals(trueResult, result, accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/tanData.csv")
    @DisplayName("tan(x) test")
    void tanTest(Double divisible, Double divider, Double trueResult) {
        double x = divisible * Math.PI / divider;
        double result = tan.calculate(x);
        assertEquals(trueResult, result, accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/cotData.csv")
    @DisplayName("cot(x) test")
    void cotTest(Double divisible, Double divider, Double trueResult) {
        double x = divisible * Math.PI / divider;
        double result = cot.calculate(x);
        assertEquals(trueResult, result, accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/secData.csv")
    @DisplayName("sec(x) test")
    void secTest(Double divisible, Double divider, Double trueResult) {
        double x = divisible * Math.PI / divider;
        double result = sec.calculate(x);
        assertEquals(trueResult, result, accuracy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/cscData.csv")
    @DisplayName("csc(x) test")
    void cscTest(Double divisible, Double divider, Double trueResult) {
        double x = divisible * Math.PI / divider;
        double result = csc.calculate(x);
        assertEquals(trueResult, result, accuracy);
    }

}
