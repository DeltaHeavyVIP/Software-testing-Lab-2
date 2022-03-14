package log;

import lab_2.log.Ln;
import lab_2.log.Log10;
import lab_2.log.Log3;
import lab_2.log.Log5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Log calculator")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestLog {
    private final Ln ln;
    private final Log3 log3;
    private final Log5 log5;
    private final Log10 log10;

    private final double accuracy = 0.1;

    public TestLog() {
        this.ln = new Ln();
        this.log3 = new Log3(ln);
        this.log5 = new Log5(ln);
        this.log10 = new Log10(ln);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/lnData.csv")
    @DisplayName("ln(x) test")
    void lnTest(Double x, Double trueResult) {
        double result = ln.calculate(x);
        assertEquals(trueResult, result, accuracy);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/log3Data.csv")
    @DisplayName("log3(x) test")
    void log3Test(Double x, Double trueResult) {
        double result = log3.calculate(x);
        assertEquals(trueResult, result, accuracy);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/log5Data.csv")
    @DisplayName("log5(x) test")
    void log5Test(Double x, Double trueResult) {
        double result = log5.calculate(x);
        assertEquals(trueResult, result, accuracy);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/log10Data.csv")
    @DisplayName("log10(x) test")
    void log10Test(Double x, Double trueResult) {
        double result = log10.calculate(x);
        assertEquals(trueResult, result, accuracy);
    }

}
