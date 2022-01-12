package org.example;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class fromCSVtoXML {
    Reader in = new FileReader("C:\\Users\\FiFi\\PZ1\\zadanie3\\faktury-sprzedazowe-test.csv");
    //wczytanie pliku CSV
    Iterable<CSVRecord> records = CSVFormat.EXCEL
            .withDelimiter('\t')
            .parse(in);

    public fromCSVtoXML() throws IOException {
    }
}
