package org.example;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        if(args[0].contains(".csv")) {
            fromCSVtoXML fromCSVtoXML = new fromCSVtoXML(args[0], args[1]);
            fromCSVtoXML.readingData();
        }
        else if(args[0].contains(".xlsx")) {
            fromXLSXtoXML fromXLSXtoXML = new fromXLSXtoXML(args[0],args[1]);
            fromXLSXtoXML.readingData();
        }
        else {
            System.out.println("Wrong file format! Provide .csv or .xlsx file.");
        }
    }
}
