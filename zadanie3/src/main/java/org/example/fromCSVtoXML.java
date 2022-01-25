package org.example;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.ArrayList;
/** This class is parsing XLSX format to XML */
public class fromCSVtoXML {
    String stringIn;
    String stringOut;
    Reader in;
    //wczytanie pliku CSV
    Iterable<CSVRecord> records;
    public ArrayList<Faktura> pomocniczaLista = new ArrayList<>();
    boolean isHeader = true;   //checks if its header
/** Constructor */
    public fromCSVtoXML(String stringIn,String stringOut) throws IOException {
        this.stringIn = stringIn;
        this.stringOut = stringOut;
        in = new FileReader("C:\\Users\\FiFi\\PZ1\\zadanie3\\" + stringIn);
        records = CSVFormat.EXCEL
                .withDelimiter('\t')
                .parse(in);
    }
    public ZbiorFaktur zbiorFaktur = new ZbiorFaktur();
    /** This method is marshalling zbiorFaktur object into new XML file */
    public void marshalling() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ZbiorFaktur.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(zbiorFaktur, new File("C:\\Users\\FiFi\\PZ1\\zadanie3\\" + stringOut));
    }
    /** This method is reading data from CSV file and setting Faktura's fields*/
    public void readingData() throws JAXBException {

        for (CSVRecord record : records) {
            Faktura faktura = new Faktura();
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
        zbiorFaktur.setLista(pomocniczaLista);
        this.marshalling();
    }
}
