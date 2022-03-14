package lab_2.utils;

import lab_2.AbstractFunction;
import lombok.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

@Data
public class CsvLogger {
    private final String defaultFilePath = "src/test/resources/results/";
    private String filePath = "";
    private double step;
    private double lowerBorder;
    private double upperBorder;

    public CsvLogger(String fileName, double lowerBorder, double upperBorder, double step) {
        this.filePath = defaultFilePath + fileName;
        this.lowerBorder = lowerBorder;
        this.upperBorder = upperBorder;
        this.step = step;
    }

    public void setFilePath(String fileName) {
        this.filePath = defaultFilePath + fileName;
    }

    public void logger(AbstractFunction function) {
        try (PrintWriter writer = new PrintWriter(new File(filePath))) {
            for (double i = lowerBorder; i <= upperBorder; i += step) {
                try {
                    double result = function.calculate(i);
                    writer.write(String.format("%s, %s \n", i, result));
                } catch (ArithmeticException e) {
                    writer.write(String.format("%s, %s \n", i, e.getMessage()));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
