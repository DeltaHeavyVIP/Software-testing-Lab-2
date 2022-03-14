package trig;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lab_2.AbstractFunction;
import lab_2.trig.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TrigStubsTest {

    public static Sin sin = mock(Sin.class);
    public static Cos cos = mock(Cos.class);
    public static Tan tan = mock(Tan.class);
    public static Cot cot = mock(Cot.class);
    public static Sec sec = mock(Sec.class);
    public static Csc csc = mock(Csc.class);
    public static TrigCalculator trigCalculator = mock(TrigCalculator.class);

    private final double accuracy = 0.1;

    @BeforeAll
    public static void setup() throws IOException, CsvException {
        fillMock(sin, "src/test/resources/inputTrig/sinData.csv");
        fillMock(cos, "src/test/resources/inputTrig/cosData.csv");
        fillMock(tan, "src/test/resources/inputTrig/tanData.csv");
        fillMock(cot, "src/test/resources/inputTrig/cotData.csv");
        fillMock(sec, "src/test/resources/inputTrig/secData.csv");
        fillMock(csc, "src/test/resources/inputTrig/cscData.csv");
        fillMock(trigCalculator, "src/test/resources/inputTrig/funcData.csv");
    }

    private static void fillMock(AbstractFunction tf, String tableName) throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader(tableName))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                final double x = Double.parseDouble(record[0]);
                final double y = Double.parseDouble(record[1]);
                when(tf.calculate(x)).thenReturn(y);
            }
        } catch (IOException | CsvException exp) {
            throw exp;
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/cosData.csv")
    @DisplayName("cos(x) test")
    void cosTest(Double divisible, Double divider, Double trueResult) {
        try {
            double x = divisible * PI / divider;
            double result = cos.calculate(x);
            assertEquals(trueResult, result, accuracy);
        } catch (ArithmeticException e) {
            assertEquals("Х should be <=0", e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/tanData.csv")
    @DisplayName("tan(x) test")
    void tanTest(Double divisible, Double divider, Double trueResult) {
        try {
            double x = divisible * PI / divider;
            double result = tan.calculate(x);
            assertEquals(trueResult, result, accuracy);
        } catch (ArithmeticException e) {
            assertEquals("Х should be <=0", e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/cotData.csv")
    @DisplayName("cot(x) test")
    void cotTest(Double divisible, Double divider, Double trueResult) {
        try {
            double x = divisible * PI / divider;
            double result = cot.calculate(x);
            assertEquals(trueResult, result, accuracy);
        } catch (ArithmeticException e) {
            assertEquals("Х should be <=0", e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/secData.csv")
    @DisplayName("sec(x) test")
    void secTest(Double divisible, Double divider, Double trueResult) {
        try {
            double x = divisible * PI / divider;
            double result = sec.calculate(x);
            assertEquals(trueResult, result, accuracy);
        } catch (ArithmeticException e) {
            assertEquals("Х should be <=0", e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/cscData.csv")
    @DisplayName("csc(x) test")
    void cscTest(Double divisible, Double divider, Double trueResult) {
        try {
            double x = divisible * PI / divider;
            double result = csc.calculate(x);
            assertEquals(trueResult, result, accuracy);
        } catch (ArithmeticException e) {
            assertEquals("Х should be <=0", e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputTrig/funcData.csv")
    @DisplayName("func(x) test")
    void funcTest(Double divisible, Double divider, Double trueResult) {
        try {
            double x = divisible * PI / divider;
            double result = trigCalculator.calculate(x);
            assertEquals(trueResult, result, accuracy);
        } catch (ArithmeticException e) {
            assertEquals("Х should be <=0", e.getMessage());
        }
    }
}
