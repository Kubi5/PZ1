package org.example;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/** Main class:) */
public class Main {
    private static final Logger LOGGER = Logger.getLogger( Main.class.getName() );
/** Main method which takes an output and decide which format will be parsed to xml */
    public static void main(String[] args) throws JAXBException, IOException {
        if(args[0].contains(".csv")) {
            fromCSVtoXML fromCSVtoXML = new fromCSVtoXML(args[0], args[1]);
            fromCSVtoXML.readingData();
        }
        else if(args[0].contains(".xlsx")){
            fromXLSXtoXML fromXLSXtoXML = new fromXLSXtoXML(args[0],args[1]);
            fromXLSXtoXML.readingData();
        }
        else {
            LOGGER.log(Level.INFO, "Wrong file format! Provide .csv or .xlsx file.");
        }
    }
}
