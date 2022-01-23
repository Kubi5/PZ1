package org.example;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class fromCSVtoXML {
    Reader in = new FileReader("C:\\Users\\FiFi\\PZ1\\zadanie3\\faktury-sprzedazowe-test.csv");
    //wczytanie pliku CSV
    Iterable<CSVRecord> records = CSVFormat.EXCEL
            .withDelimiter('\t')
            .parse(in);

    boolean isHeader = true;   //checks if its header

    public fromCSVtoXML() throws IOException {}
    Generowanie g = new Generowanie();

    ArrayList<FakturaCSV> pomocniczaLista = new ArrayList<>();
    public void readingData() throws JAXBException {

        for (CSVRecord record : records) {
            FakturaCSV faktura = new FakturaCSV();
            faktura.setNazwaOdbiorcy(record.get(0));
            faktura.setAdresOdbiorcy(record.get(1));
            faktura.setNIPOdbiorcy(record.get(2));
            faktura.setDataWystawienia(record.get(3));
            faktura.setDataSprzedazy(record.get(4));
            faktura.setNrFaktury(record.get(5));
            faktura.setTytulPozycji(record.get(6));
            faktura.setLiczbaSztuk(record.get(7));
            faktura.setCenaJednostkowa(record.get(8));
            faktura.setStawkaPodatku(record.get(9));
            faktura.setKwotaPodatku(record.get(10));
            faktura.setCenaNettopozycji(record.get(11));
            faktura.setCenaBruttopozycji(record.get(12));
            faktura.setCenaNettofakturylacznie(record.get(13));
            faktura.setCenaBruttofakturylacznie(record.get(14));
            if(!isHeader) {
                pomocniczaLista.add(faktura);
            }
            isHeader = false;
        }
        g.setLista(pomocniczaLista);

        JAXBContext context = JAXBContext.newInstance(Generowanie.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(g, new File("C:\\Users\\FiFi\\PZ1\\zadanie3\\fakturyfromCSV.xml"));
    }
}
