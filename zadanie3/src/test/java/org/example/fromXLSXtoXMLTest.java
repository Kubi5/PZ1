package org.example;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import javax.xml.bind.JAXBException;

import static org.junit.Assert.*;

import java.io.*;
/** This class tests parsing from XLSX to XML */
public class fromXLSXtoXMLTest {
    FileInputStream file = new FileInputStream("C:\\Users\\FiFi\\PZ1\\zadanie3\\faktury-sprzedazowe-test.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(file);
    XSSFSheet sheet = workbook.getSheetAt(0);

    public fromXLSXtoXMLTest() throws IOException {
    }
    
        @Test
        public void isReadingfromXLSXvalid() throws IOException, JAXBException {
        fromXLSXtoXML fromXLSXtoXML = new fromXLSXtoXML("faktury-sprzedazowe-test.xlsx", "ugabuga.xml");
        fromXLSXtoXML.readingData();
            assertEquals("Firma5 SP. Z O.O.",fromXLSXtoXML.zbiorFaktur.getLista().get(0).getNazwaOdbiorcy());
            assertEquals("UL. FELIKSA RADWAĹ\u0083SKIEGO 15/1, 30-065 KRAKĂ“W",fromXLSXtoXML.zbiorFaktur.getLista().get(0).getAdresOdbiorcy());
            assertEquals("634-27-26-447",fromXLSXtoXML.zbiorFaktur.getLista().get(0).getNIPOdbiorcy());
            assertEquals("2020-10-09",fromXLSXtoXML.zbiorFaktur.getLista().get(0).getDataWystawienia());
            assertEquals("2020-10-09",fromXLSXtoXML.zbiorFaktur.getLista().get(0).getDataSprzedazy());
            assertEquals("3-09/10/2020",fromXLSXtoXML.zbiorFaktur.getLista().get(0).getNrFaktury());
            assertEquals("Czynsz z tytuĹ‚u najmu powierzchni w budynku przy ul. RadwaĹ„skiego 15 w Krakowie za PaĹşdziernik 2020",fromXLSXtoXML.zbiorFaktur.getLista().get(0).getTytulPozycji());
            assertEquals("1.0",fromXLSXtoXML.zbiorFaktur.getLista().get(0).getLiczbaSztuk());
            assertEquals("3Â 000,00 zĹ‚",fromXLSXtoXML.zbiorFaktur.getLista().get(0).getCenaJednostkowa());
            assertEquals("23.0",fromXLSXtoXML.zbiorFaktur.getLista().get(0).getStawkaPodatku());
            assertEquals("690,00 zĹ‚",fromXLSXtoXML.zbiorFaktur.getLista().get(0).getKwotaPodatku());
            assertEquals("3Â 000,00 zĹ‚",fromXLSXtoXML.zbiorFaktur.getLista().get(0).getCenaNettopozycji());
            assertEquals("3Â 690,00 zĹ‚",fromXLSXtoXML.zbiorFaktur.getLista().get(0).getCenaBruttopozycji());
            assertEquals("3Â 000,00 zĹ‚",fromXLSXtoXML.zbiorFaktur.getLista().get(0).getCenaNettofakturylacznie());
            assertEquals("3Â 690,00 zĹ‚",fromXLSXtoXML.zbiorFaktur.getLista().get(0).getCenaBruttofakturylacznie());
        }
}



