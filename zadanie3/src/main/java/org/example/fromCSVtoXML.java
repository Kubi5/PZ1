package org.example;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class fromCSVtoXML {
    Reader in = new FileReader("C:\\Users\\FiFi\\PZ1\\zadanie3\\faktury-sprzedazowe-test.csv");
    //wczytanie pliku CSV
    Iterable<CSVRecord> records = CSVFormat.EXCEL
            .withDelimiter('\t')
            .parse(in);
    ArrayList<Data> companysData = new ArrayList<>();

    public fromCSVtoXML() throws IOException {
    }

    boolean isHeader = true;   //checks if its header
    public void readingData() {
        for (CSVRecord record : records) {
            Data d = new Data();
            d.nazwaOdbiorcy = record.get(0);
            d.adresOdbiorcy = record.get(1);
            d.NIPodbiorcy = record.get(2);
            d.dataWystawienia = record.get(3);
            d.dataSprzedazy = record.get(4);
            d.nrFaktury = record.get(5);
            d.tytulPozycji = record.get(6);
            d.liczbaSztuk = record.get(7);
            d.cenaJednostkowa = record.get(8);
            d.stawkaPodatku = record.get(9);
            d.kwotaPodatku = record.get(10);
            d.cenaNettopozycji = record.get(11);
            d.cenaBruttopozycji = record.get(12);
            d.cenaNettofakturylacznie = record.get(13);
            d.cenaBruttofakturylacznie = record.get(14);

            if(!isHeader) companysData.add(d);
            isHeader = false;
        }
        for(Data d : companysData){
            System.out.println(d.nazwaOdbiorcy);
            System.out.println(d.adresOdbiorcy);
            System.out.println(d.NIPodbiorcy);
            System.out.println(d.dataWystawienia);
            System.out.println(d.dataSprzedazy);
            System.out.println(d.nrFaktury);
            System.out.println(d.tytulPozycji);
            System.out.println(d.liczbaSztuk);
            System.out.println(d.cenaJednostkowa);
            System.out.println(d.stawkaPodatku);
            System.out.println(d.kwotaPodatku);
            System.out.println(d.cenaNettopozycji);
            System.out.println(d.cenaBruttopozycji);
            System.out.println(d.cenaNettofakturylacznie);
            System.out.println(d.cenaBruttofakturylacznie);
            System.out.println("=======");
        }
    }
}
