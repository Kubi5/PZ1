package org.example;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

/** This class is parsing XLSX format to XML */
public class fromXLSXtoXML {
    FileInputStream file;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    String inString;
    String outString;
/** Constructor */
    public fromXLSXtoXML(String inString, String outString) throws IOException {
        this.inString = inString;
        this.outString = outString;
        file = new FileInputStream("C:\\Users\\FiFi\\PZ1\\zadanie3\\" + inString);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheetAt(0);
    }

    ArrayList<Faktura> pomocniczalista = new ArrayList<>();
    ZbiorFaktur zbiorFaktur = new ZbiorFaktur();
/** This method is marshalling zbiorFaktur object into new XML file */
    public void marshalling() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ZbiorFaktur.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(zbiorFaktur, new File("C:\\Users\\FiFi\\PZ1\\zadanie3\\" + outString));
    }
/** This method is reading data from XLSX file and setting Faktura's fields */
    public void readingData() throws IOException, JAXBException {
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        while(rowIterator.hasNext()) {
            Faktura faktura = new Faktura();
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String strDate;

                Cell cell = cellIterator.next();
                if(cell.getCellType() == CellType.BLANK){
                    break;
                }
                    faktura.setNazwaOdbiorcy(cell.getStringCellValue());

                    cell = cellIterator.next();
                    faktura.setAdresOdbiorcy(cell.getStringCellValue());

                    cell = cellIterator.next();
                    faktura.setNIPOdbiorcy(cell.getStringCellValue());

                    cell = cellIterator.next();
                    strDate = formatter.format(cell.getDateCellValue());
                    faktura.setDataWystawienia(strDate);

                    cell = cellIterator.next();
                    strDate = formatter.format(cell.getDateCellValue());
                    faktura.setDataSprzedazy(strDate);

                    cell = cellIterator.next();
                    faktura.setNrFaktury(cell.getStringCellValue());
                    
                    cell = cellIterator.next();
                    faktura.setTytulPozycji(cell.getStringCellValue());

                    cell = cellIterator.next();
                    faktura.setLiczbaSztuk(String.valueOf(cell.getNumericCellValue()));

                    cell = cellIterator.next();
                    faktura.setCenaJednostkowa(cell.getStringCellValue());

                    cell = cellIterator.next();
                    faktura.setStawkaPodatku(String.valueOf(cell.getNumericCellValue()));

                    cell = cellIterator.next();
                    faktura.setKwotaPodatku(cell.getStringCellValue());

                    cell = cellIterator.next();
                    faktura.setCenaNettopozycji(cell.getStringCellValue());

                    cell = cellIterator.next();
                    faktura.setCenaBruttopozycji(cell.getStringCellValue());

                    cell = cellIterator.next();
                    faktura.setCenaNettofakturylacznie(cell.getStringCellValue());

                    cell = cellIterator.next();
                    faktura.setCenaBruttofakturylacznie(cell.getStringCellValue());

                    pomocniczalista.add(faktura);

        }
        zbiorFaktur.setLista(pomocniczalista);

        this.marshalling();
    }
}

