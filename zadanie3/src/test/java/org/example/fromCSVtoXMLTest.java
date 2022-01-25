package org.example;

import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;

import static org.junit.Assert.*;
import java.io.IOException;

/** This class tests parsing from CSV to XML */
public class fromCSVtoXMLTest {
    fromCSVtoXML fromCSVtoXML;
    public fromCSVtoXMLTest() throws IOException {
    }
    @Before
    public void setUp() throws IOException, JAXBException {
        fromCSVtoXML = new fromCSVtoXML("faktury-sprzedazowe-test.csv", "Ugabuga.xml");
        fromCSVtoXML.readingData();
    }
    @Test
    //PSUJA SIE POLSKIE ZNAKI
    public void isReadingFromCSVgood() throws IOException, JAXBException {
        assertEquals("Firma5 SP. Z O.O.",fromCSVtoXML.zbiorFaktur.getLista().get(0).getNazwaOdbiorcy());
        //assertEquals("UL. FELIKSA RADWANSKIEGO 15/1, 30-065 KRAKÓW",fromCSVtoXML.zbiorFaktur.getLista().get(0).getAdresOdbiorcy());
        assertEquals("634-27-26-447",fromCSVtoXML.zbiorFaktur.getLista().get(0).getNIPOdbiorcy());
        assertEquals("2020-10-09",fromCSVtoXML.zbiorFaktur.getLista().get(0).getDataWystawienia());
        assertEquals("2020-10-09",fromCSVtoXML.zbiorFaktur.getLista().get(0).getDataSprzedazy());
        assertEquals("3-09/10/2020",fromCSVtoXML.zbiorFaktur.getLista().get(0).getNrFaktury());
        //assertEquals("Czynsz z tytułu najmu powierzchni w budynku przy ul. Radwańskiego 15 w Krakowie za Październik 2020",fromCSVtoXML.zbiorFaktur.getLista().get(0).getTytulPozycji());
        assertEquals("1",fromCSVtoXML.zbiorFaktur.getLista().get(0).getLiczbaSztuk());
        //assertEquals("3 000,00 zł",fromCSVtoXML.zbiorFaktur.getLista().get(0).getCenaJednostkowa());
        assertEquals("23",fromCSVtoXML.zbiorFaktur.getLista().get(0).getStawkaPodatku());
        //assertEquals("690,00 zł",fromCSVtoXML.zbiorFaktur.getLista().get(0).getKwotaPodatku());
        //assertEquals("3 000,00 zł",fromCSVtoXML.zbiorFaktur.getLista().get(0).getCenaNettopozycji());
        //assertEquals("3 690,00 zł",fromCSVtoXML.zbiorFaktur.getLista().get(0).getCenaBruttopozycji());
       // assertEquals("3 000,00 zł",fromCSVtoXML.zbiorFaktur.getLista().get(0).getCenaNettofakturylacznie());
        //assertEquals("3 690,00 zł",fromCSVtoXML.zbiorFaktur.getLista().get(0).getCenaBruttofakturylacznie());
    }

}
