package log;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lab_2.log.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LogStubsTest {

    private static final Ln ln = mock(Ln.class);
    private static final Log3 log3 = mock(Log3.class);
    private static final Log5 log5 = mock(Log5.class);
    private static final Log10 log10 = mock(Log10.class);
    public static LogCalculator logCalculator = null;

    private final double accuracy = 0.1;

    @BeforeAll
    public static void setup() throws IOException, CsvException {
        fillMock(ln, "src/test/resources/inputLog/lnData.csv");
        fillMock(log3, "src/test/resources/inputLog/log3Data.csv");
        fillMock(log5, "src/test/resources/inputLog/log5Data.csv");
        fillMock(log10, "src/test/resources/inputLog/log10Data.csv");
        logCalculator = new LogCalculator(ln, log3, log5, log10);
    }

    private static void fillMock(LogFunction tf, String tableName) throws IOException, CsvException {
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
    @CsvFileSource(resources = "/inputLog/lnData.csv")
    @DisplayName("ln(x) test")
    void lnTest(Double x, Double trueResult) {

        try {
            double result = ln.calculate(x);
            assertEquals(trueResult, result, accuracy);
        } catch (ArithmeticException e) {
            assertEquals("Х должен быть > 0", e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/log3Data.csv")
    @DisplayName("log3(x) test")
    void log3Test(Double x, Double trueResult) {
        try {
            double result = log3.calculate(x);
            assertEquals(trueResult, result, accuracy);
        } catch (ArithmeticException e) {
            assertEquals("Х должен быть > 0", e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/log5Data.csv")
    @DisplayName("log5(x) test")
    void log5Test(Double x, Double trueResult) {
        try {
            double result = log5.calculate(x);
            assertEquals(trueResult, result, accuracy);
        } catch (ArithmeticException e) {
            assertEquals("Х должен быть > 0", e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputLog/log10Data.csv")
    @DisplayName("log10(x) test")
    void log10Test(Double x, Double trueResult) {
        try {
            double result = log10.calculate(x);
            assertEquals(trueResult, result, accuracy);
        } catch (ArithmeticException e) {
            assertEquals("Х должен быть > 0", e.getMessage());
        }
    }

}
