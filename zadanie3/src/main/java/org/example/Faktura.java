package org.example;
import javax.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;


/** This class simply holds all the Faktura's fields */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Faktura {

    private String nazwaOdbiorcy;
    private String adresOdbiorcy;
    private String NIPOdbiorcy;
    private String dataWystawienia;
    private String dataSprzedazy;
    private String nrFaktury;
    private String tytulPozycji;
    private String liczbaSztuk;
    private String cenaJednostkowa;
    private String stawkaPodatku;
    private String kwotaPodatku;
    private String cenaNettopozycji;
    private String cenaBruttopozycji;
    private String cenaNettofakturylacznie;
    private String cenaBruttofakturylacznie;
}
