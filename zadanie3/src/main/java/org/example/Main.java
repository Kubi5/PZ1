package org.example;


import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        //fromCSVtoXML fromCSVtoXML = new fromCSVtoXML();
        //fromCSVtoXML.readingData();
        fromXLSXtoXML fromXLSXtoXML = new fromXLSXtoXML();
        fromXLSXtoXML.readingData();
    }
}
