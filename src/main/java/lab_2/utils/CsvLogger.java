package lab_2.utils;

import com.opencsv.CSVWriter;
import lab_2.AbstractFunction;
import lombok.Data;

import java.io.*;

@Data
public class CsvLogger {
    private String filePath = "";
    private double step;
    private double lowerBorder;
    private double upperBorder;

    public void setFilePath(String fileName) {
        this.filePath = fileName;
    }

    public void logger(double x, double y) {
        try(PrintStream printStream = new PrintStream(new FileOutputStream(filePath, true))) {
             printStream.print(String.format("%s, %s \n", x,y));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
