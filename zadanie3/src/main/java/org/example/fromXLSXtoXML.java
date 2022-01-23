package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class fromXLSXtoXML {
    FileInputStream file = new FileInputStream("C:\\Users\\FiFi\\PZ1\\zadanie3\\faktury-sprzedazowe-test.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(file);
    XSSFSheet sheet = workbook.getSheetAt(0);

    public fromXLSXtoXML() throws IOException {
    }

    int value_helper = 0;
    boolean if_its_header = true;
    ArrayList<FakturaXLSX> pomocniczalista = new ArrayList<>();
    XLSXfaktury XLSXfaktury = new XLSXfaktury();

    public void readingData() throws IOException, JAXBException {
        Iterator<Row> rowIterator = sheet.iterator();

        while(rowIterator.hasNext()) {   //ITEROWANIE PO WIERSZACH
            FakturaXLSX fakturaXLSX = new FakturaXLSX();
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {   //CELL IDZIE PO KOLUMNACH W PRAWO
                Cell cell = cellIterator.next();

                if (cell.getCellType() == CellType.NUMERIC) {
                    if (value_helper % 15 == 3) {
                        fakturaXLSX.setDataWystawienia(cell.getDateCellValue());
                        value_helper++;
                        System.out.println(cell.getDateCellValue() + "\t\t");
                        continue;
                    }
                    if (value_helper % 15 == 4) {
                        fakturaXLSX.setDataSprzedazy(cell.getDateCellValue());
                        value_helper++;
                        System.out.println(cell.getDateCellValue() + "\t\t");
                    }
                }
                if (cell.getCellType() == CellType.STRING) {
                    if (value_helper % 15 == 0) {
                        fakturaXLSX.setNazwaOdbiorcy(cell.getStringCellValue());
                        value_helper++;
                        System.out.println(cell.getStringCellValue() + "\t\t");
                        continue;
                    }
                    if (value_helper % 15 == 1) {
                        fakturaXLSX.setAdresOdbiorcy(cell.getStringCellValue());
                        value_helper++;
                        System.out.println(cell.getStringCellValue() + "\t\t");
                        continue;
                    }
                    if (value_helper % 15 == 2) {
                        fakturaXLSX.setNIPOdbiorcy(cell.getStringCellValue());
                        value_helper++;
                        System.out.println(cell.getStringCellValue() + "\t\t");
                        continue;
                    }
                    if (value_helper % 15 == 5) {
                        fakturaXLSX.setNrFaktury(cell.getStringCellValue());
                        value_helper++;
                        System.out.println(cell.getStringCellValue() + "\t\t");
                        continue;
                    }
                    if (value_helper % 15 == 6) {
                        fakturaXLSX.setTytulPozycji(cell.getStringCellValue());
                        value_helper++;
                        System.out.println(cell.getStringCellValue() + "\t\t");
                        continue;
                    }
                    if (value_helper % 15 == 7) {
                        fakturaXLSX.setLiczbaSztuk(cell.getStringCellValue());
                        value_helper++;
                        System.out.println(cell.getStringCellValue() + "\t\t");
                        continue;
                    }
                    if (value_helper % 15 == 8) {
                        fakturaXLSX.setCenaJednostkowa(cell.getStringCellValue());
                        value_helper++;
                        System.out.println(cell.getStringCellValue() + "\t\t");
                        continue;
                    }
                    if (value_helper % 15 == 9) {
                        fakturaXLSX.setStawkaPodatku(cell.getStringCellValue());
                        value_helper++;
                        System.out.println(cell.getStringCellValue() + "\t\t");
                        continue;
                    }
                    if (value_helper % 15 == 10) {
                        fakturaXLSX.setKwotaPodatku(cell.getStringCellValue());
                        value_helper++;
                        System.out.println(cell.getStringCellValue() + "\t\t");
                        continue;
                    }
                    if (value_helper % 15 == 11) {
                        fakturaXLSX.setCenaNettopozycji(cell.getStringCellValue());
                        value_helper++;
                        System.out.println(cell.getStringCellValue() + "\t\t");
                        continue;
                    }
                    if (value_helper % 15 == 12) {
                        fakturaXLSX.setCenaBruttopozycji(cell.getStringCellValue());
                        value_helper++;
                        System.out.println(cell.getStringCellValue() + "\t\t");
                        continue;
                    }
                    if (value_helper % 15 == 13) {
                        fakturaXLSX.setCenaNettofakturylacznie(cell.getStringCellValue());
                        value_helper++;
                        System.out.println(cell.getStringCellValue() + "\t\t");
                        continue;
                    }
                    if (value_helper % 15 == 14) {
                        fakturaXLSX.setCenaBruttofakturylacznie(cell.getStringCellValue());
                        value_helper++;
                        System.out.println(cell.getStringCellValue() + "\t\t");
                    }
                }
            }
            if(value_helper%15 == 0){
                System.out.println("");
            }
            if(!if_its_header) {
                pomocniczalista.add(fakturaXLSX);
            }
            if_its_header = false;
        }
        XLSXfaktury.setLista(pomocniczalista);

        JAXBContext context = JAXBContext.newInstance(XLSXfaktury.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(XLSXfaktury, new File("C:\\Users\\FiFi\\PZ1\\zadanie3\\fakturyfromXLSX.xml"));
    }
}

